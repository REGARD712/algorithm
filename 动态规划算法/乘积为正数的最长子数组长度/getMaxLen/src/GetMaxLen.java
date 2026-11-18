/**
 * https://leetcode.cn/problems/maximum-length-of-subarray-with-positive-product/
 *
 * @ClassName: GetMaxLen
 * @Author: JacksonLee
 * @Date: 2026/11/18
 */
public class GetMaxLen {

    /**
     * 子数组问题
     *
     * @param nums 输入数组
     * @return int
     */
    public int getMaxLen(int[] nums) {
        // 预处理
        int n = nums.length;

        // 创建两个状态表:多开一个虚拟节点防止填表时越界访问
        // dpP[i]表示以i位置为结尾的所有子数组中乘积为正数的子数组的最长长度
        int[] dpP = new int[n+1];
        // dpN[i]表示以i位置为结尾的所有子数组中乘积为负数的子数组的最长长度
        int[] dpN = new int[n+1];

        // 从左往右填表
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            // 判断nums[i-1]正负,分为两种情况
            if (nums[i-1] > 0) {
                dpP[i] = dpP[i-1] + 1;
                dpN[i] = dpN[i-1] == 0 ? 0 : dpN[i-1]+1;
            } else if (nums[i-1] < 0) {
                dpP[i] = dpN[i-1] == 0 ? 0 : dpN[i-1] + 1;
                dpN[i] = dpP[i-1] + 1;
            }
            ans = Math.max(dpP[i], ans);
        }

        // 返回结果:dpP表的最大值(填表时同步找出)
        return ans;
    }

}
