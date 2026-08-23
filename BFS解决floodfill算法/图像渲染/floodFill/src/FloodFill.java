import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originColor = image[sr][sc];
        if (originColor == color) { // 处理边界
            return image;
        }

        int m = image.length, n = image[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});

        // 层序遍历
        while (!queue.isEmpty()) {
            // 取出队首
            int[] top = queue.poll();
            int row = top[0], col = top[1];
            // 修改[row,col]位置的值
            image[row][col] = color;

            // 左右上下四个方向宽搜
            for (int k = 0; k < 4; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && image[x][y] == originColor) {
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return image;
    }
}
