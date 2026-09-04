import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: UpdateBoard
 * @Author: JacksonLee
 * @Date: 2026/9/4
 * @Description: https://leetcode.cn/problems/minesweeper/description/
 */
public class UpdateBoard {
    char[][] board;
    int m, n;
    int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};

    public char[][] updateBoard(char[][] givenBoard, int[] click) {
        // 初始化
        board = givenBoard;
        m = board.length;
        n = board[0].length;
        int row = click[0], col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        bfs(row, col);
        return board;
    }

    public void bfs (int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        board[row][col] = 'B';

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            row = top[0]; col = top[1];
            int countM = countMine(row, col);
            if (countM == 0) {
                for (int k = 0; k < 8; k++) {
                    int x = row + dx[k], y = col + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (board[x][y] == 'E') {
                            board[x][y] = 'B';
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            } else {
                board[row][col] = (char)(countM+'0');
            }
        }
    }

    public int countMine (int row, int col) {
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
