package java1.algorithms.heap.kthLargestElementInStream;

import java.util.PriorityQueue;

//Minheap to find kth largest element TC: O(n log k) SC: O(n)
public class KthLargestElementInStream {
    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k =k;
        this.pq = new PriorityQueue<>();

        for(int num: nums) {
            pq.offer(num);
        }
    }

    public int add(int val) {
        pq.offer(val);

        if(pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
