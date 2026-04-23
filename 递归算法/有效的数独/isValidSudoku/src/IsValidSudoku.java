public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][][] grid = new boolean[3][3][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch >= '1' && ch <= '9') {
                    // 判断是否有效
                    int num = ch - '0'; // 数字字符可以直接减'0'
                    if (row[i][num] || col[j][num] || grid[i/3][j/3][num]) {
                        // 都不满足，返回false
                        return false;
                    }
                    // 标记状态
                    row[i][num] = col[j][num] = grid[i/3][j/3][num] = true;
                }
            }
        }
        return true;
    }
}
