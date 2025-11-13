import java.util.HashMap;

public class MinWindow {
    // 使用数组模拟哈希表
    public String minWindow(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] hash1 = new int[128];
        int[] hash2 = new int[128];
        int start = -1, minLen = Integer.MAX_VALUE, charKinds = 0, count = 0;

        // 先将字符串t中的字符存入hash1中
        for (char ch : t_arr) {
            // 若字符出现频次为0，说明是有效字符
            if (hash1[ch]++ == 0) charKinds++;
        }

        // 利用滑动窗口解决问题
        for (int left = 0, right = 0; right < s_arr.length; right++) {
            // 进窗口并判断字符是否为有效字符
            char in = s_arr[right];
            if (++hash2[in] == hash1[in]) count++;

            // 判断窗口是否合法
            while (count == charKinds) {
                // 若合法，就先判断字符是否有效并更新结果，再出窗口
                char out = s_arr[left];
                if (hash2[out]-- == hash1[out]) count--;
                if (right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }
                left++;
            }
        }
        // 返回最终结果
        if (start == -1) return new String();
        else return s.substring(start, start + minLen);
    }

    // 用例测试结果错误
    public String minWindow1(String s, String t) {
        HashMap<Character,Integer> hash1 = new HashMap<>();
        HashMap<Character,Integer> hash2 = new HashMap<>();
        int start = -1, len = Integer.MAX_VALUE, tlen = t.length(), slen = s.length();

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
                if (right - left + 1 < len) {
                    start = left;
                    len = right - left + 1;
                }
                hash2.put(out, hash2.get(out) - 1);
                if (hash2.get(out) == 0) hash2.remove(out);
                left++;
            }
            // 若不合法，就继续进窗口
        }

        // 返回最终结果
        if (tlen == slen && t.equals(s)) return s;
        if (start == -1) return new String();
        else return s.substring(start, start + len);
    }
}
