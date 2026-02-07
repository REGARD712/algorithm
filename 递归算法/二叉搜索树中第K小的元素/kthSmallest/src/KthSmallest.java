class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class KthSmallest {
    int count = 0;
    int ret = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return ret;
    }

    private void dfs(TreeNode root) {
        // 递归出口
        if (root == null || count <= 0) return;

        dfs(root.left);

        if (count <= 0) return;
        count--;
        if (count == 0) ret = root.val;

        if (count <= 0) return;
        dfs(root.right);
    }
}
