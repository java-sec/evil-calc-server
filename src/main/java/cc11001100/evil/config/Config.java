package cc11001100.evil.config;

import java.io.IOException;
import java.util.Properties;

/**
 * @author CC11001100
 */
public class Config {

    // 默认的http端口
    public static final int DEFAULT_HTTP_PORT = 10088;

    // 默认的ladp端口
    public static final int DEFAULT_LDAP_PORT = 10089;

    private int httpPort;
    private int ldapPort;

    public Config() {
        this(DEFAULT_HTTP_PORT, DEFAULT_LDAP_PORT);
    }

    public Config(String configPath) throws IOException {
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(configPath));
        this.httpPort = this.parseIntOrDefault(properties.get("http.port"), DEFAULT_HTTP_PORT);
        this.ldapPort = this.parseIntOrDefault(properties.get("ldap.port"), DEFAULT_LDAP_PORT);
    }

    public Config(int httpPort, int ldapPort) {
        this.httpPort = httpPort;
        this.ldapPort = ldapPort;
    }

    private int parseIntOrDefault(Object o, int defaultValue) {
        if (o == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(o.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public int getHttpPort() {
        return this.httpPort;
    }

    public int getLdapPort() {
        return this.ldapPort;
    }

}
