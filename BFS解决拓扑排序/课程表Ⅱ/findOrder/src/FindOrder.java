import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/course-schedule-ii/
 *
 * @ClassName: FindOrder
 * @Author: JacksonLee
 * @Date: 2026/10/10
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>(numCourses); // 邻接表存放图
        // 初始化
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int[] in = new int[numCourses]; // 用于记录每一个节点的入度值

        // 建图
        for (int[] prerequisite : prerequisites) {
            // prerequisites[a][b] -> 要学习a必须先学习b -> b是a的前提/b有一条路径指向a
            int a = prerequisite[0], b = prerequisite[1]; // b -> a
            edges.get(b).add(a); // 将入度为0的节点存入邻接表中
            in[a]++;             // 更新连接b节点的入度值
        }

        // 拓扑排序
        Queue<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[numCourses];   // 记录拓扑序列的数组
        // 1.将所有入度为0的节点放入队列
        for (int x = 0; x < numCourses; x++) {
            if (in[x] == 0) {
                queue.offer(x);
            }
        }
        // 2.层序遍历
        int i = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll(); // 取出队首元素
            // 将队首元素加入结果数组中
            ans[i++] = top;
            // 遍历队首元素对应的节点列表,将列表中的所有节点的入度值减一(删除连接线)
            for (int x : edges.get(top)) {
                // 将入度值减一,然后判断入度值是否为0(为0时是顶点,要放入队列)
                if (--in[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        // 返回结果(根据i判断是否进行层序遍历,若进行了层序遍历则说明序列数组是有存入结果的)
        return i == numCourses ? ans : new int[0];
    }
}
