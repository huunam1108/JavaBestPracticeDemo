package string.concat;

/**
 * This is make for de-compile code to view bytecode, for performance see jmh package.
 */
@Deprecated
public class StringPlus3 {
    private static final String some = "Some ";
    private static final String more = "More ";
    private static final String data = "Data";

    public static void main(String[] args) {
        String result = "";
        result += some + more + data;
        System.out.println(result);
    }
}
