import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: NumIslands
 * @Author: JacksonLee
 * @Date: 2026/8/25
 * @Description: https://leetcode.cn/problems/number-of-islands/
 */
public class NumIslands {
    int m, n; // 矩阵grid的行数和列数
    boolean[][] visit; // 用于标记是否已访问
    // 辅助访问某一位置上下左右方向的数组
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int numIslands(char[][] grid) {
        int ret = 0; // 用于统计岛屿的数量
        // 初始化
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];

        // 遍历矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    // 找到一块未被标记的岛屿
                    ret++;
                    bfs(grid, i, j); // 将与该岛屿相连的所有陆地通过BFS标记
                }
            }
        }

        // 返回统计的岛屿数量
        return ret;
    }

    public void bfs (char[][] grid, int row, int col) {
        // 使用队列存储与[row,col]位置相连且未被访问过的陆地的坐标
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visit[row][col] = true; // 将[row,col]位置做标记

        // 层序遍历
        while (!queue.isEmpty()) {
            int[] top = queue.poll(); // 取出队首元素
            row = top[0]; col = top[1]; // 获取队首元素的坐标

            // 从位置[row,col]向上下左右四个方向访问未被标记的陆地
            for (int k = 0; k < 4; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[x][y] == '1' && !visit[x][y]) {
                        queue.offer(new int[]{x, y});
                        visit[x][y] = true;
                    }
                }
            }
        }
    }
}
