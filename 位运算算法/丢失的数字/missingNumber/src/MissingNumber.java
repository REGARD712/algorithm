public class MissingNumber {
    // 解法一：哈希表
    // 时间复杂度：O（n）；空间复杂度：O（n）
    public int missingNumber1(int[] nums) {
        int n = nums.length;
        // 利用哈希表存放每个数字是否出现
        int[] hash = new int[n + 1];
        for (int i = 0; i < n; i++) if (hash[nums[i]] == 0) hash[nums[i]]++;
        for (int i = 0; i <= n; i++) if (hash[i] == 0) return i;
        return -1;
    }

    // 解法二：高斯求和
    // 时间复杂度：O（n）；空间复杂度：O（1）
    public int missingNumber2(int[] nums) {
        int n = nums.length, sum = 0, numSum = 0;

        // 先求0~n中所有数之和
        for (int i = 0; i <= n; i++) sum += i;

        // 再求nums数组中所有元素之和
        for (int i = 0; i < n; i++) numSum += nums[i];

        // 两和之差即为丢失的数字
        return sum - numSum;
    }

    // 解法三：位运算
    // 时间复杂度：O（n）；空间复杂度：O（1）
    public int missingNumber(int[] nums) {
        int ret = 0;

        // 将nums数组中的所有元素都一起异或
        for (int x : nums) ret ^= x;

        // 再与0~n之间的所有元素异或
        for (int i = 0; i <= nums.length; i++) ret ^= i;

        // 最后所得即为丢失的数字
        return ret;
    }
}
