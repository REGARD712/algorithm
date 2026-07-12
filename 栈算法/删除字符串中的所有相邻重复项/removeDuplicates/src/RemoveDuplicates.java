public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        // 用字符串模拟栈
        StringBuilder stack = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (!stack.isEmpty()) {
                // 取出栈顶元素并比较
                char top = stack.charAt(stack.length()-1);
                if (top == ch) {
                    // 相同元素，弹出栈顶元素
                    stack.deleteCharAt(stack.length()-1);
                    i++;
                    continue;
                }
            }
            stack.append(ch);
            i++;
        }

        // 返回结果
        return stack.toString();
    }
}
