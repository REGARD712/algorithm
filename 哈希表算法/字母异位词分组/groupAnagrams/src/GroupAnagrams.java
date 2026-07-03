import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();

        // 1.先将所有字母异位词重组
        for (String str : strs) {
            // 将当前的字符串排序
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);

            // key不在hash中就put
            if (!hash.containsKey(key)) {
                hash.put(key, new ArrayList<>());
            }
            // 将当前字符串加入到对应key的value数组中
            hash.get(key).add(str);
        }

        // 2.取出value数组并返回
        return new ArrayList<>(hash.values());
    }
}

class GroupAnagrams2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();

        // 遍历字符串数组
        for (String str : strs) {
            // 对当前的字符串排序
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = new String(strArr);
            // 检查当前哈希表中是否存在该字符串的字母异位词
            if (hash.containsKey(key)) {
                // 将value中的字符串取出
                List<String> value = hash.get(key);
                // 将str加入value的字符串数组中
                value.add(str);
                // 覆盖原来的hash内的键值对
                hash.put(key, value);
            } else {
                hash.put(key, new ArrayList<>());
                hash.get(key).add(str);
            }
        }

        // 从hash中取出value
        List<List<String>> ret = new ArrayList<>();
        for (List<String> value : hash.values()) {
            ret.add(value);
        }

        return ret;
    }
}