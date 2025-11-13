import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        int sn = s.length(), wn = words.length, len = words[0].length();
        HashMap<String,Integer> hash1 = new HashMap<>();

        // 存储words中的字符串
        for (String str : words) {
            hash1.put(str, hash1.getOrDefault(str,0) + 1);
        }

        // 滑动窗口解决问题
        for (int i = 0; i < len; i++) {
            HashMap<String,Integer> hash2 = new HashMap<>();
            for (int left = i, right = i, count = 0; right + len <= sn; right += len) {
                // 进窗口
                String in = s.substring(right, right + len);
                hash2.put(in, hash2.getOrDefault(in,0) + 1);
                // 判断是否有效的字符串，维护count
                if (hash2.get(in) <= hash1.getOrDefault(in,0)) count++;

                // 判断窗口长度是否达到有效长度
                while (right - left + 1 > len * wn) {
                    // 若大于有效长度，先判断字符串是否有效并维护count，再出窗口
                    String out = s.substring(left, left + len);
                    if (hash2.get(out) <= hash1.getOrDefault(out,0)) count--;
                    hash2.put(out, hash2.get(out) - 1);
                    if (hash2.get(out) == 0) hash2.remove(out);
                    // 出完窗口后就移动left
                    left += len;
                }
                // 若窗口长度小于等于有效长度，就更新结果
                if (count == wn) ret.add(left);
            }
        }

        // 返回最终结果
        return ret;
    }
}
