
// Time Complexity: O(n)
// Space Complexity: O(n)
// n = length of nums
package java1.algorithms.hashmap.topKFrequentElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    private static int[] topKFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // step1: Prepare count frequency map
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step2: Bucket sort using count as index and list of numbers as value
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        // Step3: Collect top k elements
        int[] topKElements = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for(int num: buckets[i]) {
                    topKElements[idx++] = num;

                    if(idx == k) return topKElements;
                }
            }
        }

        return topKElements;
    }

    public static void main(String[] args) {
        // Test 1: General case
        System.out.println("Test 1: " + Arrays.toString(topKFrequentElements(new int[] { 1, 1, 1, 2, 2, 3 }, 2))); // [1,2]                                                                                                         // 2]

        // Test 2: k equals unique elements
        System.out.println("Test 2: " + Arrays.toString(topKFrequentElements(new int[] { 1, 2, 3 }, 3))); // [1, 2, 3]

        // Test 3: Single element
        System.out.println("Test 3: " + Arrays.toString(topKFrequentElements(new int[] { 1 }, 1))); // [1]

        // Test 4: All same elements
        System.out.println("Test 4: " + Arrays.toString(topKFrequentElements(new int[] { 5, 5, 5, 5 }, 1))); // [5]

        // Test 5: k = 1 with clear winner
        System.out.println(
                "Test 5: " + Arrays.toString(topKFrequentElements(new int[] { 1, 1, 1, 2, 2, 3, 3, 3, 3 }, 1))); // [3]

        // Test 6: Negative numbers
        System.out.println("Test 6: " + Arrays.toString(topKFrequentElements(new int[] { -1, -1, 2, 2, 2, 3 }, 2))); // [2,// -1]

        // Test 7: Two elements
        System.out.println("Test 7: " + Arrays.toString(topKFrequentElements(new int[] { 4, 4, 1, 1, 1 }, 1))); // [1]
    }
}
