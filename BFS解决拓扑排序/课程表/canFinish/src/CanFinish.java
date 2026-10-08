import java.util.*;

/**
 * https://leetcode.cn/problems/course-schedule/
 *
 * @ClassName: CanFinish
 * @Author: JacksonLee
 * @Date: 2026/10/8
 */
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // <顶点, 连接的节点列表>
        Map<Integer, List<Integer>> edges = new HashMap<>(); // 邻接表存放图
        int[] in = new int[numCourses];                      // 用于记录每一个顶点的入度值

        // 建图
        for (int[] prerequisite : prerequisites) {
            // prerequisites[a][b] -> 要学习a必须先学习b -> b是a的前提/b有一条路径指向a
            int a = prerequisite[0], b = prerequisite[1]; // b -> a
            if (!edges.containsKey(b)) {         // 判断邻接表中是否存在顶点(b)
                edges.put(b, new ArrayList<>()); // 将顶点存入邻接表中
            }
            edges.get(b).add(a);  // 将与顶点连接的节点添加到节点列表
            in[a]++;              // 更新连接b节点的入度值
        }

        // 拓扑排序(用来判断图中是否存在环:存在-true/不存在-false)
        Queue<Integer> queue = new ArrayDeque<>();  // 队列用于存放入度值为0的顶点
        // 1.将入度值为0的顶点放入队列
        for (int x = 0; x < numCourses; x++) {
            if (in[x] == 0) {
                queue.offer(x);
            }
        }
        // 2.层序遍历/BFS
        while (!queue.isEmpty()) {
            int top = queue.poll(); // 取出队首元素
            // 遍历队首元素对应的节点列表,将列表中的所有节点的入度值减一(删除连接线)
            for (int x : edges.getOrDefault(top, new ArrayList<>())) {
                // 将入度值减一之后判断入度值是否为0(为0时是顶点,要放入队列)
                if (--in[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        // 判断图中是否存在环(若入度数组in的所有值都为0则图中不存在环)
        for (int x : in) {
            if (x != 0) {
                // 不为0,有环
                return false;
            }
        }

        // 返回true
        return true;
    }
}
