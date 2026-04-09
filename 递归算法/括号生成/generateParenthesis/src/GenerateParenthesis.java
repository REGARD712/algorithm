import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    int left, right, nn;  // 分别记录左右括号的数量和括号对数
    List<String> ret;
    StringBuilder path;

    public List<String> generateParenthesis(int n) {
        nn = n;
        ret = new ArrayList<>();
        path = new StringBuilder();

        dfs();
        return ret;
    }

    private void dfs() {
        // 递归出口
        if (right == nn) {
            ret.add(path.toString());
            return;
        }

        // 添加左括号
        if (left < nn) {
            path.append("("); left++;
            dfs();
            path.deleteCharAt(path.length() - 1); left--;
        }

        // 添加右括号
        if (right < left) {
            path.append(")"); right++;
            dfs();
            path.deleteCharAt(path.length() - 1); right--;
        }
    }
}
