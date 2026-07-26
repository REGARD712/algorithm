import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int size = 0;
        boolean flag = false; // 标记位

        queue.add(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- != 0) {
                TreeNode top = queue.poll();
                level.add(top.val);
                // 让队头元素的左右子节点入队
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
            // 检查标志位，若为true则将数组逆序处理
            if (flag) {
                Collections.reverse(level);
            }
            // 更新结果
            ret.add(level);
            // 切换标志位
            if (!flag) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return ret;
    }
}