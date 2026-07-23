import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0, n = popped.length;
        for (int x : pushed) {
            // 入栈
            stack.push(x);
            // 判断popped当前元素是否栈顶元素
            while (i < n && !stack.isEmpty() && popped[i] == stack.peek()) {
                // 弹出栈顶元素
                stack.pop();
                i++;
            }
        }

        return i == n;
    }
}

class ValidateStackSequences2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0, n = popped.length;
        for (int x : pushed) {
            // 入栈
            stack.push(x);
            // 判断popped当前元素是否栈顶元素
            while (i < n && !stack.isEmpty() && popped[i] == stack.peek()) {
                // 弹出栈顶元素
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
}