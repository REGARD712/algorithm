public class LongestOnes {
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length, left = 0, right = 0, zeroes = 0, len = 0;

        while (right < n) {
            if (nums[right] == 0 && zeroes <= k) zeroes++;  // 进窗口

            // 判断zeroes是否已经超过k的大小
            while (zeroes > k) {
                // 若zeroes大于k，就需要出窗口
                if (nums[left] != 0) left++;
                else {
                    zeroes--;
                    left++;
                }
            }
            // 若zeroes小于k，就更新结果并继续进窗口
            len = Math.max(len,right - left + 1);
            right++;
        }

        // 返回最终结果
        return len;
    }
}
