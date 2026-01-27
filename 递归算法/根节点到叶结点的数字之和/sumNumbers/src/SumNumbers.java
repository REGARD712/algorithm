import com.sun.source.tree.Tree;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int num) {
        // 求值
        num = num * 10 + root.val;
        // 递归出口
        if (root.left == null && root.right == null) return num;
        // 递归（注意：节点的左右子节点可能为空）
        int ret = 0;
        if (root.left != null) ret += dfs(root.left, num);
        if (root.right != null) ret += dfs(root.right, num);
        // 返回值
        return ret;
    }
}
