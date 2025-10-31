public class IsHappyNum {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = cal(n);

        while (fast != slow) {
            // slow每次走一步
            slow = cal(slow);
            // fast每次走两步
            fast = cal(cal(fast));
        }

        return fast == 1;
    }

    private int cal (int n) {
        int sum = 0;
        int t = 0;

        while (n != 0) {
            t = n % 10;
            sum += t * t;
            n /= 10;
        }

        return sum;
    }
}
