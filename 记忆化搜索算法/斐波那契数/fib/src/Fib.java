import java.util.Arrays;

public class Fib {
    int[] memo; // 采用记忆数组当作备忘录

    public int fib(int n) {
        memo = new int[31]; Arrays.fill(memo, -1); // 初始化为-1
        return dfs(n);
    }

    private int dfs(int n) {
        // 在展开之前先去备忘录搜寻
        if (memo[n] != -1) {
            return memo[n];
        }

        // 递归出口
        if (n == 0 || n == 1) {
            memo[n] = n;
            return n;
        }

        // 在返回之前先存入备忘录
        memo[n] = dfs(n-1) + dfs(n-2);
        return memo[n];
    }
}
