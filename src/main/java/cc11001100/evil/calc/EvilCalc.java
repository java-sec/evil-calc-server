import java.io.IOException;

/**
 * @author CC11001100
 */
public class EvilCalc {

    private final String MAC_CALC = "open /System/Applications/Calculator.app";
    private final String WINDOWS_CALC = "calc";

    public EvilCalc() throws IOException {
        if (isWindows()) {
            Runtime.getRuntime().exec(WINDOWS_CALC);
        } else if (isMac()) {
            Runtime.getRuntime().exec(MAC_CALC);
        } else {
            // oh, fuck...
        }
    }

    private boolean isMac() {
        String property = System.getProperty("os.name");
        if (property == null) {
            return false;
        }
        return property.contains("Mac OS");
    }

    private boolean isWindows() {
        String property = System.getProperty("os.name");
        if (property == null) {
            return false;
        }
        return property.contains("Windows");
    }

}
