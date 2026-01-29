class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode () {}
    TreeNode (int val) {
        this.val = val;
    }
    TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class IsValidBST {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // 递归出口
        if (root == null) return true;

        // 中序遍历递归
        boolean left = isValidBST(root.left);
        // 剪枝
        if (left == false) return false;

        boolean cur = false;
        if (root.val > prev) cur = true;
        // 剪枝
        if (cur == false) return false;
        prev = root.val;

        boolean right = isValidBST(root.right);

        return (left && cur && right);
    }
}
