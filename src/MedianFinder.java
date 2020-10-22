import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    // 较小的前半部分(堆顶元素最大)
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
    // 较大的后半部分(堆顶元素最小)
    private PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    // 已有元素个数
    private int count;

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (count == 0) {
            maxQueue.add(num);
            count++;
            return;
        }
        if (count % 2 == 0) {
            // 已有元素为偶数个，新元素加入后，保持maxQueue比minQueue个数多1
            if (num <= minQueue.peek()) {
                maxQueue.add(num);
            } else {
                minQueue.add(num);
                maxQueue.add(minQueue.poll());
            }
        } else {
            // 已有元素为奇数个，加入元素后，保持两边个数相等
            if (num >= maxQueue.peek()) {
                minQueue.add(num);
            } else {
                maxQueue.add(num);
                minQueue.add(maxQueue.poll());
            }
        }
        count++;
    }

    public double findMedian() {
        if (count == 0) {
            return 0;
        }
        if (count % 2 == 0) {
            return (minQueue.peek() + maxQueue.peek()) / 2.0d;
        } else {
            return maxQueue.peek();
        }
    }
}
