import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    List<String> ret;
    StringBuilder path;

    public List<String> letterCasePermutation(String s) {
        ret = new ArrayList<>();
        path = new StringBuilder();

        dfs(s, 0);
        return ret;
    }

    private void dfs(String s, int pos) {
        // 递归出口
        if (pos == s.length()) {
            ret.add(path.toString());
            return;
        }

        char ch = s.charAt(pos);
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
            // 是字母，需要转换大小写
            // 添加小写字母
            if (ch >= 'A' && ch <= 'Z') path.append(ch += 32);
            else path.append(ch);
            dfs(s, pos + 1);
            path.deleteCharAt(path.length() - 1); // 回溯时恢复现场

            // 添加大写字母
            if (ch >= 'a' && ch <= 'z') path.append(ch -= 32);
            else path.append(ch);
            dfs(s, pos + 1);
            path.deleteCharAt(path.length() - 1); // 回溯时恢复现场
        } else {
            // 是数字，直接添加
            path.append(ch);
            dfs(s, pos + 1);
            path.deleteCharAt(path.length() - 1); // 回溯时恢复现场
        }
    }
}

class LetterCasePermutation2 {
    List<String> ret;
    StringBuilder path;

    public List<String> letterCasePermutation(String s) {
        ret = new ArrayList<>();
        path = new StringBuilder();

        dfs(s, 0);
        return ret;
    }

    private void dfs(String s, int pos) {
        // 递归出口
        if (pos == s.length()) {
            ret.add(path.toString());
            return;
        }

        char ch = s.charAt(pos);
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
            // 是字母，需要转换大小写
            path.append(deal(ch));
            dfs(s, pos + 1);
            path.deleteCharAt(path.length() - 1); // 回溯时恢复现场
        }

        // 是数字，不用转换直接添加
        path.append(ch);
        dfs(s, pos + 1);
        path.deleteCharAt(path.length() - 1); // 回溯时恢复现场
    }

    private char deal(char ch) {
        if (ch >= 'a' && ch <= 'z') return ch -= 32;
        else return ch += 32;
    }
}
