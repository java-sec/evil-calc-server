import java.io.IOException;
import java.io.Serializable;

/**
 * 创建类的实例时会弹出计算器，仅支持Window和Mac OS，Linux自行修改要执行的命令自己编译
 *
 * @author CC11001100
 */
public class EvilCalc implements Serializable {

    // Mac弹计算器
    private final String MAC_CALC = "open /System/Applications/Calculator.app";

    // Windows弹计算器
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
