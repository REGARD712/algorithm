public class LengthOfLIS {
    int[] nums, memo;
    int n;

    public int lengthOfLIS(int[] givenNums) {
        nums = givenNums; n = nums.length;
        memo = new int[n]; // 备忘录

        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(dfs(i), ret); // 查找所有子序列的最大长度
        }
        return ret;
    }

    private int dfs(int pos) {
        // 查看memo中是否存在结果
        if (memo[pos] != 0) {
            return memo[pos];
        }

        // 查找以pos位置为起始的子序列的长度
        int ret = 0;
        for (int i = pos+1; i < n; i++) {
            if (nums[i] > nums[pos]) {
                ret = Math.max(dfs(i), ret);
            }
        }
        // 加上当前位置
        ret++;
        // 在返回之前将结果存到memo中
        memo[pos] = ret;
        return ret;
    }
}
