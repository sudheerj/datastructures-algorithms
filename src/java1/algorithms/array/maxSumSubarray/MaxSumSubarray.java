package maxSumSubarray;

public class MaxSumSubarray {
    private static int maxSumSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int currentMaxSum = nums[0], globalMaxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMaxSum = Math.max(nums[i], currentMaxSum + nums[i]);
            globalMaxSum = Math.max(currentMaxSum, globalMaxSum);
        }

        return globalMaxSum;
    }

    private static int[] maxSumSubArrayWithIndices(int[] nums) {
        int currentMaxSum = nums[0], globalMaxSum = nums[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentMaxSum + nums[i]) {
                currentMaxSum = nums[i];
                tempStart = i;
            } else {
                currentMaxSum = currentMaxSum + nums[i];
            }

            if (currentMaxSum > globalMaxSum) {
                globalMaxSum = currentMaxSum;
                start = tempStart;
                end = i;
            }

        }
        return new int[] { globalMaxSum, start, end };

    }

    public static void main(String[] args) {
        // --- maxSumSubArray tests ---
        // Test 1: Mixed positive and negative
        int[] nums1 = { -7, -2, 3, 4, -5, 6, 7, -2 };
        System.out.println("Test 1 (sum): " + maxSumSubArray(nums1)); // 15

        // Test 2: Empty array
        System.out.println("Test 2 (sum): " + maxSumSubArray(new int[] {})); // 0

        // Test 3: All negative
        System.out.println("Test 3 (sum): " + maxSumSubArray(new int[] { -3, -5, -1, -8 })); // -1

        // Test 4: Single element
        System.out.println("Test 4 (sum): " + maxSumSubArray(new int[] { 10 })); // 10

        // Test 5: All positive
        System.out.println("Test 5 (sum): " + maxSumSubArray(new int[] { 1, 2, 3, 4 })); // 10

        // --- maxSumSubArrayWithIndices tests ---
        // Test 6: Mixed positive and negative
        int[] result6 = maxSumSubArrayWithIndices(new int[] { -7, -2, 3, 4, -5, 6, 7, -2 });
        System.out.println("Test 6 (indices): sum=" + result6[0] + " start=" + result6[1] + " end=" + result6[2]); // sum=15
                                                                                                                   // start=2
                                                                                                                   // end=6

        // Test 7: All negative
        int[] result7 = maxSumSubArrayWithIndices(new int[] { -3, -5, -1, -8 });
        System.out.println("Test 7 (indices): sum=" + result7[0] + " start=" + result7[1] + " end=" + result7[2]); // sum=-1
                                                                                                                   // start=2
                                                                                                                   // end=2

        // Test 8: Single element
        int[] result8 = maxSumSubArrayWithIndices(new int[] { 10 });
        System.out.println("Test 8 (indices): sum=" + result8[0] + " start=" + result8[1] + " end=" + result8[2]); // sum=10
                                                                                                                   // start=0
                                                                                                                   // end=0

        // Test 9: All positive
        int[] result9 = maxSumSubArrayWithIndices(new int[] { 1, 2, 3, 4 });
        System.out.println("Test 9 (indices): sum=" + result9[0] + " start=" + result9[1] + " end=" + result9[2]); // sum=10
                                                                                                                   // start=0
                                                                                                                   // end=3

        // Test 10: Max subarray at the end
        int[] result10 = maxSumSubArrayWithIndices(new int[] { -1, -2, 5, 6, 7 });
        System.out.println("Test 10 (indices): sum=" + result10[0] + " start=" + result10[1] + " end=" + result10[2]); // sum=18
                                                                                                                       // start=2
                                                                                                                       // end=4

        // Test 11: Max subarray at the beginning
        int[] result11 = maxSumSubArrayWithIndices(new int[] { 5, 6, -20, 1, 2 });
        System.out.println("Test 11 (indices): sum=" + result11[0] + " start=" + result11[1] + " end=" + result11[2]); // sum=11
                                                                                                                       // start=0
                                                                                                                       // end=1
    }
}
