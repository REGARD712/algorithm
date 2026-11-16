/**
 * https://leetcode.cn/problems/maximum-sum-circular-subarray/
 *
 * @ClassName: MaxSubarraySumCircular
 * @Author: JacksonLee
 * @Date: 2026/11/16
 */
public class MaxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] nums) {
        // 预处理
        int n = nums.length, sum = 0;

        // 创建两个状态表:多开一个作为虚拟节点,防止填表时越界访问
        // dpMax[i]表示以i位置为结尾的所有子数组中的最大和
        int[] dpMax = new int[n+1];
        // dpMin[i]表示以i位置为结尾的所有子数组中的最小和
        int[] dpMin = new int[n+1];

        // 从左往右填表:注意访问nums时下标的映射关系
        for (int i = 1; i <= n; i++) {
            dpMax[i] = Math.max(nums[i-1], dpMax[i-1]+nums[i-1]);
            dpMin[i] = Math.min(nums[i-1], dpMin[i-1]+nums[i-1]);
            sum += nums[i-1];
        }

        // 先找到dpMax表的最大值、dpMin表中的最小值
        int ans = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dpMax[i], max);
            min = Math.min(dpMin[i], min);
            ans = sum == min ? max : Math.max(max, sum-min);
        }
        // 返回结果
        return ans;
    }

}
