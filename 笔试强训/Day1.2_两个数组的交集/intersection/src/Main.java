import java.util.*;

public class Main {
    public ArrayList<Integer> intersection (ArrayList<Integer> nums1,
                                            ArrayList<Integer> nums2) {
        HashSet<Integer> hash1 = new HashSet<>(nums1);
        HashSet<Integer> hash2 = new HashSet<>();

        for (int i = 0; i < nums2.size(); i++) {
            if (hash1.contains(nums2.get(i))) hash2.add(nums2.get(i));
        }

        ArrayList<Integer> ret = new ArrayList<>(hash2);

        return  ret;
    }
}
