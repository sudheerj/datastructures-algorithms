package java1.algorithms.heap.medianFinder;

import java.util.Collections;
import java.util.PriorityQueue;

// Using two heaps: add/remove -> O(log n), findMedian -> O(1), space -> O(n)
 public class MedianFinder {

    //Contains small elements
    PriorityQueue<Integer> maxHeap;
    //Contains big elements
    PriorityQueue<Integer> minHeap;

    MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    private void addNum(int num) {
        maxHeap.add(num);
        maxHeap.add(minHeap.poll());
        if(minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    private double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
        return minHeap.peek();
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
