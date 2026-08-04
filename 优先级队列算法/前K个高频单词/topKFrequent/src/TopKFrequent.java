import java.util.*;

public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        // 用一个哈希表统计每个单词出现的频次
        HashMap<String, Integer> hash = new HashMap<>();
        for (String word : words) {
            hash.put(word, hash.getOrDefault(word, 0) + 1);
        }

        // 创建一个大小为k的堆
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            if (hash.get(a).equals(hash.get(b))) {
                return b.compareTo(a); // 如果频次相同，按字典序降序排列（大根堆）
            }
            return hash.get(a) - hash.get(b); // 按频次升序排列（小根堆）
        });

        // 让元素依次进堆
        for (String word : hash.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll(); // 如果堆的大小超过k，弹出堆顶元素
            }
        }

        // 提取结果
        List<String> ret = new ArrayList<>();
        while (!heap.isEmpty()) {
            ret.add(heap.poll());
        }
        // 逆序结果数组
        Collections.reverse(ret);
        return ret;
    }
}
