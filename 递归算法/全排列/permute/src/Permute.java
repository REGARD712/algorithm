import java.util.ArrayList;
import java.util.List;

public class Permute {
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] check;

    public List<List<Integer>> permute(int[] nums) {
        check = new boolean[nums.length];
        dfs(nums);
        return ret;
    }

    void dfs(int[] nums) {
        // 递归出口：path和 nums数组长度相等时，更新结果
        if (path.size() == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (check[i] == false) {
                path.add(nums[i]);
                check[i] = true;
                // 递归
                dfs(nums);
                // 回溯恢复现场
                check[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
