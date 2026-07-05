public class LongestPalindrome {
    public String longestPalindrome(String s) {
        // 分别记录s的长度、返回结果的起始下标、返回结果的长度
        int n = s.length(), start = 0, len = 0;

        // 遍历字符串，逐一固定中心点
        for (int i = 0; i < n; i++) {
            // 双指针用于判断中心点的两侧字符是否相等
            int left = i, right = i;

            // 先考虑子串长度为奇数情况
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--; right++;
            }
            if (right - left - 1 > len) {
                // 更新结果
                start = left + 1;
                len = right - left - 1;
            }

            // 再考虑子串长度为偶数情况
            left = i; right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--; right++;
            }
            if (right - left - 1 > len) {
                // 更新结果
                start = left + 1;
                len = right - left - 1;
            };
        }

        return s.substring(start, start + len);
    }
}
