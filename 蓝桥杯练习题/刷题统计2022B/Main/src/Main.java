import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        long a = in.nextLong(), b = in.nextLong(), n = in.nextLong();
        long sum = 0, weekSum = 5 * a + 2 * b, t = n % weekSum;
        if (t == 0) {   // 若总题数能在若干周内刷完
            System.out.println(7 * (n / weekSum));
        } else {
            long days = 7 * (n / weekSum);
            for (int i = 1; i <= 7; i++) {
                if (i <= 5) {
                    t -= a;
                } else {
                    t -= b;
                }
                if (t <= 0) {
                    System.out.println(days + i);
                    break;
                }
            }
        }
    }
}