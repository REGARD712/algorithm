public class SingleNumber {
    public int singleNumber(int[] nums) {
        // 利用异或运算的特性
        int ret = 0;
        for (int i : nums) {
            ret ^= i;
        }
        return ret;
    }
}
