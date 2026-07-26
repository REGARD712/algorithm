import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        int size = 0;

        queue.add(root);
        while (!queue.isEmpty()) {
            // 先统计队列中的元素个数，决定当前层出队的元素个数
            size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 取出队头元素
                Node top = queue.poll();
                // 添加到结果
                level.add(top.val);
                // 让队头元素的子节点入队
                for (Node child : top.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            ret.add(level);
        }
        return ret;
    }
}

class LevelOrder2 {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        int size = 0;

        queue.add(root);
        while (!queue.isEmpty()) {
            // 先统计队列中的元素个数，决定当前层出队的元素个数
            size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- != 0) {
                // 取出队头元素
                Node top = queue.poll();
                // 添加到结果
                level.add(top.val);
                // 让队头元素的子节点入队
                for (Node child : top.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            ret.add(level);
        }
        return ret;
    }
}