import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), x = 0;
        long sum1 = 0, sum2 = 0, ret = 0;
        for (int i = 0; i < n; i++) {
            x = in.nextInt();
            sum1 += x;
            sum2 += x * x;
        }
        sum1 = sum1 * sum1;
        ret = (sum1 - sum2) / 2;
        System.out.println(ret);
    }
}