class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
}

public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        // 递归出口
        if (root == null) return null;

        // 递归：后序
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 返回
        if (root.left == null && root.right == null && root.val == 0)
            root = null;
        return root;
    }
}
