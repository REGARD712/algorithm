import java.util.PriorityQueue;

/**
 * @ClassName: MedianFinder
 * @Author: JacksonLee
 * @Date: 2026/8/21
 * @Description: 实现动态维护数据流中位数的类
 */
public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        int m = maxHeap.size(), n = minHeap.size();
        if (m == n) {
            if (m == 0 || num <= maxHeap.peek()) {
                // 直接进入大堆
                maxHeap.offer(num);
            } else {
                // 先进入小堆，再将堆顶元素放到大堆
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }
        } else if (m == n+1) {
            if (num <= maxHeap.peek()) {
                // 先进入大堆，再将堆顶元素放到小堆
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            } else {
                // 直接进入小堆
                minHeap.offer(num);
            }
        }
    }

    public double findMedian() {
        int m = maxHeap.size(), n = minHeap.size();
        if (m == n) {
            return (maxHeap.peek()+minHeap.peek()) / 2.0;
        } else if (m == n+1) {
            return maxHeap.peek() * 1.0;
        }
        return 0;
    }
}
