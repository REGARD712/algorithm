public class HammingDistance {
    public int hammingDistance(int x, int y) {
        // 先将两个数异或，再对异或结果统计其二进制表示中1的个数
        int temp = x ^ y;
        int count = 0;
        while (temp != 0) {
            temp &= (temp - 1);
            count++;
        }
        return count;
    }
}
