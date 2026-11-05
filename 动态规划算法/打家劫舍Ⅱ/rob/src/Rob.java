/**
 * https://leetcode.cn/problems/house-robber-ii/
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

        // 分两种情况:
        // 1.第一个房屋偷,则第二个房屋和最后一个房屋也不能偷,相当于nums[0]+rob1(2, n-2)
        // 2.第一个房屋不偷,此时就相当于rob1(1, n-1)
        return Math.max(nums[0] + rob1(nums, 2, n-2), rob1(nums, 1, n-1));
    }

    // 打家劫舍1的逻辑
    public int rob1(int[] nums, int left, int right) {
        // 边界情况
        if (left > right) {
            return 0;
        }

        // 预处理
        int n = nums.length;

        // 创建dp表(dpY表示偷，dpN表示不偷)
        int[] dpY = new int[n];
        int[] dpN = new int[n];

        // 初始化
        dpY[left] = nums[left];

        // 从左往右填表
        for (int i = 1+left; i <= right; i++) {
            dpY[i] = dpN[i-1] + nums[i];
            dpN[i] = Math.max(dpY[i-1], dpN[i-1]);
        }

        // 返回结果
        return Math.max(dpY[right], dpN[right]);
    }
}
