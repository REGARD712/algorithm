public class MinOperations {
    public static int minOperations(int[] nums, int x) {
        int n = nums.length, left = 0, right = 0;
        int sum = 0, target = 0, len = -1;

        for (int i = 0; i < n; i++) {
            target += nums[i];
        }
        target -= x;
        // 当x比数组中元素总和大，target为负数，返回-1
        if (target < 0) return -1;

        while (right < n) {
            sum += nums[right];  // 进窗口

            // sum大于target，需要出窗口
            while (sum > target) {
                sum -= nums[left++];
            }
            // sum等于target，更新结果
            if (sum == target) {
                len = Math.max(len,right - left + 1);
            }
            // sum小于target，需要继续进窗口
            right++;
        }

        // 返回最终结果
        if (len == -1) return len;
        else return (n - len);
    }
}
