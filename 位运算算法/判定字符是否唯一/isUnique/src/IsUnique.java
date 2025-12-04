public class IsUnique {
    // 解法一：哈希表 + 鸽巢原理
    // 时间复杂度：O（n）；空间复杂度：O（n）
    public boolean isUnique1(String astr) {
        int n = astr.length();

        // 利用鸽巢原理快速判断
        if (n > 26) return false;

        // 用哈希表存储每个字母是否出现
        int[] hash = new int[26];
        for (int i = 0; i < n; i++) {
            int pos = astr.charAt(i) - 'a';
            if (hash[pos] == 0) hash[pos]++;    // 若该字符未存入哈希表，就+1
            else return false;                  // 若为1，表示当前字母重复出现，返回false
        }

        // 若执行到此处时仍未返回，表示字符串没有重复字符
        return true;
    }

    // 解法二：位图 + 鸽巢原理
    // 时间复杂度：O（n）；空间复杂度：O（1）
    public boolean isUnique(String astr) {
        int n = astr.length();

        // 利用鸽巢原理快速判断
        if (n > 26) return false;

        // 使用位图记录字母是否出现重复
        int temp = 0;
        for (int i = 0; i < n; i++) {
            int pos = astr.charAt(i) - 'a';
            if (((temp >> pos) & 1) == 0) temp |= (1 << pos);   // 若为0表示当前字母未出现过，将0改成1
            else return false;      // 若为1表示当前字母出现过，即该字母重复，返回false
        }

        // 执行到此处仍未返回，表示该字符串没有重复字符
        return true;
    }
}
