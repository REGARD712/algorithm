/**
 * https://leetcode.cn/problems/maximum-product-subarray/
 *
 * @ClassName: MaxProduct
 * @Author: JacksonLee
 * @Date: 2026/11/17
 */
public class MaxProduct {

    /**
     * 子数组问题
     *
     * @param nums 输入数组
     * @return int
     */
    public int maxProduct(int[] nums) {
        // 预处理
        int n = nums.length;

        // 创建两个状态表:多开一个虚拟节点用来防止填表时越界访问
        // dpMax[i]表示以i位置为结尾的所有子数组中的最大乘积
        int[] dpMax = new int[n+1];
        // dpMin[i]表示以i位置为结尾的所有子数组中的最小乘积
        int[] dpMin = new int[n+1];

        // 初始化:dpMax[0]=dpMin[0]=1
        dpMax[0] = dpMin[0] = 1;

        // 从左往右填表
        for (int i = 1; i <= n; i++) {
            // 情况一:自己为一个子数组;情况二:与前面的组合为一个子数组(按正负数分两种情况)
            // 为正数:dpMax[i-1]*nums[i-1];为负数dpMin[i-1]*nums[i-1]
            dpMax[i] = Math.max(nums[i-1], Math.max(dpMax[i-1]*nums[i-1], dpMin[i-1]*nums[i-1]));
            // 情况一:自己为一个子数组;情况二:与前面的组合为一个子数组(按正负数分两种情况)
            // 为正数:dpMin[i-1]*nums[i-1];为负数dpMax[i-1]*nums[i-1]
            dpMin[i] = Math.min(nums[i-1], Math.min(dpMin[i-1]*nums[i-1], dpMax[i-1]*nums[i-1]));
        }

        // 返回结果:dpMax表的最大值
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(dpMax[i], ans);
        }
        return ans;
    }

}
