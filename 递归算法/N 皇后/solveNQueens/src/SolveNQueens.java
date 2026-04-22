import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {
    List<List<String>> ret;
    boolean[] checkCol, dig1, dig2;
    char[][] path;
    int n;

    public List<List<String>> solveNQueens(int nn) {
        n = nn;
        ret = new ArrayList<>();
        checkCol = new boolean[n];
        dig1 = new boolean[2 * n];
        dig2 = new boolean[2 * n];
        path = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(path[i], '.');

        dfs(0);
        return ret;
    }

    private void dfs(int row) {
        // 递归出口
        if (row == n) {
            // 更新结果
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++)
                temp.add(new String(path[i]));
            ret.add(new ArrayList<>(temp));
            return;
        }

        for (int col = 0; col < n; col++) {
            // 判断能够放皇后
            if (!checkCol[col] && !dig1[row - col + n] && !dig2[row + col]) {
                // 放置皇后
                path[row][col] = 'Q';
                checkCol[col] = dig1[row - col + n] = dig2[row + col] = true;
                dfs(row + 1);
                // 恢复现场
                path[row][col] = '.';
                checkCol[col] = dig1[row - col + n] = dig2[row + col] = false;
            }
        }
    }
}
