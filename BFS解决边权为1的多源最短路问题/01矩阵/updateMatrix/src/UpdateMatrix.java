import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/01-matrix/
 *
 * @ClassName: UpdateMatrix
 * @Author: JacksonLee
 * @Date: 2026/9/21
 */
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        // 初始化
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        // 将距离数组的值初始化为-1,表示未被访问过,若不为-1则表示最短距离
        for (int[] arr : dist) {
            Arrays.fill(arr, -1);
        }

        // 遍历矩阵,将所有0存入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    // 更新结果
                    dist[i][j] = 0;
                    // 入队
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 层序遍历
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int row = top[0], col = top[1];
            for (int k = 0; k < 4; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && dist[x][y] == -1) {
                    // 更新
                    dist[x][y] = dist[row][col] + 1;
                    // 入队
                    queue.offer(new int[]{x, y});
                }
            }
        }

        // 返回结果
        return dist;
    }
}
