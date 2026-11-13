/**
 * https://leetcode.cn/problems/maximum-subarray/
 *
 * @ClassName: MaxSubArray
 * @Author: JacksonLee
 * @Date: 2026/11/13
 */
public class MaxSubArray {

    /**
     * 子数组问题
     *
     * @param nums 输入数组
     * @return int
     */
    public int maxSubArray(int[] nums) {
        // 预处理
        int n = nums.length;

        // 创建dp表(虚拟节点用于防止填表时越界访问)
        int[] dp = new int[n+1];

        // 从左往右填表
        for (int i = 1; i <= n; i++) {
            // 情况一是自己,情况二是与前面最长的子数组组合
            dp[i] = Math.max(nums[i-1], dp[i-1]+nums[i-1]);
        }

        // 返回结果:dp表中的最大值
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
