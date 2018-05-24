package string.concat;

/**
 * This is make for de-compile code to view bytecode, for performance see jmh package.
 */
@Deprecated
public class StringPlus {
    public static void main(String[] args) {
        String result = "";
        result += "Some More Data";
        System.out.println(result);
    }
}
