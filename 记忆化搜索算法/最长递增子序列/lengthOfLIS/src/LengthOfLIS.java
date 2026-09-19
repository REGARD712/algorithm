public class LengthOfLIS {
    int[] nums;
    int n;
    int[] memo; // 记忆数组

    public int lengthOfLIS(int[] givenNums) {
        // 初始化
        nums = givenNums;
        n = nums.length;
        memo = new int[n];
        int ret = 0; // 记录最长子序列

        // 遍历nums,以每个位置为起点找到所有递增子序列的最大值
        for (int i = 0; i < n; i++) {
            ret = Math.max(dfs(i), ret); // 更新结果
        }

        // 返回结果
        return ret;
    }

    // dfs任务:找到以pos位置为起点的递增子序列长度的最大值
    public int dfs (int pos) {
        // 递归展开之前,先查看记忆数组
        if (memo[pos] != 0) {
            return memo[pos];
        }

        int count = 0;
        for (int k = pos+1; k < n; k++) {
            if (nums[k] > nums[pos]) {
                count = Math.max(dfs(k), count);
            }
        }
        count++;

        // 递归展开之后,先将结果存入记忆数组再返回
        memo[pos] = count;
        return count;
    }
}
