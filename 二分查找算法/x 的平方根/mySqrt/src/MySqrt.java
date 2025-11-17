public class MySqrt {
    public int mySqrt(int x) {
        if (x < 1) return 0;

        // 防止数据过大导致溢出
        long left = 1, right = x;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }
}
