public class MyPow {
    public double myPow(double x, int n) {
        // 分n为正负两个情况
        return (n < 0) ? 1.0 / pow(x, -n) : pow(x, n);
    }

    public double pow(double x, int n) {
        // 递归出口
        if (n == 0) return 1.0;

        double temp = pow(x, n / 2);
        return (n % 2 == 0) ? temp * temp : temp * temp * x;
    }
}
