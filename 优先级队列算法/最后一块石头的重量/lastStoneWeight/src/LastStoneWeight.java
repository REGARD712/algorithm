import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // 创建大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b -a); // 大根堆

        // 将元素全部放进堆中
        for (int stone : stones) {
            pq.offer(stone);
        }

        // 模拟
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
