public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        // 1. 初始化窗口
        int left = 0, right = 0;
        int sum = 0, len = Integer.MAX_VALUE, temp = 0;
        int n = nums.length;

        // 2. 找符合条件的子数组
        while (right < n) {
            sum += nums[right];     // 进窗口
            while (sum >= target) {  // 若满足条件，更新结果，然后出窗口
                temp = right - left + 1;
                len = Math.min(len,temp);
                sum -= nums[left++];
            }
            // 若不满足条件，就继续进窗口
            right++;
        }

        // 3. 返回结果
        // if (len != Integer.MAX_VALUE) {
        //     return len;
        // } else {    // 针对不存在符合条件的子数组的情况
        //     return 0;
        // }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
