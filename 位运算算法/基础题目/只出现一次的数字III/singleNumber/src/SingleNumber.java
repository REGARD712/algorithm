public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        // 先将所有数异或
        int temp = 0;
        for (int i : nums) {
            temp ^= i;
        }

        // 异或的结果是两个目标数的异或：出现两次的数均被消掉，结果是两目标异或的值
        // 通过lowbit获取到该结果的最低位的1
        temp &= (-temp);
        // 然后遍历数组查找该位不是1的数：若是1：与nums1异或；若是0：与nums2异或
        int nums1 = 0, nums2 = 0;
        for (int i : nums) {
            if ((i & temp) == 0) nums2 ^= i;
            else nums1 ^= i;
        }

        return new int[]{nums1,nums2};
    }
}
