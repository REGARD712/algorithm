// count是dfs函数的参数
public class UniquePathsIII {
    int step, ret;
    int[][] grid;
    boolean[][] visit;
    int m, n, startx, starty;

    public int uniquePathsIII(int[][] givenGrid) {
        grid = givenGrid; m = grid.length; n = grid[0].length;
        visit = new boolean[m][n];

        // 记录有效路径的步数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    step++;
                }
                // 找到入口
                if (grid[i][j] == 1) {
                    startx = i;
                    starty = j;
                }
            }
        }
        step += 2;

        visit[startx][starty] = true;
        // 从入口处开始递归
        dfs(startx, starty, 1);

        return ret;
    }

    // 向量数组
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public void dfs(int row, int col, int count) {
        // 递归出口：遇到结束方格
        if (grid[row][col] == 2) {
            // 判断路径是否有效
            if (count == step) ret++;
            return;
        }

        // 从 [row, col] 位置开始往四个方向寻找可以走的方格
        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                // 除了-1障碍方格以外其他方格都可以走
                if (!visit[x][y] && grid[x][y] != -1) {
                    visit[x][y] = true;
                    dfs(x, y, count + 1);
                    visit[x][y] = false;
                }
            }
        }
    }
}
