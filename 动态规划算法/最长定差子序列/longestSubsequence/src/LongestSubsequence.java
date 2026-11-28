import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/
 *
 * @ClassName: LongestSubsequence
 * @Author: JacksonLee
 * @Date: 2026/11/28
 */
public class LongestSubsequence {

    /**
     * 动态规划:子序列问题
     *
     * @param arr 输入数组
     * @param difference 定差
     * @return int
     */
    public int longestSubsequence(int[] arr, int difference) {
        // 预处理
        int n = arr.length;


        // 创建状态表(哈希表)
        // <arr[i],dp[i]>
        Map<Integer, Integer> hash = new HashMap<>();

        // 从左往右填表(哈希表中填表)
        int ans = 1;
        for (int a : arr) {
            hash.put(a, hash.getOrDefault(a-difference, 0) + 1);
            ans = Math.max(hash.get(a), ans);
        }

        // 返回结果:哈希表中的最大值
        return ans;
    }

}
