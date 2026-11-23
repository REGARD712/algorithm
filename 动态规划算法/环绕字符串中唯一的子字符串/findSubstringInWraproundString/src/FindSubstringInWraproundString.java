import java.util.Arrays;

/**
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 *
 * @ClassName: FindSubstringInWraproundString
 * @Author: JacksonLee
 * @Date: 2026/11/23
 */
public class FindSubstringInWraproundString {

    /**
     * 子数组问题
     *
     * @param s 输入字符串
     * @return int
     */
    public int findSubstringInWraproundString(String s) {
        // 预处理
        char[] ss = s.toCharArray();
        int n = ss.length;
        int[] alphabet = new int[26];  // 用于存放每个字符结尾的最大dp值

        // 创建状态表
        int[] dp = new int[n];

        // 初始化
        Arrays.fill(dp, 1);

        // 从左往右填表
        for (int i = 1; i < n; i++) {
            if ((ss[i-1]+1==ss[i]) || (ss[i-1]=='z'&&ss[i]=='a')) {
                dp[i] += dp[i-1];
            }
        }

        // 返回结果:alphabet数组所有值之和
        for (int i = 0; i < n; i++) {
            alphabet[ss[i]-'a'] = Math.max(alphabet[ss[i]-'a'], dp[i]);
        }
        int ans = 0;
        for (int letter : alphabet) {
            ans += letter;
        }
        return ans;
    }

}
