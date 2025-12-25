import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
}

public class PreorderNon_Recursive {
    public List<Integer> preorderNon_Recursive(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();

        while (cur != null || !stack.isEmpty()) {
            // 遍历左子树并入栈
            while (cur != null) {
                stack.push(cur);
                ret.add(cur.val);
                cur = cur.left;
            }
            // 根据弹出的栈顶结点找到右节点
            TreeNode top = stack.pop();
            cur = top.right;
        }

        return ret;
    }
}
