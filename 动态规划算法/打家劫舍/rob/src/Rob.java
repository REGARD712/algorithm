/**
 * https://leetcode.cn/problems/house-robber/
 *
 * @ClassName: Rob
 * @Author: JacksonLee
 * @Date: 2026/11/5
 */
public class Rob {

    /**
     * 多状态dp
     *
     * @param nums 房屋金额数组
     * @return int
     */
    public int rob(int[] nums) {
        // 预处理
        int n = nums.length;

        // 创建dp表(dpY表示选,dpN表示不选)
        int[] dpY = new int[n];
        int[] dpN = new int[n];

        // 初始化
        dpY[0] = nums[0];

        // 从左往右填表
        for (int i = 1; i < n; i++) {
            dpY[i] = dpN[i-1] + nums[i];
            dpN[i] = Math.max(dpY[i-1], dpN[i-1]);
        }

        // 返回结果
        return Math.max(dpY[n-1], dpN[n-1]);
    }
}
