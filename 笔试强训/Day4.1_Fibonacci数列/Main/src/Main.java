import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        // 数组轮转斐波那契数列
        int a = 0, b = 1, c = 1;
        while (n > c) {
            a = b;
            b = c;
            c = a + b;
        }

        System.out.println(Math.min(c - n, n - b));
    }
}
