public class SearchRange {
    // 查找区间左端点
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        // 只返回两个数：元素区间的第一个位置和最后一个位置
        int[] ret = new int[]{-1,-1};

        // 处理空数组
        if (nums.length == 0)
            return ret;

        // 查找元素区间的左端点
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 位于小于t的区间中
                left = mid + 1;
            } else {
                // 位于大于等于t的区间中
                right = mid;
            }
        }
        // 执行到此处时，已经找到区间左端点，判断left和right所在位置的值是否等于target
        if (nums[left] != target)
            return ret;
        else
            ret[0] = left;

        // 查找元素区间的右端点
        right = n - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                // 位于大于t的区间中
                right = mid - 1;
            } else {
                // 位于小于等于t的区间中
                left = mid;
            }
        }
        // 执行到此处时，已经找到区间右端点
        ret[1] = left;

        // 返回最终结果
        return ret;
    }
}

