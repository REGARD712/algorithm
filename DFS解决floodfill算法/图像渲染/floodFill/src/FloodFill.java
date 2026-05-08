public class FloodFill {
    int[][] image;
    int color, m, n;
    // 向量数组
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int[][] floodFill(int[][] givenImage, int sr, int sc, int givenColor) {
        image = givenImage; color = givenColor;
        m = image.length; n = image[0].length;

        // 从[sr,sc]位置开始递归，递归前先记录原像素值，并判断color是否与原像素值相同，不同就修改
        int originColor = image[sr][sc];
        if (originColor != color) {
            image[sr][sc] = color;
        }
        dfs(sr, sc, originColor);
        return image;
    }

    private void dfs(int row, int col, int originColor) {
        // 从[row,col]位置开始向四个方向递归，递归前先判断是否越界，是否与原像素值相同，不同就修改
        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            // 判断是否合法
            if (x >= 0 && x < m && y >= 0 && y < n) {
                // 判断当前位置的像素值是否与起始像素值相同，并且是否与color不同
                if (image[x][y] == originColor && image[x][y] != color) {
                    image[x][y] = color;
                    dfs(x, y, originColor);
                }
            }
        }
    }
}
