public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 1. 预处理“前缀积数组”和“后缀积数组”
        int[] f = new int[n], g = new int[n];
        // 处理细节问题
        f[0] = g[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            g[i] = g[i + 1] * nums[i + 1];
        }

        // 2. 利用f和g解决问题
        for (int i = 0; i < n; i++) {
            answer[i] = f[i] * g[i];
        }

        // 3. 返回最终结果
        return answer;
    }
}
