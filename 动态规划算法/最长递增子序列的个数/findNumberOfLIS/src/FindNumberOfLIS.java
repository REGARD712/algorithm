import java.util.Arrays;

/**
 * https://leetcode.cn/problems/number-of-longest-increasing-subsequence/
 *
 * @ClassName: FindNumberOfLIS
 * @Author: JacksonLee
 * @Date: 2026/11/26
 */
public class FindNumberOfLIS {

    /**
     * 动态规划:子序列问题
     *
     * @param nums 输入数组
     * @return int
     */
    public int findNumberOfLIS(int[] nums) {
        // 预处理
        int n = nums.length;

        // 创建状态表
        // dpLen[i]表示以i位置为结尾的所有子序列中最长递增子序列的长度
        int[] dpLen = new int[n];
        // dpCount[i]表示以i位置为结尾的所有子序列中最长递增子序列的个数
        int[] dpCount = new int[n];

        // 初始化:两表所有值初始化为1
        Arrays.fill(dpLen, 1);
        Arrays.fill(dpCount, 1);

        // 从左往右填表
        int max = dpLen[0], ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dpLen[j]+1 == dpLen[i]) {
                        dpCount[i] += dpCount[j];
                    } else if (dpLen[j]+1 > dpLen[i]) {
                        dpLen[i] = dpLen[j] + 1;
                        dpCount[i] = dpCount[j];
                    }
                }
            }
            if (dpLen[i] == max) {
                ans += dpCount[i];
            } else if (dpLen[i] > max) {
                max = dpLen[i];
                ans = dpCount[i];
            }
        }

        // 返回结果:小贪心策略(在数组中找出最大值出现的次数)
        return ans;
    }

}
