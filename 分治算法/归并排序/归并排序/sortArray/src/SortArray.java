public class SortArray {
    int[] arr;

    public int[] sortArray(int[] nums) {
        arr = new int[nums.length];

        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);

        // 合并
        int ptr1 = left, ptr2 = mid+1, k = 0;
        while (ptr1 <= mid && ptr2 <= right) {
            arr[k++] = nums[ptr1] <= nums[ptr2] ? nums[ptr1++] : nums[ptr2++];
        }
        while (ptr1 <= mid) {
            arr[k++] = nums[ptr1++];
        }
        while (ptr2 <= right) {
            arr[k++] = nums[ptr2++];
        }
        // 将合并后的结果复制回原数组
        for (int i = 0; i < k; i++) {
            nums[left + i] = arr[i];
        }
    }
}
