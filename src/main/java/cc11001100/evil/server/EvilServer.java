package cc11001100.evil.server;

import cc11001100.evil.config.Config;

import javax.naming.NamingException;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author CC11001100
 */
public class EvilServer {

    // 配置文件默认的名称
    public static final String DEFAULT_CONFIG_NAME = "application.properties";

    private HttpServer httpServer;
    private RmiServer rmiServer;

    private Config config;

    public EvilServer() {
        this(new Config());
    }

    public EvilServer(String configName) throws IOException {
        this(new Config(configName));
    }

    public EvilServer(Config config) {
        this.config = config;
    }

    public void runServer() throws AlreadyBoundException, NamingException, IOException {

        this.httpServer = new HttpServer(this.config.getHttpPort());
        httpServer.run();

        new LdapServer(this.config.getLdapPort()).run(httpServer.getServerUrl());
    }

    public void shutdown() throws NotBoundException, RemoteException {
        this.httpServer.shutdown();
        this.rmiServer.shutdown();
    }

    public static void main(String[] args) throws NamingException, IOException, AlreadyBoundException {

        new EvilServer("application.properties").runServer();

    }

}
