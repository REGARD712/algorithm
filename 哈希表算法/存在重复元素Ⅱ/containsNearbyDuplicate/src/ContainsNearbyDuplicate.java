import java.util.HashMap;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                // 找到相同元素，取出下标作差比较
                if (i - hash.get(nums[i]) <= k) {
                    return true;
                }
            }
            // 将当前元素存入哈希表中
            hash.put(nums[i], i);
        }

        return false;
    }
}

class ContainsNearbyDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                // 找到相同元素，取出下标作差比较
                int v = Math.abs(i - hash.get(nums[i]));
                if (v <= k) {
                    return true;
                }
            }
            // 将当前元素存入哈希表中
            hash.put(nums[i], i);
        }

        return false;
    }
}