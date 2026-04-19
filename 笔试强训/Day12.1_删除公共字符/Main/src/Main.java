import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        boolean[] hash = new boolean[300];
        String s2 = in.nextLine();
        for (int i = 0; i < s2.length(); i++) {
            hash[s2.charAt(i)] = true;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (!hash[s1.charAt(i)]) System.out.println(s1.charAt(i));
        }
    }
}
