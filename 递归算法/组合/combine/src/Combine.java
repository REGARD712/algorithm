import java.util.ArrayList;
import java.util.List;

public class Combine {
    List<List<Integer>> ret;
    List<Integer> path;
    int n, k;

    public List<List<Integer>> combine(int nn, int kk) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        n = nn; k = kk;

        dfs(1);
        return ret;
    }

    private void dfs(int pos) {
        // 递归出口
        if (path.size() == k) {
            ret.add(new ArrayList<>(path));
            return;
        }

        // 从当前数字往后遍历枚举
        for (int i = pos; i <= n; i++) {
            path.add(i);
            dfs(i + 1);
            path.remove(path.size() - 1);  // 回溯时恢复现场
        }
    }
}

class Combine2 {
    List<List<Integer>> ret;
    List<Integer> path;
    boolean[] check;

    public List<List<Integer>> combine(int n, int k) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        check = new boolean[n + 1];

        dfs(n, k, 1);
        return ret;
    }

    private void dfs(int n, int k, int pos) {
        // 递归出口
        if (path.size() == k) {
            ret.add(new ArrayList<>(path));
            return;
        }

        // 从当前数字往后遍历枚举
        for (int i = pos; i <= n; i++) {
            if (check[i] == false) {
                path.add(i); check[i] = true;
                dfs(n, k, i + 1);
                path.remove(path.size() - 1); check[i] = false; // 回溯时恢复现场
            }
        }
    }
}