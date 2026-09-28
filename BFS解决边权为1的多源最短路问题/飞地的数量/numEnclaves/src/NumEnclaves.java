import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/number-of-enclaves/
 *
 * @ClassName: NumEnclaves
 * @Author: JacksonLee
 * @Date: 2026/9/28
 */
public class NumEnclaves {
    public int numEnclaves(int[][] grid) {
        // 初始化
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int ans = 0;

        // 遍历矩阵,将边界的1(多个源点)全部放入队列,相当于超级源点入队
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                queue.offer(new int[]{0, j});
                visit[0][j] = true;
            }
            if (grid[m-1][j] == 1) {
                queue.offer(new int[]{m-1, j});
                visit[m-1][j] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                queue.offer(new int[]{i, 0});
                visit[i][0] = true;
            }
            if (grid[i][n-1] == 1) {
                queue.offer(new int[]{i, n-1});
                visit[i][n-1] = true;
            }
        }

        // 层序遍历
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int row = top[0], col = top[1];
            for (int k = 0; k < 4; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[x][y] == 1 && !visit[x][y]) {
                        queue.offer(new int[]{x, y});
                        visit[x][y] = true;
                    }
                }
            }
        }

        // 再次遍历矩阵,收集结果
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    ans++;
                }
            }
        }

        // 返回结果
        return ans;
    }
}
