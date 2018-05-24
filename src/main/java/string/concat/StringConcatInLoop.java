package string.concat;

/**
 * This is make for de-compile code to view bytecode, for performance see jmh package.
 */
@Deprecated
public class StringConcatInLoop {
    public static void main(String[] args) {
        String result = "";
        for (int i = 0; i < 1e6; i++) {
            result = result.concat("Some More Data");
        }
    }
}
