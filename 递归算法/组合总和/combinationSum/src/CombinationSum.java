import java.util.ArrayList;
import java.util.List;

// 解法一
public class CombinationSum {
    List<List<Integer>> ret;
    List<Integer> path;
    int aim;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        aim = target;

        dfs(candidates, 0, 0);
        return ret;
    }

    private void dfs(int[] nums, int pos, int sum) {
        if (sum == aim) {
            ret.add(new ArrayList<>(path));
            return;
        }

        // 剪枝
        if (pos == nums.length || sum > aim) return;

        // 从当前数字开始往后遍历
        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i, sum + nums[i]);
            path.remove(path.size() - 1); // 回溯时恢复现场
        }
    }
}

// 解法二
class CombinationSum2 {
    List<List<Integer>> ret;
    List<Integer> path;
    int aim;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        aim = target;

        dfs(candidates, 0, 0);
        return ret;
    }

    private void dfs(int[] nums, int pos, int sum) {
        if (sum == aim) {
            ret.add(new ArrayList<>(path));
            return;
        }

        // 剪枝
        if (pos == nums.length || sum > aim) return;

        // 考虑每个数字使用多少次
        for (int i = 0; i * nums[pos] + sum <= aim; i++) {
            if (i != 0) path.add(nums[pos]);
            dfs(nums, pos + 1, i * nums[pos] + sum); // 递归下一层
        }

        // 回溯时恢复现场
        for (int i = 1; i * nums[pos] + sum <= aim; i++) {
            path.remove(path.size() - 1);
        }
    }
}