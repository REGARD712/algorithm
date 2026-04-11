public class FindTargetSumWays {
    int ret, aim;

    public int findTargetSumWays(int[] nums, int target) {
        aim = target;

        dfs(nums, 0, 0);
        return ret;
    }

    private void dfs(int[] nums, int pos, int path) {
        if (pos == nums.length) {
            if (path == aim) ret++;
            return;
        }

        // 加号
        dfs(nums, pos + 1, path + nums[pos]);

        // 减号
        dfs(nums, pos + 1, path - nums[pos]);
    }
}

class FindTargetSumWays2 {
    int ret, aim, path;

    public int findTargetSumWays(int[] nums, int target) {
        aim = target;

        dfs(nums, 0);
        return ret;
    }

    private void dfs(int[] nums, int pos) {
        if (pos == nums.length) {
            if (path == aim) ret++;
            return;
        }

        // 加号
        path += nums[pos];
        dfs(nums, pos + 1);
        path -= nums[pos];  // 回溯时恢复现场

        // 减号
        path -= nums[pos];
        dfs(nums, pos + 1);
        path += nums[pos];  // 回溯时恢复现场
    }
}
