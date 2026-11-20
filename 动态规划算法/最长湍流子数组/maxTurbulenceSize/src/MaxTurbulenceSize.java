import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-turbulent-subarray/
 *
 * @ClassName: MaxTurbulenceSize
 * @Author: JacksonLee
 * @Date: 2026/11/20
 */
public class MaxTurbulenceSize {

    /**
     * 子数组问题
     *
     * @param arr 输入数组
     * @return int
     */
    public int maxTurbulenceSize(int[] arr) {
        // 预处理
        int n = arr.length;

        // 创建状态表
        // dpUp[i]表示以i位置为结尾的子数组中最后呈现"上升"状态的最长湍流子数组的长度
        int[] dpUp = new int[n];
        // dpDown[i]表示以i位置为结尾的子数组中最后呈现"下降"状态的最长湍流子数组的长度
        int[] dpDown = new int[n];

        // 初始化:将两张表的所有值都初始化为1
        Arrays.fill(dpUp, 1);
        Arrays.fill(dpDown, 1);

        // 从左往右填两张表
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i-1] > arr[i]) {
                dpDown[i] = dpUp[i-1] + 1;
            } else if (arr[i-1] < arr[i]) {
                dpUp[i] = dpDown[i-1] + 1;
            }
            ans = Math.max(ans, Math.max(dpUp[i], dpDown[i]));
        }

        // 返回结果:两张表的最大值
        return ans;
    }

}
