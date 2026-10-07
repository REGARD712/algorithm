import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/as-far-from-land-as-possible/
 *
 * @ClassName: MaxDistance
 * @Author: JacksonLee
 * @Date: 2026/10/7
 */
public class MaxDistance {
    public int maxDistance(int[][] grid) {
        // 初始化
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, -1); // 将dist矩阵中的值初始化为-1,表示未被访问过
        }

        // 先遍历矩阵找到陆地
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dist[i][j] = 0;               // 将距离矩阵中对应位置的值设置为0
                    queue.offer(new int[]{i, j}); // 放入队列
                }
            }
        }

        // 层序遍历
        int maxDist = -1;
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int row = top[0], col = top[1];
            for (int k = 0; k < 4; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && dist[x][y] == -1) {
                    dist[x][y] = dist[row][col] + 1;
                    queue.offer(new int[]{x, y});
                    maxDist = Math.max(maxDist, dist[x][y]);
                }
            }
        }

        // 返回结果
        return maxDist;
    }
}
