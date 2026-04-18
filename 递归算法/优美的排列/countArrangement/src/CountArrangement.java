public class CountArrangement {
    int ret, n;
    boolean[] check;

    public int countArrangement(int nn) {
        n = nn;
        check = new boolean[n + 1];

        dfs(1);
        return ret;
    }

    private void dfs(int pos) {
        if (pos == n + 1) {
            ret++;
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (check[num] == false && (num % pos == 0 || pos % num == 0)) {
                check[num] = true;
                dfs(pos + 1);
                check[num] = false; // 恢复现场
            }
        }
    }
}
