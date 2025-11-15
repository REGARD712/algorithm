import java.util.ArrayList;
import java.util.List;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        List<Integer> ret = new ArrayList<>();

        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                ret.add(mid);
            }
        }

        return ret;
    }
}

