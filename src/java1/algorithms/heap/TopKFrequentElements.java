package java1.algorithms.heap;

import java.util.*;

public class TopKFrequentElements {
    // TC: O(n logk) SC: O(n)
    private int[] topKFrequent(int[] nums, int k){
        int[] topElements = new int[k];
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) +1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            (a, b) -> a.getValue()-b.getValue()
        );

        for(Map.Entry<Integer, Integer> it: freqMap.entrySet()){
            queue.add(it);
            if(queue.size() > k) queue.poll();
        }

        int i = k;
        while (!queue.isEmpty()) {
            topElements[--i] = queue.poll().getKey();
        }

        return topElements;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        TopKFrequentElements elements = new TopKFrequentElements();
        System.out.println(Arrays.toString(elements.topKFrequent(nums, k)));
    }
}
