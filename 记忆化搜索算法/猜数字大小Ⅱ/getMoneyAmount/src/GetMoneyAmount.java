public class GetMoneyAmount {
    int[][] memo; // 记忆数组:用于记录指定区间的最小现金数

    public int getMoneyAmount(int n) {
        // 初始化记忆数组
        memo = new int[n+1][n+1];

        return dfs(1, n);
    }

    // dfs任务:在指定区间[start,end]中找到确保获胜的最小现金数
    public int dfs (int start, int end) {
        // 递归出口
        if (start >= end) {
            return 0;
        }

        // 在递归展开之前先查看记忆数组
        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        // 分别用于记录:该层的最小现金数、左子树的最小现金数和右子树的最小现金数
        int minMoneyAmount = Integer.MAX_VALUE, leftMinAmount = 0, rightMinAmount = 0;

        // 在区间中逐个枚举作为根节点的数字
        for (int i = start; i <= end; i++) {
            leftMinAmount = dfs(start, i-1);         // 先获取左子树能确保胜利的最小现金数
            rightMinAmount = dfs(i+1, end);          // 再获取右子树能确保胜利的最小现金数

            // 在左右子树的最小现金数中取较大值+当前根节点数
            // 再取这些根节点数的现金数中的最小值
            minMoneyAmount = Math.min(Math.max(leftMinAmount, rightMinAmount) + i, minMoneyAmount);
        }

        // 在递归展开之后先将结果存入记忆数组再返回
        memo[start][end] = minMoneyAmount;

        // 返回结果:该层的最小现金数
        return minMoneyAmount;
    }
}
