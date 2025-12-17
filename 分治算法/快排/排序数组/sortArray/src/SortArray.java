import java.util.Random;

public class SortArray {
    public int[] sortArray(int[] nums) {
        // 利用快排原理解决
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        // 递归结束条件
        if (l >= r) return;

        int i = l, left = l - 1, right = r + 1;
        int key = nums[new Random().nextInt(r - l + 1) + l];

        // 划分三个区间
        while (i < right) {
            if (nums[i] < key) swap(nums, ++ left, i ++);
            else if (nums[i] > key) swap(nums, -- right, i);
            else i ++;
        }

        // 递归：[l, left] [left + 1, right - 1] [right, r]
        quickSort(nums, l, left);
        quickSort(nums, right, r);
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
