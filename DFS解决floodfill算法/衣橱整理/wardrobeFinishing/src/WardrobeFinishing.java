public class WardrobeFinishing {
    int m, n, cnt, ret;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    boolean[][] visit;

    public int wardrobeFinishing(int givenM, int givenN, int givenCnt) {
        m = givenM; n = givenN; cnt = givenCnt;
        visit = new boolean[m][n];

        // 从[0,0]位置开始深搜
        ret++; visit[0][0] = true;
        dfs(0, 0);

        return ret;
    }

    private void dfs(int row, int col) {
        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && !visit[x][y]) {
                int digit = deal(x, y);
                if (digit <= cnt) {
                    ret++; visit[x][y] = true;
                    dfs(x, y);
                }
            }
        }
    }

    private int deal(int x, int y) {
        int count = 0;
        // 先求x的数位之和
        while (x != 0) {
            count += (x % 10);
            x /= 10;
        }
        // 再求y的数位之和
        while (y != 0) {
            count += (y % 10);
            y /= 10;
        }
        return count;
    }
}
