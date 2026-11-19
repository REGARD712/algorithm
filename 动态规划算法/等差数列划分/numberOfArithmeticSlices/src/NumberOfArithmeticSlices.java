/**
 * https://leetcode.cn/problems/arithmetic-slices/
 *
 * @ClassName: NumberOfArithmeticSlices
 * @Author: JacksonLee
 * @Date: 2026/11/19
 */
public class NumberOfArithmeticSlices {

    /**
     * 子数组问题
     *
     * @param nums 输入数组
     * @return int
     */
    public int numberOfArithmeticSlices(int[] nums) {
        // 预处理
        int n = nums.length;

        // 创建dp表
        int[] dp = new int[n];

        // 从左往右填表
        int ans = 0;
        for (int i = 2; i < n; i++) {
            dp[i] = (nums[i]-nums[i-1]) == (nums[i-1]-nums[i-2]) ? dp[i-1]+1 : 0;
            ans += dp[i];
        }

        // 返回结果:dp表所有值之和
        return ans;
    }

}
