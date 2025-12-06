public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ret = 0;
        // 把nums数组中所有的数的每一个二进制位分别相加并模3，所得到的就是目标数
        for (int i = 0; i < 32; i++) {
            int sumAtI = getSumAtI(nums, i);
            // 根据sumAtI的值修改ret的二进制位的值
            if (sumAtI == 0) ret &= (~(1 << i));
            else ret |= (1 << i);
        }
        return ret;
    }
    private int getSumAtI(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 先获取到数字第x为二进制位的值
            int getVal = (nums[i] >> x) & 1;
            // 再计算数组中所有元素的第x为二进制位的和
            sum += getVal;
        }
        return (sum % 3);
    }
}
