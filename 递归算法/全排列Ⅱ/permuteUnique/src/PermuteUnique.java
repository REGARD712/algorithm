import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    List<List<Integer>> ret;
    List<Integer> path;
    boolean[] check;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        check = new boolean[nums.length];

        // 将数组排序
        Arrays.sort(nums);

        dfs(nums);
        return ret;
    }

    private void dfs(int[] nums) {
        // 递归出口
        if (path.size() == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }

        // 只考虑“合法”分支
//        for (int i = 0; i < nums.length; i++) {
//            // 判断何时进入dfs函数
//            if ((check[i] == false) && (i == 0 || nums[i] != nums[i - 1] || check[i - 1] == true)) {
//                path.add(nums[i]);
//                check[i] = true;
//                dfs(nums);
//                // 回溯时恢复现场
//                path.remove(path.size() - 1);
//                check[i] = false;
//            }
//        }
        // 只考虑“不合法”分支
        for (int i = 0; i < nums.length; i++) {
            // 判断何时不进入dfs函数
            if ((check[i] == true) || (i != 0 && nums[i] == nums[i - 1] && check[i - 1] == false))
                continue;
            path.add(nums[i]);
            check[i] = true;
            dfs(nums);
            // 回溯时恢复现场
            path.remove(path.size() - 1);
            check[i] = false;
        }
    }
}
