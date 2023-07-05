package cc11001100.evil.server;

import javax.naming.NamingException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author CC11001100
 */
public class EvilServer {

    private HttpServer httpServer;
    private RmiServer rmiServer;

    public void runServer() throws AlreadyBoundException, NamingException, RemoteException {

        this.httpServer = new HttpServer(10086);
        httpServer.run();

        new LdapServer(10010).run(httpServer.getServerUrl());
    }

    public void shutdown() throws NotBoundException, RemoteException {
        this.httpServer.shutdown();
        this.rmiServer.shutdown();
    }

    public static void main(String[] args) throws NamingException, RemoteException, AlreadyBoundException {

        new EvilServer().runServer();

    }

}
