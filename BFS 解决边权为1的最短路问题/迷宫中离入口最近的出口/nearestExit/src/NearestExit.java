import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: NearestExit
 * @Author: JacksonLee
 * @Date: 2026/8/31
 * @Description: https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/
 */
public class NearestExit {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        int step = 0;

        queue.offer(new int[]{entrance[0], entrance[1]});
        visit[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int row = top[0], col = top[1];

                for (int k = 0; k < 4; k++) {
                    int x = row + dx[k], y = col + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (maze[x][y] == '.' && !visit[x][y]) {
                            if (x == 0 || x == m-1 || y == 0 || y == n-1) {
                                return step;
                            }
                            queue.offer(new int[]{x, y});
                            visit[x][y] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
