public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        // 1. 预处理前缀和矩阵：注意长度
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        // 2. 利用前缀和矩阵构造结果矩阵
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = Math.max(0, i - k) + 1, y1 = Math.max(0, j - k) + 1;
                int x2 = Math.min(m - 1, i + k) + 1, y2 = Math.min(n - 1, j + k) + 1;
                answer[i][j] = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            }
        }

        // 3. 返回结果矩阵
        return answer;
    }
}
