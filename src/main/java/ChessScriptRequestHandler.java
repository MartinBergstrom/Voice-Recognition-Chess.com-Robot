import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("chess")
public class ChessScriptRequestHandler {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(String payload)
    {
        return "Got the post request payload: " + payload;
    }
}
