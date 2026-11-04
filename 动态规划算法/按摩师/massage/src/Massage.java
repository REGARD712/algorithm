/**
 * https://leetcode.cn/problems/the-masseuse-lcci/
 *
 * @ClassName: Massage
 * @Author: JacksonLee
 * @Date: 2026/11/4
 */
public class Massage {

    /**
     * 多状态dp
     *
     * @param nums 预约时间数组
     * @return int
     */
    public int massage(int[] nums) {
        // 预处理
        int n = nums.length;

        // 边界情况
        if (n == 0) {
            return 0;
        }

        // 两个状态对应两个dp表
        int[] dpY = new int[n]; // 选择[i]位置时的最优预约时长
        int[] dpN = new int[n]; // 不选[i]位置时的最优预约时长

        // 初始化
        dpY[0] = nums[0];

        // 从左到右填两个dp表
        for (int i = 1; i < n; i++) {
            dpY[i] = dpN[i-1] + nums[i];
            dpN[i] = Math.max(dpY[i-1], dpN[i-1]);
        }

        // 返回结果:到达最终位置时两种情况,取最大值返回
        return Math.max(dpY[n-1], dpN[n-1]);
    }
}
