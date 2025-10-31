public class TwoSum {
    public int[] twoSum(int[] price, int target) {
        int n = price.length, left = 0, right = n - 1;

        // 双指针遍历数组查找
        while (left < right) {
            if (price[left] + price[right] > target) {
                right--;
            } else if (price[left] + price[right] < target) {
                left++;
            } else {
                return new int[] {price[left] , price[right]};
            }
        }

        return null;
    }
}
