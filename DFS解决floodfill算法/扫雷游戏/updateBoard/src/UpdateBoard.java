public class UpdateBoard {
    char[][] board;
    int m, n;
    int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};

    public char[][] updateBoard(char[][] givenBoard, int[] click) {
        board = givenBoard;
        m = board.length;
        n = board[0].length;
        int row = click[0], col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        dfs(row, col);
        return board;
    }

    public void dfs (int row, int col) {
        int countM = countMine(row, col);
        if (countM == 0) {
            board[row][col] = 'B';
            for (int k = 0; k < 8; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (board[x][y] == 'E') {
                        dfs(x, y);
                    }
                }
            }
        } else {
            board[row][col] = (char)(countM+'0');
            return;
        }
    }

    public int countMine (int row ,int col) {
        int ret = 0;
        for (int k = 0; k < 8; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (board[x][y] == 'M') {
                    ret++;
                }
            }
        }
        return ret;
    }
}