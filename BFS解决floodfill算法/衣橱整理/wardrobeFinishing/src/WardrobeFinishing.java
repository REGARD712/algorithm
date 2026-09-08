import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: WardrobeFinishing
 * @Author: JacksonLee
 * @Date: 2026/9/8
 * @Description: https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/description/
 */
public class WardrobeFinishing {
    boolean[][] visit;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int wardrobeFinishing(int m, int n, int cnt) {
        // 边界情况
        if (cnt == 0) {
            return 1;
        }
        // 初始化
        int ret = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        visit = new boolean[m][n];

        // 从起始位置开始宽搜
        queue.offer(new int[]{0, 0});// 入队
        visit[0][0] = true;          // 更新标记
        ret++;                       // 更新结果
        // 层序遍历
        while (!queue.isEmpty()) {
            int[] top = queue.poll();      // 获取队首元素
            int row = top[0], col = top[1];// 获取队首元素的坐标
            for (int k = 0; k < 4; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && !visit[x][y]) {
                    int count = deal(x, y); // 计算当前位置[x,y]的数位之和
                    if (count <= cnt) {     // 满足条件
                        queue.offer(new int[]{x, y});// 入队
                        visit[x][y] = true;          // 更新标记
                        ret++;                       // 更新结果
                    }
                }
            }
        }
        // 返回结果
        return ret;
    }

    public int deal (int x, int y) {
        // 计算某个位置的数位之和
        int ret = 0;
        while (x != 0) {
            ret += (x % 10);
            x /= 10;
        }
        while (y != 0) {
            ret += (y % 10);
            y /= 10;
        }
        return ret;
    }
}
