package string.concat;

/**
 * This is make for de-compile code to view bytecode, for performance see jmh package.
 */
@Deprecated
public class StringPlus2 {
    public static void main(String[] args) {
        String result = "";
        String a = "Some ";
        String b = "More ";
        String c = "Data";
        result += a + b + c;
        System.out.println(result);
    }
}
