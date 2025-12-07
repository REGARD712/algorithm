public class MissingTwo {
    public int[] missingTwo(int[] nums) {
        int temp = 0, n = nums.length + 2;
        // 由于是找缺失的两个数字，故长度要加2
        // 把数组中的数+[1,n]所有数一起异或
        for (int i : nums) temp ^= i;
        for (int i = 1; i <= n; i++) temp ^= i;
        // 此时的temp是缺失的两个数的异或，取出二进制最右侧的1
        temp &= -temp;
        int ret1 = 0, ret2 = 0;  // ret1为对应位置为1的数，ret2则是0
        // 再次全部一起异或，以数字的最右侧二进制位是否为1将这堆数字划分成两小堆
        // 让两小堆数字分别将各自的所有数字一起异或，所得的两个数字就是所求数字
        for (int i = 1; i <= n; i++) {
            if ((i & temp) == 0) ret2 ^= i;
            else ret1 ^= i;
        }
        for (int i : nums) {
            if ((i & temp) == 0) ret2 ^= i;
            else ret1 ^= i;
        }
        return new int[]{ret1, ret2};
    }
}
