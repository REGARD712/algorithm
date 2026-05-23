public class LongestIncreasingPath {
    int[][] matrix;
    int m, n;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    boolean[][] visit;
    int[][] memo; // 备忘录

    public int longestIncreasingPath(int[][] givenMatrix) {
        matrix = givenMatrix; m = matrix.length; n = matrix[0].length;
        visit = new boolean[m][n]; memo = new int[m][n];

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 以每一个数字为起点找出所有值
                visit[i][j] = true;
                ret = Math.max(dfs(i, j), ret);
                visit[i][j] = false;
            }
        }

        return ret;
    }

    private int dfs(int row, int col) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int ret = 0;
        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (!visit[x][y] && matrix[x][y] > matrix[row][col]) {
                    visit[x][y] = true;
                    ret = Math.max(dfs(x, y), ret);
                    visit[x][y] = false;
                }
            }
        }
        memo[row][col] = ret + 1;
        return ret + 1;
    }
}
