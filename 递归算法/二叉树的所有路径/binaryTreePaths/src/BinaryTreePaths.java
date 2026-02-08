import java.util.ArrayList;
import java.util.List;

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

public class BinaryTreePaths {
    List<String> ret = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        dfs(root, path);
        return ret;
    }

    private void dfs(TreeNode root, StringBuilder path) {
        // 递归出口
        if (root == null) return;

        StringBuilder temp = new StringBuilder();
        temp.append(path);

        if (root.left == null && root.right == null) {
            temp.append(root.val);
            ret.add(temp.toString());
            return;
        } else {
            temp.append(root.val);
            temp.append("->");
        }

        if (root.left != null) dfs(root.left, temp);

        if (root.right != null) dfs(root.right, temp);
    }
}
