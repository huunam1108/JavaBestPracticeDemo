package string.comparision;

import java.util.Objects;

/**
 * This is make for de-compile code to view bytecode, for performance see jmh package.
 */
@Deprecated
public class StringComparision {
    public static void main(String[] args) {

        String a = new String("1000");
        String b = "1000";
        System.out.println(a == b); // false
        String c = "1000";
        System.out.println(c == b); // true
        System.out.println(a.equals(b)); // true
        System.out.println(a.equalsIgnoreCase(b)); // true


        StringComparision cp = new StringComparision();
        cp.equals1();
        cp.equals2();
        cp.equals3();
        cp.equalsIgnoreCase1();
        cp.equalsIgnoreCase2();
        cp.equalsIgnoreCase3();
        cp.objectEquals1();
        cp.objectEquals2();
        cp.objectEquals3();
        System.out.println();
    }

    private void equals1() {
        String s = "H" + "elloWorld";
        String p = "HelloWorl" + "d";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e7; i++) {
            s.equals(p);
        }
        System.out.println("Equals1 Time: " + (System.currentTimeMillis() - start));
    }

    private void equals2() {
        String s = "HelloWorld";
        String p = "HelloWorlD";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e7; i++) {
            s.equals(p);
        }
        System.out.println("Equals2 Time: " + (System.currentTimeMillis() - start));
    }

    private void equals3() {
        String s = "HelloWorld";
        String p = "HelloWorld1";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e7; i++) {
            s.equals(p);
        }
        System.out.println("Equals3 Time: " + (System.currentTimeMillis() - start));
    }

    private void equalsIgnoreCase1() {
        String s = "H" + "elloWorld";
        String p = "HelloWorl" + "d";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e7; i++) {
            s.equals(p);
        }
        System.out.println("EqualsIgnoreCase1 Time: " + (System.currentTimeMillis() - start));
    }

    private void equalsIgnoreCase2() {
        String s = "HelloWorld";
        String p = "HelloWorlD";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e7; i++) {
            s.equalsIgnoreCase(p);
        }
        System.out.println("EqualsIgnoreCase2 Time: " + (System.currentTimeMillis() - start));
    }

    private void equalsIgnoreCase3() {
        String s = "HelloWorld";
        String p = "HelloWorld1";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e7; i++) {
            s.equalsIgnoreCase(p);
        }
        System.out.println("EqualsIgnoreCase3 Time: " + (System.currentTimeMillis() - start));
    }


    private void objectEquals1() {
        String s = "H" + "elloWorld";
        String p = "HelloWorl" + "d";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e7; i++) {
            Objects.equals(s, p);
        }
        System.out.println("ObjectEquals1 Time: " + (System.currentTimeMillis() - start));
    }

    private void objectEquals2() {
        String s = "HelloWorld";
        String p = "HelloWorlD";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e7; i++) {
            Objects.equals(s, p);
        }
        System.out.println("ObjectEquals2 Time: " + (System.currentTimeMillis() - start));
    }

    private void objectEquals3() {
        String s = "HelloWorld";
        String p = "HelloWorld1";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e7; i++) {
            Objects.equals(s, p);
        }
        System.out.println("ObjectEquals3 Time: " + (System.currentTimeMillis() - start));
    }
}
