import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        float a = in.nextFloat();
        String b = in.next();

        int ret = 0;
        if (a < 1.0f) {
            ret = 20;
        } else if (a > 1.0f) {
            ret = 20;
            float c = a - 1.0f;
            if (c <= 1.0) ret += 1;
            //else ret += (c - (int)c) == 0 ? (int)c : (int)c + 1;  // 向上取整
            else ret += (int)Math.ceil(c);

            // ret = 20 + Math.ceil(a - 1);
        }

        if (b.equals("y")) ret += 5;

        System.out.println(ret);
    }
}
