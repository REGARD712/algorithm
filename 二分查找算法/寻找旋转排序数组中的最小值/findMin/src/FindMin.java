public class FindMin {
    public int findMin(int[] nums) {
        int n = nums.length, left = 0, right = n - 1;

        // 利用二分算法解决
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
