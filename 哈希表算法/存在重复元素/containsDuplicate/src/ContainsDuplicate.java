import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(nums[i])) {
                return true;
            }
            hash.add(nums[i]);
        }

        return false;
    }
}

class ContainsDuplicate2 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                return true;
            }
            hash.put(nums[i], i);
        }

        return false;
    }
}