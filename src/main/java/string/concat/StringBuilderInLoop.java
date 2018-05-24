package string.concat;

/**
 * This is make for de-compile code to view bytecode, for performance see jmh package.
 */
@Deprecated
public class StringBuilderInLoop {
    public static void main(String[] args) {
        String result = "";
        for (int i = 0; i < 1e6; i++) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(result);
            tmp.append("Some More Data");
            result = tmp.toString();
        }
        System.out.println(result);
    }
}
