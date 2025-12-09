public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // 当前后两个数之差大于 d，中毒时间就是 d；当差值小于 d，中毒时间就是该差值
        int ret = 0, n = timeSeries.length;
        for (int i = 1; i < n; i++) {
            int x = timeSeries[i] - timeSeries[i - 1];
            if (x >= duration) ret += duration;
            else ret += x;
        }
        // 注意最后一个数也要中毒 d秒
        return ret + duration;
    }
}
