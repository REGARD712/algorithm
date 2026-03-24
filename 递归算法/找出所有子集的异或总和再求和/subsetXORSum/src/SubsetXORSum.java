public class SubsetXORSum {
    int path;
    int sum;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0);
        return sum;
    }

    private void dfs(int[] nums, int pos) {
        sum += path;

        for (int i = pos; i < nums.length; i++) {
            path ^= nums[i];
            dfs(nums, i + 1);
            path ^= nums[i];  // 回溯时恢复现场
        }
    }
}
