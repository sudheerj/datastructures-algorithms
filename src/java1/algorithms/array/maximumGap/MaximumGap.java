package java1.algorithms.array.maximumGap;

import java.util.Arrays;

public class MaximumGap {
    // Bucket sort or Pegion hole principle TC: O(n) SC: O(n)
    private static int maximumGap(int[] nums) {
        // Edge case: if number of elements less than 2, no gap possible
        if (nums == null || nums.length < 2)
            return 0;
        int n = nums.length;

        // Find global maximum and minimum in array. It is useful to define bucket
        // ranges
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // If all numbers are same, maxGap is 0
        if (max == min) {
            return 0;
        }

        // Distribute numbers into ranges so that max gap is not in same bucket
        int bucketSize = (int) Math.ceil((double) (max - min) / n - 1);

        // Find number of buckets to cover all ranges
        int bucketCount = (max - min) / bucketSize + 1;

        // Each stores only min and max values
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        // Initialize with empty markers
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Fill numbers in buckets
        for (int num : nums) {
            int index = (num - min) / bucketSize;

            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
        }

        // Compute max gap by scanning all buckets
        int maxGap = 0;
        // Previous bucket max starting with global min
        int previousMax = min;

        for (int i = 0; i < bucketCount; i++) {
            // Ignore empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }

            // gap = current bucket min - previous bucket max
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            // Update previous max for next comparison
            previousMax = bucketMax[i];
        }

        return maxGap;

    }

    public static void main(String[] args) {
        // Test 1: [3,6,9,1] → 3
        System.out.println(maximumGap(new int[] { 3, 6, 9, 1 })); // 3

        // Test 2: [10] → 0 (single element)
        System.out.println(maximumGap(new int[] { 10 })); // 0

        // Test 3: [1,1,1,1] → 0 (all same)
        System.out.println(maximumGap(new int[] { 1, 1, 1, 1 })); // 0

        // Test 4: [1,10000000] → 9999999
        System.out.println(maximumGap(new int[] { 1, 10000000 })); // 9999999

        // Test 5: [1,3,6,10] → 4 (gap between 6 and 10)
        System.out.println(maximumGap(new int[] { 1, 3, 6, 10 })); // 4

        // Test 6: [5,1] → 4
        System.out.println(maximumGap(new int[] { 5, 1 })); // 4
    }
}
