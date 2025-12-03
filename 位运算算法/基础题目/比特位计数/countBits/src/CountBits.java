public class CountBits {
    public int[] countBits(int n) {
        int[] ret = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // 使用计数器统计[0,n]中每一个数二进制表示中1的个数
            int count = 0;
            int temp = i;
            while (temp != 0) {
                temp &= (temp - 1);
                count++;
            }
            ret[i] = count;
        }
        return ret;
    }
}
