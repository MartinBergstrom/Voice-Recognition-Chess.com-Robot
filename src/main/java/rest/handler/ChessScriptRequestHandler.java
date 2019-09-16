package rest.handler;

import base.RobotHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import base.ChessBoard;
import base.CoordinateResolver;
import rest.model.BoardSize;
import rest.model.MovePiece;

import javax.inject.Singleton;
import javax.ws.rs.*;
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
        return Response.status(201)
                .entity("Got the put request payload: " + payload)
                .build();
    }

    @Path("/updateBoardSize")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateBoardSize(String payload)
    {
        BoardSize boardSize = GSON.fromJson(payload, BoardSize.class);
        myChessBoard.setWidth(boardSize.getBoardWidth());
        return Response.status(201).build();
    }
}
