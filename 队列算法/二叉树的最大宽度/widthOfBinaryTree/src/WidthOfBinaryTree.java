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

public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        int ret = 0, size = 0;
        List<Map<TreeNode, Integer>> queue = new ArrayList<>();
        queue.add(Map.of(root, 1));

        while (!queue.isEmpty()) {
            size = queue.size();
            int first = 0, last = 0;
            while (size-- != 0) {
                Map<TreeNode, Integer> top = queue.remove(0);
                int value = top.values().iterator().next();
                // 拿到本层的第一个元素的下标
                if (first == 0) {
                    first = value;
                }
                // 拿到本层的最后一个元素的下标
                if (size == 0) {
                    last = value;
                }
                // 让当前队头节点的左右子节点入队
                TreeNode left = top.keySet().iterator().next().left, right = top.keySet().iterator().next().right;
                if (left != null) {
                    queue.add(Map.of(left, value*2));
                }
                if (right != null) {
                    queue.add(Map.of(right, value*2+1));
                }
            }
            // 计算本层的宽度并更新结果
            ret = Math.max(ret, last - first + 1);
        }

        return ret;
    }
}

class WidthOfBinaryTree2 {
    public int widthOfBinaryTree(TreeNode root) {
        int ret = 0, size = 0;
        if (root == null) {
            return 0;
        }
        Queue<Map<TreeNode, Integer>> queue = new ArrayDeque<>();

        queue.add(Map.of(root, 1));
        while (!queue.isEmpty()) {
            size = queue.size();
            int first = 0, last = 0;
            while (size-- != 0) {
                Map<TreeNode, Integer> top = queue.poll();
                int value = top.values().iterator().next();
                // 拿到本层的第一个元素的下标
                if (first == 0) {
                    first = value;
                }
                // 拿到本层的最后一个元素的下标
                if (size == 0) {
                    last = value;
                }
                // 让当前队头节点的左右子节点入队
                TreeNode left = top.keySet().iterator().next().left, right = top.keySet().iterator().next().right;
                if (left != null) {
                    queue.add(Map.of(left, value*2));
                }
                if (right != null) {
                    queue.add(Map.of(right, value*2+1));
                }
            }
            // 计算本层的宽度并更新结果
            ret = Math.max(ret, last - first + 1);
        }

        return ret;
    }
}