package java1.algorithms.dynamicProgramming.greatestSumDivisibleByThree;

public class GreatestSumDivisibleByThree {
    //TC: O(n * 3) ~= O(n) SC: O(3) ~= O(1)
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];

        for(int num: nums) {
            // take snapshot of previous state
            int[] temp = dp.clone();

            for(int sum: temp) {
                int newSum = sum + num;

                //update best sum for this remainder
                dp[newSum%3] = Math.max(dp[newSum%3], newSum);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        GreatestSumDivisibleByThree solution = new GreatestSumDivisibleByThree();

        // Test case 1
        int[] nums1 = {3, 6, 5, 1, 8};
        int result1 = solution.maxSumDivThree(nums1);
        System.out.println("Test case 1: nums = [3,6,5,1,8]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 18");
        System.out.println("Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).");
        System.out.println();

        // Test case 2
        int[] nums2 = {4};
        int result2 = solution.maxSumDivThree(nums2);
        System.out.println("Test case 2: nums = [4]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 0");
        System.out.println("Explanation: Since 4 is not divisible by 3, do not pick any number.");
        System.out.println();

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 4};
        int result3 = solution.maxSumDivThree(nums3);
        System.out.println("Test case 3: nums = [1,2,3,4,4]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 12");
        System.out.println("Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).");
        System.out.println();

        // Test case 4
        int[] nums4 = {2, 6, 2, 2, 7};
        int result4 = solution.maxSumDivThree(nums4);
        System.out.println("Test case 4: nums = [2,6,2,2,7]");
        System.out.println("Output: " + result4);
        System.out.println("Expected: 15");
        System.out.println("Explanation: Pick numbers 6, 2, and 7 their sum is 15.");
        System.out.println();

        // Test case 5
        int[] nums5 = {5, 3, 1, 2};
        int result5 = solution.maxSumDivThree(nums5);
        System.out.println("Test case 5: nums = [5,3,1,2]");
        System.out.println("Output: " + result5);
        System.out.println("Expected: 9");
        System.out.println("Explanation: Pick numbers 5, 3, and 1 their sum is 9.");
    }
}
