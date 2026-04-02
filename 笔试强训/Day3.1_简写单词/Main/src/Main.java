import java.util.*;

public class Main {
    public static void main(String[] args) {  // ✅
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            char ch = in.next().charAt(0);
            // 判断大小写
            if (ch >= 'a' && ch <= 'z') System.out.print((char)(ch - 32));
            else System.out.print(ch);
        }
    }

    public static void main1(String[] args) {  // ❌
        Scanner in = new Scanner(System.in);

        String[] words = in.nextLine().split(" ");
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < words.length; i++)
            ret.append(words[i].toUpperCase().charAt(0));

        System.out.println(ret.toString());
    }
}
