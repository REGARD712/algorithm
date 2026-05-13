import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    int[][] heights;
    int m, n;
    List<List<Integer>> ret;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public List<List<Integer>> pacificAtlantic(int[][] givenHeights) {
        heights = givenHeights; m = heights.length; n = heights[0].length;
        boolean[][] pacificVisit = new boolean[m][n];
        boolean[][] atlanticVisit = new boolean[m][n];
        ret = new ArrayList<>();

        // 1.先扫描太平洋岸边的
        for (int j = 0; j < n; j++) dfs(pacificVisit, 0, j);
        for (int i = 0; i < m; i++) dfs(pacificVisit, i, 0);
        // 2.然后扫描大西洋岸边的
        for (int j = 0; j < n; j++) dfs(atlanticVisit, m-1, j);
        for (int i = 0; i < m; i++) dfs(atlanticVisit, i, n-1);

        // 3.找到流向两个海洋的点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisit[i][j] && atlanticVisit[i][j]) {
                    List<Integer> path = new ArrayList<>();
                    path.add(i); path.add(j);
                    ret.add(new ArrayList<>(path));
                }
            }
        }
        return ret;
    }

    public void dfs(boolean[][] visit, int row, int col) {
        visit[row][col] = true;

        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (!visit[x][y] && heights[x][y] >= heights[row][col]) {
                    dfs(visit, x, y);
                }
            }
        }
    }
}

class PacificAtlantic2 {
    int[][] heights;
    int m, n;
    List<List<Integer>> ret;
    List<Integer> path;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public List<List<Integer>> pacificAtlantic(int[][] givenHeights) {
        heights = givenHeights; m = heights.length; n = heights[0].length;
        boolean[][] pacificVisit = new boolean[m][n];
        boolean[][] atlanticVisit = new boolean[m][n];
        ret = new ArrayList<>(); path = new ArrayList<>();

        // 搜寻靠近太平洋的横岸
        for (int j = 0; j < n; j++) {
            // 借助dfs往高处寻找经过该点[0,j]的水流
            dfs(pacificVisit, 0, j);
        }
        // 搜寻靠近太平洋的纵岸
        for (int i = 0; i < m; i++) {
            // 借助dfs往高处寻找经过该点[i,0]的水流
            dfs(pacificVisit, i, 0);
        }
        // 搜寻靠近大西洋的横岸
        for (int j = 0; j < n; j++) {
            // 借助dfs往高处寻找经过该点[m-1,j]的水流
            dfs(atlanticVisit, m-1, j);
        }
        // 搜寻靠近大西洋的纵岸
        for (int i = 0; i < m; i++) {
            // 借助dfs往高处寻找经过该点[i,n-1]的水流
            dfs(atlanticVisit, i, n-1);
        }
        // 搜寻能流经两个海洋的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisit[i][j] && atlanticVisit[i][j]) {
                    path.add(i); path.add(j);
                    ret.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                    path.remove(path.size() - 1);
                }
            }
        }
        return ret;
    }

    public void dfs(boolean[][] visit, int row, int col) {
        visit[row][col] = true;

        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (heights[x][y] >= heights[row][col] && !visit[x][y]) {
                    dfs(visit, x, y);
                }
            }
        }
    }
}