public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        // 1. 预处理 前缀和数组 和 后缀和数组
        int[] f = new int[n], g = new int[n];
        // 前缀和数组从前往后处理
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + nums[i - 1];
        }
        // 后缀和数组从后往前处理
        for (int i = n - 2; i >= 0; i--) {
            g[i] = g[i + 1] + nums[i + 1];
        }

        // 2. 解决问题
        for (int i = 0; i < n; i++) {
            if (f[i] == g[i]) return i;
        }

        // 若未能返回下标，表示不存在中心下标
        return -1;
    }
}
