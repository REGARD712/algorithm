import java.util.*;

public class Main {
    // 将x进制转换为y进制
    public static String trans (int x, int y) {
        StringBuilder s = new StringBuilder("");
        String ret = new String("");

        // 取余法转换
        while (x > 0) {
            int temp = x % y;
            if (temp >= 10) {
                // 大于等于10的用字母表示
                char tempChar = (char)(temp - 10 + (int)'A');
                s.append(tempChar);
            } else {
                // 否则直接拼接字符串
                char tempChar = (char)(temp + (int)'0');
                s.append(tempChar);
            }
            x /= y;
        }

        // 反转字符串
        ret = s.reverse().toString();
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 输入进制数
        int p = in.nextInt();

        // 嵌套循环打印乘法表
        for (int i = 1; i < p; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(trans(i, p) + "*" + trans(j, p) + "=" + trans(i * j, p) + " ");
            }
            System.out.println();
        }
    }
}
