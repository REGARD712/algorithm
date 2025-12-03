public class HammingWeight {
    public int hammingWeight(int n) {
        // 统计二进制表示中1的个数
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
