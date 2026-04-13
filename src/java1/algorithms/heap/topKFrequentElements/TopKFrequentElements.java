package java1.algorithms.heap.topKFrequentElements;

import java.util.*;

public class TopKFrequentElements {
    // TC: O(n logk) SC: O(n)
    private int[] topKFrequent(int[] nums, int k){
        //Step1: Create FrequencyMap
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) +1);
        }

        //Step2: Min heap to build top K elements
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a, b) -> freqMap.get(a)-freqMap.get(b)
        );

        for(int num: freqMap.keySet()){
            queue.add(num);
            if(queue.size() > k) queue.poll();
        }

        //Step3: Build the result array
        int[] topElements = new int[k]; 
        for(int i=k-1; i>=0; i--) {
            topElements[i] = queue.poll();
        }
            
        return topElements;
    }

    public static void main(String[] args) {
        TopKFrequentElements elements = new TopKFrequentElements();

        // Test 1: General case
        System.out.println("Test 1: " + Arrays.toString(elements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))); // [2, 1]

        // Test 2: Single element
        System.out.println("Test 2: " + Arrays.toString(elements.topKFrequent(new int[]{1}, 1))); // [1]

        // Test 3: All same elements
        System.out.println("Test 3: " + Arrays.toString(elements.topKFrequent(new int[]{5, 5, 5, 5}, 1))); // [5]

        // Test 4: k equals unique elements
        System.out.println("Test 4: " + Arrays.toString(elements.topKFrequent(new int[]{1, 2, 3}, 3))); // [1, 2, 3]

        // Test 5: k = 1 with clear winner
        System.out.println("Test 5: " + Arrays.toString(elements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3}, 1))); // [3]

        // Test 6: Negative numbers
        System.out.println("Test 6: " + Arrays.toString(elements.topKFrequent(new int[]{-1, -1, 2, 2, 2, 3}, 2))); // [-1, 2]

        // Test 7: Two elements with different frequencies
        System.out.println("Test 7: " + Arrays.toString(elements.topKFrequent(new int[]{4, 4, 1, 1, 1}, 1))); // [1]
    }
}
