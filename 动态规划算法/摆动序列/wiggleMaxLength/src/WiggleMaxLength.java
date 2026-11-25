import java.util.Arrays;

/**
 * http://leetcode.cn/problems/wiggle-subsequence/
 *
 * @ClassName: WiggleMaxLength
 * @Author: JacksonLee
 * @Date: 2026/11/25
 */
public class WiggleMaxLength {

    /**
     * 动态规划:子序列问题
     *
     * @param nums 输入数组
     * @return int
     */
    public int wiggleMaxLength(int[] nums) {
        // 预处理
        int n = nums.length;

        // 创建状态表
        // dpUp[i]表示以i位置为结尾的所有子序列中最后一个位置呈现"上升"趋势的最长摆动序列的长度
        int[] dpUp = new int[n];
        // dpDown[i]表示以i位置为结尾的所有子序列中最后一个位置呈现"下降"趋势的最长摆动序列的长度
        int[] dpDown = new int[n];

        // 初始化:将两张表的值初始化为1
        Arrays.fill(dpUp, 1);
        Arrays.fill(dpDown, 1);

        // 从左往右填表
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dpUp[i] = Math.max(dpUp[i], dpDown[j]+1);
                } else if (nums[j] > nums[i]) {
                    dpDown[i] = Math.max(dpDown[i], dpUp[j]+1);
                }
            }
            ans = Math.max(ans, Math.max(dpUp[i], dpDown[i]));
        }

        // 返回结果:两张表的最大值
        return ans;
    }

}
