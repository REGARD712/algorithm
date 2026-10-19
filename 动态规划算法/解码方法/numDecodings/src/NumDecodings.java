/**
 * https://leetcode.cn/problems/decode-ways/
 *
 * @ClassName: NumDecodings
 * @Author: JacksonLee
 * @Date: 2026/10/19
 */
public class NumDecodings {
    public int numDecodings(String s) {
        // 预处理
        char[] ss = s.toCharArray();
        int n = ss.length;

        // 创建dp表
        int[] dp = new int[n];

        // 初始化第一个字符
        dp[0] = ss[0] == '0' ? 0 : 1;

        // 边界情况
        if (n == 1) {
            return dp[0];
        }

        // 初始化第二个字符
        if (ss[0] != '0' && ss[1] != '0') {
            dp[1] += 1;
        }
        int temp = (ss[0] -'0') * 10 + ss[1] - '0';
        if (temp >= 10 && temp <= 26) {
            dp[1] += 1;
        }

        // 从左往右填表
        for (int i = 2; i < n; i++) {
            // 考虑位置i能否单独解码
            if (ss[i] != '0') {
                // 能单独解码
                dp[i] += dp[i-1];
            }
            // 考虑位置i能否和前一个字符合并解码
            temp = (ss[i-1] - '0') * 10 + ss[i] - '0';
            if (temp >= 10 && temp <= 26) {
                dp[i] += dp[i-2];
            }
        }

        // 返回结果
        return dp[n-1];
    }
}
