import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: solve
 * @Author: JacksonLee
 * @Date: 2026/8/27
 * @Description: https://leetcode.cn/problems/surrounded-regions/
 */
public class solve {
    int m, n;  // 矩阵board的行数和列数
    // 辅助访问某一位置上下左右方向的数组
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public void solve(char[][] board) {
        // 初始化
        m = board.length;
        n = board[0].length;

        // 1.先扫描边界的'O'，将其修改为'.'
        // 通过bfs将与其相连的所有'O'也修改为'.'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
                bfs(board, m-1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                bfs(board, i, n-1);
            }
        }

        // 2.遍历矩阵，找到被包围的'O'并修改为'X'；同时将边界'.'修改为'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs (char[][] board, int row, int col) {
        board[row][col] = '.';   // 将位置[row,col]修改为'.'
        // 使用队列存储与[row,col]位置相连的坐标
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});

        // 层序遍历
        while (!queue.isEmpty()) {
            int[] top = queue.poll();   // 取出队首元素
            row = top[0]; col = top[1]; // 获取队首元素的坐标

            // 从队首元素向上下左右四个方向访问与其相连的'O'并修改
            for (int k = 0; k < 4; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (board[x][y] == 'O') {
                        queue.offer(new int[]{x, y}); // 入队
                        board[x][y] = '.';            // 将该位置的值改为'.'
                    }
                }
            }
        }
    }
}
