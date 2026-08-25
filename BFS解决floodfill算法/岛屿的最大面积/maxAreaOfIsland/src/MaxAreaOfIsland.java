import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: MaxAreaOfIsland
 * @Author: JacksonLee
 * @Date: 2026/8/25
 * @Description: https://leetcode.cn/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
    int m, n;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    boolean[][] visit;

    public int maxAreaOfIsland(int[][] grid) {
        int ret = 0;
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    visit[i][j] = true;
                    ret = Math.max(ret, bfs(grid, i, j));
                }
            }
        }

        return ret;
    }

    public int bfs (int[][] grid, int row, int col) {
        int count = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            row = top[0]; col = top[1];

            for (int k = 0; k < 4; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[x][y] == 1 && !visit[x][y]) {
                        count++;
                        queue.offer(new int[]{x, y});
                        visit[x][y] = true;
                    }
                }
            }
        }

        return count;
    }
}
