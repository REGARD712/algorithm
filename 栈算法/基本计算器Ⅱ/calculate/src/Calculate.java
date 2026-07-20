import java.util.Stack;

public class Calculate {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>(); char op = '+';
        int i = 0, n = s.length();
        char[] ss = s.toCharArray();

        // 遍历
        while (i < n) {
            if (ss[i] == ' ') {
                // 是空格
                i++;
            } else if (ss[i] >= '0' && ss[i] <= '9') {
                // 是数字，先提取数字
                int num = 0;
                while (i < n && (ss[i] >= '0' && ss[i] <= '9')) {
                    num = num * 10 + (ss[i++]-'0');
                }
                // 再判断运算符
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
            } else {
                // 是运算符
                op = ss[i++];
            }
        }

        // 将栈中元素求和
        int ret = 0;
        for (Integer x : stack) {
            ret += x;
        }

        return ret;
    }
}
