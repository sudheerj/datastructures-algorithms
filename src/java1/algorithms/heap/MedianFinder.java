package java1.algorithms.heap;

import java.util.PriorityQueue;

// TC: O(log n) SC: O(log n)
public class MedianFinder {

    //Contains big elements
    PriorityQueue<Integer> minHeap;
    //Contains small elements
    PriorityQueue<Integer> maxHeap;

    MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> a-b );
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
    }

    private void addNum(int num) {
        minHeap.add(num);
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
