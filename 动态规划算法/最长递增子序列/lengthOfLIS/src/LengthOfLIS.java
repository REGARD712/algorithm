import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 *
 * @ClassName: LengthOfLIS
 * @Author: JacksonLee
 * @Date: 2026/11/24
 */
public class LengthOfLIS {

    /**
     * 子序列问题
     *
     * @param nums 输入数组
     * @return int
     */
    public int lengthOfLIS(int[] nums) {
        // 预处理
        int n = nums.length;

        // 创建状态表
        int[] dp = new int[n];

        // 初始化:将dp表所有值初始化为1
        Arrays.fill(dp, 1);

        // 从左往右填表
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        // 返回结果:dp表最大值
        return ans;
    }

}
