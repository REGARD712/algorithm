import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int l = in.nextInt();
        int r = in.nextInt();

        int count = 0;
        for (int i = l; i <= r; i++) {
            int temp = i;
            while (temp != 0) {
                int num = temp % 10;
                if (num == 2) count++;
                temp /= 10;
            }
        }

        System.out.println(count);
    }
}