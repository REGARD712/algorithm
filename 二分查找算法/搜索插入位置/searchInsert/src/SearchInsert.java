public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length, left = 0, right = n - 1;

        // 利用查找左端点的二分算法解决
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 判断一下left或right位置的数是否小于target，若小于就返回left或right加一
        if (nums[left] != target && left == n-1) return left + 1;
        else return left;
    }
}
