import java.util.Arrays;

public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        int ret = 0, left = 0, right = 0, n = nums.length;

        // 1.对数据进行排序
        Arrays.sort(nums);

        // 2.统计有效的三元组的个数
        for (int i = n-1; i >= 2; i--) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ret += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ret;
    }
}
