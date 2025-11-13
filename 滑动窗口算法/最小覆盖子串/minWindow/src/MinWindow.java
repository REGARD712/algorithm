import java.util.HashMap;

public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        minWindow(s,t);
    }
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> hash1 = new HashMap<>();
        HashMap<Character,Integer> hash2 = new HashMap<>();
        int start = 0, len = Integer.MAX_VALUE, tlen = t.length(), slen = s.length();

        // 先将t中的字符存放到hash1中
        for (int i = 0; i < tlen; i++) {
            char ch = t.charAt(i);
            hash1.put(ch, hash1.getOrDefault(ch,0) + 1);
        }

        // 使用滑动窗口来解决问题
        for (int left = 0, right = 0, count = 0; right < slen; right++) {
            // 进窗口
            char in = s.charAt(right);
            hash2.put(in, hash2.getOrDefault(in,0) + 1);
            // 进完窗口后，判断字符是否为有效字符
            if (hash2.get(in) == hash1.getOrDefault(in,0)) count++;

            // 判断窗口是否合法
            while (count == tlen) {
                // 若合法，就先判断字符是否有效并更新结果，再出窗口
                char out = s.charAt(left);
                if (hash2.get(out) == hash1.getOrDefault(out,0)) count--;
                start = left; len = Math.min(len, right - left + 1);
                hash2.put(out, hash2.get(out) - 1);
                if (hash2.get(out) == 0) hash2.remove(out);
                left++;
            }
            // 若不合法，就继续进窗口
        }

        // 返回最终结果
        return s.substring(start, start + len);
    }
}
