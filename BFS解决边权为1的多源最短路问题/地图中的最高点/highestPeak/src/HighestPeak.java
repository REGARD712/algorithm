import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/map-of-highest-peak/
 *
 * @ClassName: HighestPeak
 * @Author: JacksonLee
 * @Date: 2026/9/30
 */
public class HighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        // 初始化
        int m = isWater.length, n = isWater[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        boolean[][] isWaterVisit = new boolean[m][n]; // 标记水域

        // 先将水域改为0并存入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    isWaterVisit[i][j] = true;
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
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    // 找到陆地格子,将值改为"位置[row,col]的值+1"
                    if (isWater[x][y] == 0 && !isWaterVisit[x][y]) {
                        isWater[x][y] = isWater[row][col] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }

        // 返回结果
        return isWater;
    }
}
