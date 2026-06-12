package frequencyOfMostFrequent;

import java.util.Arrays;

public class FrequencyOfMostFrequent {
    // sorting + sliding window + greedy TC: O(n log n) SC: O(1)
    private int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int sum = 0;
        int left = 0;
        int maxFrequency = 1;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // check cost to make nums[right] equal for all elements in window
            while (nums[right] * (right - left + 1) > sum + k) {
                sum -= nums[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }

    // Utility to deep copy an array
    private static int[] deepCopy(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }

    public static void main(String[] args) {
        FrequencyOfMostFrequent sol = new FrequencyOfMostFrequent();
        int[][] tests = {
                { 1, 2, 4 }, // k=5, output=3
                { 1, 4, 8, 13 }, // k=5, output=2
                { 3, 9, 6 }, // k=2, output=1
                { 1, 1, 1, 2, 2, 4 }, // k=0, output=3
                { 1, 2, 2, 2, 2, 2 }, // k=3, output=6
                { 1 }, // k=0, output=1
                { 1, 2, 3, 4, 5 }, // k=10, output=5
        };
        int[] ks = { 5, 5, 2, 0, 3, 0, 10 };
        int[] expected = { 3, 2, 1, 3, 6, 1, 5 };

        System.out.println("Testing maxFrequency (sliding window):");
        for (int i = 0; i < tests.length; i++) {
            int[] input = deepCopy(tests[i]);
            int result = sol.maxFrequency(input, ks[i]);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%d, Expected=%d [%s]\n", i + 1, result, expected[i],
                    pass ? "PASS" : "FAIL");
        }
    }
}
