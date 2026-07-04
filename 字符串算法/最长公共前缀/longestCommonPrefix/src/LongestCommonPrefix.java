public class LongestCommonPrefix {
    // 解法一：两两比较字符串找出最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        // 拿第一个字符串作为基准
        String ret = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // 与strs[i]比较找出最长公共前缀
            ret = findCommon(ret, strs[i]);
        }

        return ret;
    }

    public String findCommon(String s1, String s2) {
        int i = 0;
        while (i < Math.min(s1.length(), s2.length()) && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }
}

class LongestCommonPrefix2 {
    // 解法二：纵向逐列统一比较
    public String longestCommonPrefix(String[] strs) {
        // 以第一个字符串为基准，逐列比较
        for (int i = 0; i < strs[0].length(); i++) { // 遍历第一个字符串
            // 以当前第一个字符串的字符为准进行比较
            char ch = strs[0].charAt(i);
            // 逐列比较
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || ch != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}