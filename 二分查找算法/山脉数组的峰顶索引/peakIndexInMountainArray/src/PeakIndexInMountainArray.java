public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        // 第一个元素和最后一个元素不可能是结果，因此跳过这两个元素
        int left = 1, right = n - 2;

        // 利用二分算法解决
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] > arr[mid-1]) {
                // 处于“后比前大”区间
                left = mid;
            } else {
                // 处于“后比前小”区间
                right = mid - 1;
            }
        }

        // 返回最终结果
        return left;
    }
}
