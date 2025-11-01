import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int i = 0, left = 0, right = 0;
        int n = nums.length;

        // 1. 对数组进行排序
        Arrays.sort(nums);

        // 2. 使用双指针算法寻找三元组
        while (i < n) {
            if (nums[i] > 0)
                break;
            left = i + 1;
            right = n - 1;
            int t = -nums[i];
            // 在 left-right 范围内寻找和为t的两个数
            while (left < right) {
                if (nums[left] + nums[right] > t) {
                    right--;
                } else if (nums[left] + nums[right] < t) {
                    left++;
                } else {
                    // 将找到的三元组通过Arrays集合类的asList方法转换为List，然后用尾插法插入ret
                    ret.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 缩小下一次寻找的范围
                    left++;
                    right--;
                    // 对left和right进行去重操作
                    while (left<right && nums[left-1] == nums[left]) {
                        left++;
                    }
                    while (left<right && nums[right+1] == nums[right]) {
                        right--;
                    }
                }
            }
            // 对i进行去重操作
            i++;
            while (i<n && nums[i-1] == nums[i]) {
                i++;
            }
        }

        // 返回最终结果
        return ret;
    }
}
