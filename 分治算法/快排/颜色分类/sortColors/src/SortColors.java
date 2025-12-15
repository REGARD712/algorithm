public class SortColors {
    public void sortColors(int[] nums) {
        int zeroes = -1, twos = nums.length;
        for (int i = 0; i < twos; ) {
            if (nums[i] == 0) swap(nums, ++ zeroes, i ++);
            else if (nums[i] == 2) swap(nums, -- twos, i);
            else i ++;
        }
    }

    public void sortColors1(int[] nums) {
        int n = nums.length;
        int zeroes = -1, twos = n;
        for (int i = 0; i < n; ) {
            if (i == twos) break;
            if (nums[i] == 0) {
                swap(nums, ++ zeroes, i ++);
            }
            else if (nums[i] == 2) {
                swap(nums, -- twos, i);
            } else {
                i ++;
            }
        }
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
