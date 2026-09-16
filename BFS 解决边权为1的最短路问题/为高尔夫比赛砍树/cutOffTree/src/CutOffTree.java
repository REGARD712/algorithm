import java.util.*;

/**
 * @ClassName: CutOffTree
 * @Author: JacksonLee
 * @Date: 2026/9/15
 * @Description: <a href="https://leetcode.cn/problems/cut-off-trees-for-golf-event/">...</a>
 */
public class CutOffTree {
    int m, n;
    int[][] f;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int cutOffTree(List<List<Integer>> forest) {
        // 初始化
        m = forest.size(); n = forest.get(0).size();
        f = new int[m][n];
        List<int[]> treeOrder = new ArrayList<>();

        // 遍历森林找到并存储要被砍的树
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = forest.get(i).get(j);
                if (f[i][j] > 1) {
                    treeOrder.add(new int[]{f[i][j], i, j});
                }
            }
        }

        // 从小到大排序
        Collections.sort(treeOrder, (a, b) -> a[0] - b[0]);

        // 按照顺序开始砍树
        int ret = 0, beginX = 0, beginY = 0;
        for (int[] t : treeOrder) {
            int x = t[1], y = t[2];
            int step = bfs(beginX, beginY, x, y);
            if (step == -1) {
                return -1;
            }
            ret += step;
            beginX = x; beginY = y;
        }

        // 返回结果
        return ret;
    }

    public int bfs (int row, int col, int ex, int ey) {
        // 处理边界情况
        if (row == ex && col == ey) {
            return 0;
        }

        // 每次 BFS 都要重置访问数组，否则前一个搜索留下的状态会污染后续搜索
        boolean[][] visit = new boolean[m][n];

        // 初始化
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visit[row][col] = true;
        int step = 0;

        // 层序遍历
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- != 0) {
                int[] top = queue.poll();
                row = top[0]; col = top[1];

                for (int k = 0; k < 4; k++) {
                    int x = row + dx[k], y = col + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visit[x][y] && f[x][y] != 0) {
                        if (x == ex && y == ey) {
                            return step;
                        }
                        queue.offer(new int[]{x, y});
                        visit[x][y] = true;
                    }
                }
            }
        }

        // 无法继续砍树, 返回-1
        return -1;
    }
}
