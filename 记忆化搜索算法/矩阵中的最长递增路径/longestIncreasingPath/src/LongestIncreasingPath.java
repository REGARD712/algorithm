public class LongestIncreasingPath {
    int m, n;
    int[][] matrix;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int[][] memo; // 记忆数组

    public int longestIncreasingPath(int[][] givenMatrix) {
        // 初始化
        matrix = givenMatrix;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        int ret = 0;

        // 以每一个位置为起点找出最长递增路径
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = dfs(i, j);     // dfs找到以[i,j]为起点的最长递增路径
                ret = Math.max(count, ret);// 取所有找出的路径中的最大值
            }
        }

        // 返回结果
        return ret;
    }

    // dfs任务:找到以[row,col]为起点的最长递增路径
    public int dfs (int row, int col) {
        // 递归展开之前先查看记忆数组
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int count = 0;

        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[row][col]) {
                count = Math.max(dfs(x, y), count);
            }
        }

        // 递归展开之后先将结果存入记忆数组再返回
        memo[row][col] = count + 1;
        return count + 1;
    }
}
