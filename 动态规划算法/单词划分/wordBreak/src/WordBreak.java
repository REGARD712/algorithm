import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/word-break/
 *
 * @ClassName: WordBreak
 * @Author: JacksonLee
 * @Date: 2026/11/22
 */
public class WordBreak {

    /**
     * 子数组问题
     *
     * @param s 目标字符串
     * @param wordDict 字典
     * @return boolean
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 预处理
        int n = s.length();
        String ss = "-" + s;
        Set<String> hash = new HashSet<>(wordDict);

        // 创建状态表:dp[i]表示[0,i]区间内的字符串能否被字典中的单词拼接而成
        boolean[] dp = new boolean[n+1];

        // 初始化
        dp[0] = true;

        // 从左往右填表
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[j-1] && hash.contains(ss.substring(j, i+1))) {
                    dp[i] = true;
                }
            }
        }

        // 返回结果
        return dp[n];
    }

}
