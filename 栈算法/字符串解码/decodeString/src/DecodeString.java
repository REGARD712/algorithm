import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public String decodeString(String s) {
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        stringStack.push(new StringBuilder());
        Deque<Integer> intStack = new ArrayDeque<>();
        int i = 0, n = s.length();
        char[] ss = s.toCharArray();

        // 遍历，分情况讨论
        while (i < n) {
            if (ss[i] >= '0' && ss[i] <= '9') {
                // 提取数字
                int num = 0;
                while (i < n && (ss[i] >= '0' && ss[i] <= '9')) {
                    num = num * 10 + (ss[i++]-'0');
                }
                // 放入数字栈
                intStack.push(num);
            } else if (ss[i] == '[') {
                i++;
                // 提取后面的字母并放入字符串栈中
                StringBuilder temp = new StringBuilder();
                while (i < n && (ss[i] >= 'a' && ss[i] <= 'z')) {
                    temp.append(ss[i++]);
                }
                // 放入字符串栈
                stringStack.push(temp);
            } else if (ss[i] == ']') {
                // 提取两个栈的栈顶元素进行解析
                StringBuilder top = stringStack.pop();
                int k = intStack.pop();
                while (k-- != 0) {
                    // 将结果添加到字符串栈的栈顶元素后面
                    stringStack.peek().append(top);
                }
                i++;
            } else {
                // 单独字符提取出来后直接添加到字符串栈栈顶元素后面
                StringBuilder temp = new StringBuilder();
                while (i < n && (ss[i] >= 'a' && ss[i] <= 'z')) {
                    temp.append(ss[i++]);
                }
                stringStack.peek().append(temp);
            }
        }

        return stringStack.pop().toString();
    }
}

class DecodeString2 {
    public String decodeString(String s) {
        Deque<String> stringStack = new ArrayDeque<>();
        stringStack.add("");
        Deque<Integer> intStack = new ArrayDeque<>();
        int i = 0, n = s.length();
        char[] ss = s.toCharArray();

        // 遍历，分情况讨论
        while (i < n) {
            if (ss[i] >= '0' && ss[i] <= '9') {
                // 提取数字
                int num = 0;
                while (i < n && (ss[i] >= '0' && ss[i] <= '9')) {
                    num = num * 10 + (ss[i++]-'0');
                }
                // 放入数字栈
                intStack.push(num);
            } else if (ss[i] == '[') {
                i++;
                // 提取后面的字母并放入字符串栈中
                StringBuilder temp = new StringBuilder();
                while (i < n && (ss[i] >= 'a' && ss[i] <= 'z')) {
                    temp.append(ss[i++]);
                }
                // 放入字符串栈
                stringStack.push(temp.toString());
            } else if (ss[i] == ']') {
                // 提取两个栈的栈顶元素进行解析
                String stringTop = stringStack.pop();
                int intTop = intStack.pop();
                StringBuilder ret = new StringBuilder();
                while (intTop > 0) {
                    ret.append(stringTop);
                    intTop--;
                }
                // 将结果添加到字符串栈的栈顶元素后面
                String temp = stringStack.pop();
                StringBuilder toAdd = new StringBuilder();
                toAdd.append(temp + ret);
                stringStack.push(toAdd.toString());
                i++;
            } else {
                // 单独字符提取出来后直接添加到字符串栈栈顶元素后面
                String temp = stringStack.pop();
                StringBuilder toAdd = new StringBuilder();
                toAdd.append(temp + ss[i++]);
                stringStack.push(toAdd.toString());
            }
        }

        return stringStack.pop();
    }
}