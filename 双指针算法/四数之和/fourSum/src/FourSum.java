import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int i = 0, j = 0, left = 0, right = 0;
        int n = nums.length;

        // 1. 将数据排序
        Arrays.sort(nums);

        // 2. 使用双指针算法
        while (i < n) {
            // 找到三个数，和为target - nums[i]
            j = i + 1;
            long t1 = target - nums[i];
            while (j < n) {
                long t2 = t1 - nums[j];
                left = j + 1;
                right = n - 1;
                // 找到两个数，和为target - nums[i] - nums[j]
                while (left < right) {
                    if (nums[left] + nums[right] > t2) {
                        right--;
                    } else if (nums[left] + nums[right] < t2) {
                        left++;
                    } else {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 缩小搜寻范围
                        left++;
                        right--;
                        // 对left和right进行去重操作
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
                // 对j进行去重操作
                j++;
                while (j < n && nums[j] == nums[j - 1]) {
                    j++;
                }
            }
            // 对i进行去重操作
            i++;
            while (i < n && nums[i] == nums[i - 1]) {
                i++;
            }
        }

        // 返回最终结果
        return ret;
    }
}
