/**
 * https://leetcode.cn/problems/delete-and-earn/
 *
 * @ClassName: DeleteAndEarn
 * @Author: JacksonLee
 * @Date: 2026/11/6
 */
public class DeleteAndEarn {

    /**
     * 多状态dp
     *
     * @param nums 输入数组
     * @return int
     */
    public int deleteAndEarn(int[] nums) {
        // 预处理
        int n = 10001;
        // 将nums中的所有数映射到arr
        int[] arr = new int[n];
        for (int num : nums) {
            arr[num] += num;
        }

        // 创建两个dp表
        // dpY表示到某位置必须选择该位置的情况下的最大点数
        int[] dpY = new int[n];
        // dpN表示到某位置不选择该位置的情况下的最大点数
        int[] dpN = new int[n];

        // 初始化
        dpY[0] = arr[0];

        // 从左往右填两个表
        for (int i = 1; i < n; i++) {
            dpY[i] = dpN[i-1] + arr[i];
            dpN[i] = Math.max(dpY[i-1], dpN[i-1]);
        }

        // 返回结果:最后一个位置两种情况的较大值
        return Math.max(dpY[n-1], dpN[n-1]);
    }
}
