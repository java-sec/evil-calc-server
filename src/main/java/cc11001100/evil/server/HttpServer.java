package cc11001100.evil.server;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * @author CC11001100
 */
public class HttpServer {

    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void run() {
        Spark.port(port);
        Spark.staticFiles.location("/public");
        Spark.get("/", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return null;
            }
        });
        System.out.println("http server url: " + this.getServerUrl());
    }

    public void shutdown() {
        Spark.stop();
    }

    public String getFileUrl(String filepath) {
        // http://localhost:${port}/EvilClass.class
        return String.format("http://localhost:%d/%s", this.port, filepath);
    }

    public String getServerUrl() {
        return String.format("http://localhost:%d", this.port);
    }

}
