import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.next();
        // 如何执行消除的逻辑？
        // 用栈（括号匹配）来实现消除的逻辑，用StringBuilder模拟栈
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ((stack.length() != 0) && (stack.charAt(stack.length() - 1) == ch)) {
                // 判断栈顶元素相等，需要消除
                stack.deleteCharAt(stack.length() - 1);
            } else stack.append(ch);
        }

        System.out.println((stack.length() == 0) ? 0 : stack.toString());
    }
}