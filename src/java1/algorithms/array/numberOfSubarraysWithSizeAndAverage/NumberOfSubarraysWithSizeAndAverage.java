package numberOfSubarraysWithSizeAndAverage;

public class NumberOfSubarraysWithSizeAndAverage {
    //Fixed sliding window TC: O(n) SC: O(1)
    private int numberOfSubarrays(int[] nums, int k, int threshold) {
        int target = k * threshold;
        int sum = 0;
        int left = 0;
        int count = 0;

        for(int right = 0; right<nums.length; right++) {
            sum += nums[right];

            //keep window size <=k
            while(right-left+1 > k) {
                sum -= nums[left];
                left++;
            }

            //check if window size is equals to K & sum greater than target
            if(right-left+1 == k && sum >= target) {
                count++;
            }
        }

        return count;
    }

        public static void main(String[] args) {
            NumberOfSubarraysWithSizeAndAverage solver = new NumberOfSubarraysWithSizeAndAverage();
            int[][] testNums = {
                {2,2,2,2,5,5,5,8},   // 3
                {1,1,1,1,1,1,1,1},   // 0
                {11,13,17,23,29,31,7,5,2,3}, // 3
                {7,7,7,7,7,7,7},     // 5
                {1,2,3,4,5,6,7,8,9}, // 1
                {5,5,5,5,5},         // 5
                {1,2,3,1,2,3,1,2,3}, // 0
                {10,9,8,7,6,5,4,3,2,1} // 2
            };
            int[] ks = {3, 4, 3, 3, 2, 1, 3, 5};
            int[] thresholds = {4, 2, 20, 7, 8, 5, 4, 7};
            int[] expected = {3, 0, 3, 5, 1, 5, 0, 2};
            for (int i = 0; i < testNums.length; i++) {
                int result = solver.numberOfSubarrays(testNums[i], ks[i], thresholds[i]);
                String status = result == expected[i] ? "PASS" : "FAIL";
                System.out.printf("Test %d | Output: %d | Expected: %d | %s\n", i+1, result, expected[i], status);
            }
        }

}
