import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    // 改进‘判断两个哈希表操作’的版本
    public List<Integer> findAnagrams(String s, String p) {
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        int ns = s_arr.length, np = p_arr.length, left = 0, right = 0, i = 0;
        int count = 0;  // 使用count来记录有效字符的个数
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        List<Integer> ret = new ArrayList<>();

        while (i < np) {
            hash1[p_arr[i++] - 'a']++;
        }

        while (right < ns) {
            int in = s_arr[right] - 'a';
            hash2[in]++;    // 进窗口

            // 判断进入窗口的字符是否是有效字符
            if (hash2[in] <= hash1[in])
                count++;

            // 判断窗口长度若大于np，要出窗口
            while (right - left + 1 > np) {
                // 出窗口之前判断一下要删除的字符是否是有效字符
                int out = s_arr[left++] - 'a';
                if (hash2[out] <= hash1[out])
                    count--;
                hash2[out]--;
            }
            // 判断两个哈希表中字符出现次数是否相同，若相同就更新结果
            // 仅需判断count是否与np相等即可
            if (count == np)
                ret.add(left);
            right++;
        }

        // 返回最终结果
        return ret;
    }

    // 判断两个哈希表是否相等的操作太耗时，需要改进
    public List<Integer> findAnagrams2(String s, String p) {
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        int ns = s_arr.length, np = p_arr.length, left = 0, right = 0, i = 0;
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        List<Integer> ret = new ArrayList<>();

        while (i < np) {
            hash1[p_arr[i++] - 'a']++;
        }

        while (right < ns) {
            hash2[s_arr[right] - 'a']++;    // 进窗口

            // 判断窗口长度若大于np，要出窗口
            while (right - left + 1 > np) {
                hash2[s_arr[left++] - 'a']--;
            }
            // 判断两个哈希表中字符出现次数是否相同，若相同就更新结果
            if (isEqual(hash1,hash2))
                ret.add(left);
            right++;
        }

        // 返回最终结果
        return ret;
    }
    // 用于判断两个哈希表的元素是否相同
    private boolean isEqual(int[] hash1, int[] hash2) {
        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] != hash2[i])
                return false;
        }
        return true;
    }

    // 错误的
    public List<Integer> findAnagrams1(String s, String p) {
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        int ns = s_arr.length, np = p_arr.length, left = 0, right = left + 2, i = 0;
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        List<Integer> ret = new ArrayList<>();

        while (i < np) {
            hash1[p_arr[i++] - 'a']++;
        }

        while (right < ns) {
            i = left;
            while (i <= right) {    // 进窗口
                hash2[s_arr[i++] - 'a']++;
            }

            // 判断两个哈希表中字符出现次数是否相同
            while (!isEqual(hash1,hash2)) {
                // 若不同，就出窗口
                hash2[s_arr[left++] - 'a']--;
                hash2[s_arr[right++] - 'a']--;
                i = left;
                while (i <= right) {    // 进窗口
                    if (i == (right+left)/2)
                        continue;
                    hash2[s_arr[i++] - 'a']++;
                }
            }
            // 若相同，就更新结果
            ret.add(left);
            // 出窗口
            hash2[s_arr[left++] - 'a']--;
            hash2[s_arr[right++] - 'a']--;
        }

        // 返回最终结果
        return ret;
    }
}
