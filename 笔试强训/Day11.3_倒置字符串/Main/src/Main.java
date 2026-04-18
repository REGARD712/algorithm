import java.util.*;

// 自己写的
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] strs = in.nextLine().split(" ");
        for (int i = strs.length - 1; i >= 0; i--) {
            System.out.print(strs[i]);
            if (i != 0) System.out.print(" ");
        }
    }
}
