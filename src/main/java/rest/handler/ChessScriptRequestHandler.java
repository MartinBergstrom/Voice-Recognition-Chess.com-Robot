package rest.handler;

import base.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.AnnotationValidationEngine;
import rest.model.ChessBoardMetaData;
import rest.model.MovePiece;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Singleton
@Path("chess")
public class ChessScriptRequestHandler {
    private static final Gson GSON =  new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private final ChessBoard myChessBoard;
    private final CoordinateResolver myCoordinateResolver;
    private final RobotHandler myRobotHandler;

    public ChessScriptRequestHandler() throws AWTException {
        myChessBoard = new ChessBoard();
        myCoordinateResolver = new CoordinateResolver(myChessBoard);
        myRobotHandler = new RobotHandler();
    }

    @Path("/move")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response moveChessPiece(String payload)
    {
        MovePiece movePiece = GSON.fromJson(payload, MovePiece.class);

        try {
            AnnotationValidationEngine.runValidationOnBean(movePiece);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500)
                    .entity("Validation failed with: " + e.getMessage())
                    .build();
        }

        Coordinate startCoord = myChessBoard.getStartingCoordinate();
        if (startCoord == null) {
            return Response.status(500)
                    .entity("No start coordinate set, updateBoardSize needs to be called prior to this")
                    .build();
        }

        Pair<Coordinate> coordinates = myCoordinateResolver.convert(movePiece);
        myRobotHandler.moveMouse(startCoord);
        myRobotHandler.moveAndClickHold(coordinates.getFirst());
        myRobotHandler.moveMouse(coordinates.getSecond());
        myRobotHandler.releaseMouseClick();

        return Response.status(201).build();
    }

    @Path("/updateBoardMeta")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateBoardSize(String payload)
    {
        System.out.println("got updateBoard meta");
        ChessBoardMetaData chessBoardMetaData = GSON.fromJson(payload, ChessBoardMetaData.class);
        myChessBoard.setWidth(chessBoardMetaData.getBoardWidth());
        chessBoardMetaData.getStartingCoordinate().ifPresent(myChessBoard::setStartingCoordinate);
        return Response.status(201).build();
    }
}
