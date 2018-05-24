package string.concat;

/**
 * This is make for de-compile code to view bytecode, for performance see jmh package.
 */
@Deprecated
public class StringBuilderInLoopOptimized {
    public static void main(String[] args) {
        String result;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < 1e6; i++) {
            tmp.append("Some More Data");
        }
        result = tmp.toString();
        System.out.println(result);
    }
}
