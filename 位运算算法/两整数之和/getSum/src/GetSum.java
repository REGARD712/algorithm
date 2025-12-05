public class GetSum {
    public int getSum(int a, int b) {
        while (b != 0) {
            // 利用异或运算的“无进位相加”特点
            int tempa = a ^ b;
            // 再通过与运算+左移操作获取进位
            int tempb = (a & b) << 1;
            // 重复操作，直到进位为0为止
            a = tempa;
            b = tempb;
        }
        // 当进位为0，a就是相加的结果
        return a;
    }
}
