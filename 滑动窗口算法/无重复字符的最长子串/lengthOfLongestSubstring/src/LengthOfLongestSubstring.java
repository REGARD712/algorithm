import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), len = 0, left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            // 进窗口
            char ch = s.charAt(right);

            // 判断是否有重复字符
            while (!set.add(ch)) {
                // 若存在重复字符，就出窗口
                set.remove(s.charAt(left++));
            }
            // 若不存在重复字符，就先记录结果，再继续进窗口
            len = Math.max(len,right - left + 1);
            right++;
        }

        return len;
    }
}
