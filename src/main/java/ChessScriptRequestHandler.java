import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.MovePiece;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("chess")
public class ChessScriptRequestHandler {
    private static final Gson GSON =  new GsonBuilder()
            .setPrettyPrinting()
            .create();

    @Path("/move")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String moveChessPiece(String payload)
    {
        MovePiece movePiece = GSON.fromJson(payload, MovePiece.class);
        return "Got the post request payload: " + payload;
    }

    @Path("/updateBoardSize")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateBoardSize(String payload)
    {
        return "Got the post request payload: " + payload;
    }
}
