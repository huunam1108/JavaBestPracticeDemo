package trycatch;

public class OutsideTheLoop {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 1e7; i++) {
                Integer.parseInt("" + i);
            }
        } catch (NumberFormatException ignore) {
        }
    }
}
