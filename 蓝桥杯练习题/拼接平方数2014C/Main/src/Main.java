import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 利用哈希表存放整形数据范围内的所有平方数
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 1; i*i <= (int)1e6; i++) {
            hash.add(i*i);
        }

        int a = in.nextInt(), b = in.nextInt();
        for (int i = a; i <= b; i++) {
            // 判断该数是否为平方数
            if (!hash.contains(i))
                continue;
            // 若是平方数，判断该数是否为拼接平方数
            // 利用字符串能够分割的特性
            String s = i + "";
            boolean flag = false;
            // 遍历字符串s，拆分判断
            for (int j = 0; j < s.length(); j++) {
                String left = s.substring(0, j + 1);
                String right = s.substring(j + 1, s.length());
                // 当left和right长度为0时，不满足题意
                if (left.length() == 0 || right.length() == 0)
                    continue;
                // 当left和right的值在哈希表中都存在，表示该数是拼接平方数
                int l = Integer.valueOf(left);
                int r = Integer.valueOf(right);
                if (hash.contains(l) && hash.contains(r)) {
                    flag = true;
                    break;
                }
            }
            // 当flag为true时，打印该拼接平方数
            if (flag)
                System.out.println(i);
        }
    }
}
