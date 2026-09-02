import java.util.*;

/**
 * @ClassName: PacificAtlantic
 * @Author: JacksonLee
 * @Date: 2026/9/2
 * @Description: https://leetcode.cn/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlantic {
    int[][] heights;
    int m, n;
    List<List<Integer>> ret;
    boolean[][] pacificVisit;
    boolean[][] atlanticVisit;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public List<List<Integer>> pacificAtlantic(int[][] givenHeights) {
        // 初始化
        heights = givenHeights;
        m = heights.length;
        n = heights[0].length;
        ret = new ArrayList<>();
        pacificVisit = new boolean[m][n];
        atlanticVisit = new boolean[m][n];

        // 先从太平洋和大西洋沿岸查找能够逆流而上的方格,并通过bfs标记
        for (int j = 0; j < n; j++) {
            bfs(pacificVisit, 0, j);
        }
        for (int i = 0; i < m; i++) {
            bfs(pacificVisit, i, 0);
        }
        for (int j = 0; j < n; j++) {
            bfs(atlanticVisit, m-1, j);
        }
        for (int i = 0; i < m; i++) {
            bfs(atlanticVisit, i, n-1);
        }

        // 然后遍历矩阵，找出两个标记重叠的方格
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisit[i][j] && atlanticVisit[i][j]) {
                    ret.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        // 返回结果
        return ret;
    }

    public void bfs (boolean[][] visit, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visit[row][col] = true;

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            row = top[0]; col = top[1];

            for (int k = 0; k < 4; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (heights[x][y] >= heights[row][col] && !visit[x][y]) {
                        queue.offer(new int[]{x, y});
                        visit[x][y] = true;
                    }
                }
            }
        }
    }
}
