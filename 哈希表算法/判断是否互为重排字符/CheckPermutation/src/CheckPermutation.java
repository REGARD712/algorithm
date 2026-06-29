public class CheckPermutation {
    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        // 统计s1和s2中的字符
        for (int i = 0; i < s1.length(); i++) {
            int ch1 = s1.charAt(i) - 97;
            hash1[ch1]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int ch2 = s2.charAt(i) - 97;
            hash2[ch2]++;
        }

        // 判断两个哈希表内容是否相同
        for (int i = 0; i < 26; i++) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }
        return true;
    }
}