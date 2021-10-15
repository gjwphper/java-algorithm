package dataStructure.priority;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        // 创建一个最小堆实例
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 分别往最小堆中添加3，1，2
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(1);
        // 查看最小堆的所有元素，结果为：[1, 3, 2]
        System.out.println("minHeap: "+minHeap.toString());
        // 获取最小堆的堆顶元素
        int peekNum = minHeap.peek();
        // 结果为：1
        System.out.println("peek number: "+peekNum);
        // 删除最小堆的堆顶元素
        int pollNum = minHeap.poll();
        // 结果为：1
        System.out.println("poll number: "+pollNum);
        // 查看删除1后最小堆的堆顶元素，结果为：2
        System.out.println("peek number: "+minHeap.peek());
        // 查看新的最小堆的所有元素，结果为：[2,3]
        System.out.println("minHeap: "+minHeap.toString());
        // 查看最小堆的元素个数，也是最小堆的长度
        int heapSize = minHeap.size();
        // 结果为：2
        System.out.println("minHeap size: "+heapSize);
        // 判断最小堆是否还有元素
        boolean isEmpty = minHeap.isEmpty();
        // 结果为： false
        System.out.println("isEmpty: "+isEmpty);

    }
}
