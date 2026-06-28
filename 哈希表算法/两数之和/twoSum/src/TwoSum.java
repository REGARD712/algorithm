import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 解法二：利用哈希表来存放前面的元素
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (hash.containsKey(x)) {
                return new int[]{i, hash.get(x)};
            } else {
                hash.put(nums[i], i);
            }
        }

        return null;
    }
}

class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        // 解法一：暴力解法
        for (int i = 0; i < nums.length; i++) {
            // 先固定一个数
            for (int j = i-1; j >= 0; j--) {
                // 与该数之前的数相加
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}