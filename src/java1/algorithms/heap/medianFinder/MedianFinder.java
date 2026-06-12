package java1.algorithms.heap.medianFinder;

import java.util.Collections;
import java.util.PriorityQueue;

// Using two heaps: add/remove -> O(log n), findMedian -> O(1), space -> O(n)
 public class MedianFinder {

    //Contains small elements(lower half)
    PriorityQueue<Integer> maxHeap;
    //Contains big elements(higher half)
    PriorityQueue<Integer> minHeap;

    MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    private void addNum(int num) {
        //1.Push into maxHeap
        maxHeap.add(num);
        //2. balance -> move larger element from maxHeap to minHeap
        minHeap.add(maxHeap.poll());
        //3. Ensure size property
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek())/2.0;
    }

    public static void main(String[] args) {
        MedianFinder median = new MedianFinder();
        median.addNum(40);
        median.addNum(30);
        median.addNum(50);
        median.addNum(10);
        median.addNum(20);
        System.out.println(median.findMedian());
    }
}
