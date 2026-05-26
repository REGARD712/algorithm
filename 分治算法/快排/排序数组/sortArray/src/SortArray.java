import java.util.Random;

public class SortArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {
        // 出口
        if (start >= end) {
            return;
        }

        // 随机选择基准值
        int key = nums[new Random().nextInt(end-start+1) + start];

        // 三指针法将数组划分为三块：左边小于key、中间等于key、右边大于key
        int left = start-1, i = start, right = end+1;
        while (i < right) {
            if (nums[i] < key) {
                // 将i位置的值与left-1的值交换
                swap(nums, i++, ++left);
            } else if (nums[i] > key) {
                swap(nums, i, --right);
            } else i++;
        }

        // 递归左右子树
        quickSort(nums, start, left);
        quickSort(nums, right, end);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
