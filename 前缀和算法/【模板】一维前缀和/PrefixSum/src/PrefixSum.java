import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), m = in.nextInt();
        // 1. 创建初始数组
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }

        // 2. 处理前缀和数组
        // 为防止数据过大导致溢出，使用long类型数据
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        // 3. 使用前缀和数组解决问题
        for (int i = 0; i < m; i++) {
            int l = in.nextInt(), r = in.nextInt();
            long ret = dp[r] - dp[l - 1];
            System.out.println(ret);
        }
    }
}
