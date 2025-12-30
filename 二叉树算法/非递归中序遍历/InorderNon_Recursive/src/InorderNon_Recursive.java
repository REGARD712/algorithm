import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 未完成
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
}

public class InorderNon_Recursive {
    public List<Integer> inorderNon_Recursive(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();

        while (cur != null || !stack.isEmpty()) {
            // 遍历左子树
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 寻找右节点
            cur = stack.pop();
            ret.add(cur.val);
            cur = cur.right;
        }

        return ret;
    }
}
