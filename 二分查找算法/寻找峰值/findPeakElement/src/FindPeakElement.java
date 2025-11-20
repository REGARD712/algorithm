public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length, left = 0, right = n - 1;

        // 利用二分算法解决
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // 左边区间中一定存在峰值
                right = mid;
            } else {
                // 右边区间中一定存在峰值
                left = mid + 1;
            }
        }

        //  返回最终结果
        return left;
    }
}
