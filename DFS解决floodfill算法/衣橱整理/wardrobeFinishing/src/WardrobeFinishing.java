public class WardrobeFinishing {
    int m, n, cnt, ret;
    boolean[][] visit;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int wardrobeFinishing(int givenM, int givenN, int givenCnt) {
        //边界情况
        if (givenCnt == 0) {
            return 1;
        }
        // 初始化
        m = givenM;
        n = givenN;
        cnt = givenCnt;
        visit = new boolean[m][n];

        // 从初始位置开始深搜
        visit[0][0] = true;  // 更新标记
        ret++;               // 更新结果
        dfs(0, 0);

        // 返回结果
        return ret;
    }

    public void dfs (int row, int col) {
        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && !visit[x][y]) {
                int count = deal(x, y);    // 计算该位置的数位之和
                if (count <= cnt) {
                    visit[x][y] = true;    // 更新标记
                    ret++;                 // 更新结果
                    dfs(x, y);             // 继续深搜
                }
            }
        }
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
