import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int left = -1, mid = 0, right = nums.length;

        while (mid < right) {
            if (nums[mid] == 0) {
                // 将当前的mid的值与left+1的值交换
                // 交换后mid往后走一步
                swap(nums, mid++, ++left);
            } else if (nums[mid] == 2) {
                // 将当前的mid的值与right-1的值交换
                swap(nums, mid, --right);
            } else if (nums[mid] == 1) mid++;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
