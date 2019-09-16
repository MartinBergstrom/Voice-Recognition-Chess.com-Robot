import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import rest.handler.ChessScriptRequestHandler;

import java.awt.*;

public class JettyServer {
    public static final String PORT = "8045";

    public JettyServer() throws AWTException {
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");

        Server jettyServer = new Server(Integer.valueOf(PORT));

        ServletContainer container = new ServletContainer(createResourceConfig());
        ServletHolder servletHolder = new ServletHolder(container);

        handler.addServlet(servletHolder, "/*");
        jettyServer.setHandler(handler);

        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ResourceConfig createResourceConfig() throws AWTException {
        ResourceConfig resourceConfig = new ResourceConfig();
        ChessScriptRequestHandler chessScriptRequestHandler = new ChessScriptRequestHandler();
        resourceConfig.register(chessScriptRequestHandler);
        return resourceConfig;
    }

}

