public class Solve {
    char[][] board;
    int m, n;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public void solve(char[][] givenBoard) {
        board = givenBoard; m = board.length; n = board[0].length;

        // 1.先扫描边界，遇到'O'就修改成'.'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(0, j); //让dfs将当前位置及周围的值改成'.'
            if (board[m - 1][j] == 'O') dfs(m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0);
            if (board[i][n - 1] == 'O') dfs(i, n - 1);
        }

        // 2.找到被包围的O并修改
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int row, int col) {
        board[row][col] = '.';

        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (board[x][y] == 'O') {
                    dfs(x, y); //找到与该位置相连的O
                }
            }
        }
    }
}
