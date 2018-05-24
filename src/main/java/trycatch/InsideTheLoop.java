package trycatch;

public class InsideTheLoop {
    public static void main(String[] args) {
        for (int i = 0; i < 17; i++) {
            System.out.println(i);
            try {
                Integer.parseInt(" x" + i);
            } catch (NumberFormatException ignore) {
            }
        }
    }
}
