import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/
 *
 * @ClassName: FindLongestChain
 * @Author: JacksonLee
 * @Date: 2026/11/27
 */
public class FindLongestChain {

    /**
     * 动态规划:子序列问题
     *
     * @param pairs 数对数组
     * @return int
     */
    public int findLongestChain(int[][] pairs) {
        // 预处理
        int n = pairs.length;
        // 按照第一个元素升序排序
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        // 创建dp表
        // dp[i]表示以i位置为结尾的所有数对链中最长数对链的长度
        int[] dp = new int[n];

        // 初始化
        Arrays.fill(dp, 1);

        // 从左往右填表
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            ans = Math.max(dp[i], ans);
        }

        // 返回结果:dp表的最大值
        return ans;
    }

}
