import java.util.*;

public class LetterCombinations {
    List<String> ret;
    StringBuilder path;
    // 使用一个字符串数组模拟哈希表
    String[] hash = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        ret = new ArrayList<>();
        path = new StringBuilder();

        // 递归
        dfs(digits, 0);
        return ret;
    }

    private void dfs(String digits, int pos) {
        // 递归出口：当遇到叶子节点
        if (path.length() == digits.length()) {
            ret.add(path.toString());
            return;
        }

        // 将pos位置的数字翻译成字母
        int num = digits.charAt(pos) - '0';
        for (int i = 0; i < hash[num].length(); i++) {
            path.append(hash[num].charAt(i));
            dfs(digits, pos + 1);
            path.deleteCharAt(path.length() - 1);  // 回溯时恢复现场
        }
    }
}
