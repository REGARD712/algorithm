import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> ret;
    List<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        ret = new ArrayList<>();
        path = new ArrayList<>();

        dfs(nums, 0);

        return ret;
    }

    void dfs(int[] nums, int pos) {
        // 解法一
        // 递归出口
//        if (pos == nums.length) {
//            ret.add(new ArrayList<>(path));
//            return;
//        }
//
//        // 选择当前数字的情况
//        path.add(nums[pos]);
//        dfs(nums, pos + 1);
//        path.remove(path.size() - 1);   // 恢复现场（回溯）
//
//        // 不选择当前数字的情况
//        dfs(nums, pos + 1);

        // 解法二：更高效
        ret.add(new ArrayList<>(path));

        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);   // 恢复现场（回溯）
        }
    }
}
