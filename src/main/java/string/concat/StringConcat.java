package string.concat;

/**
 * This is make for de-compile code to view bytecode, for performance see jmh package.
 */
@Deprecated
public class StringConcat {
    public static void main(String[] args) {
        String result = "";
        result = result.concat("Some More Data");
        System.out.println(result);
    }
}
