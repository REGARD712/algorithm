public class UpdateBoard {
    char[][] board;
    int[] click;
    int m, n;
    // 八个方向的向量数组
    int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
    int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };

    public char[][] updateBoard(char[][] givenBoard, int[] givenClick) {
        board = givenBoard; click = givenClick;
        m = board.length; n = board[0].length;

        // 从点击的位置开始深搜
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(x, y);
        return board;
    }

    private void dfs(int row, int col) {
        // 先统计周围的地雷的个数
        int mine = countMine(row, col);
        // 若周围没有雷
        if (mine == 0) {
            board[row][col] = 'B';
            // 向周围递归
            for (int k = 0; k < 8; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (board[x][y] == 'E') {
                        dfs(x, y);
                    }
                }
            }
        } else { // 周围有雷，改为雷的个数后结束递归
            board[row][col] = (char)(mine+'0');
            return;
        }
    }

    private int countMine(int row, int col) {
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
