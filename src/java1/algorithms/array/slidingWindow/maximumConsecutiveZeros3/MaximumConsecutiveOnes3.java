package slidingWindow.maximumConsecutiveZeros3;

public class MaximumConsecutiveOnes3 {
    //Sliding window TC: O(n) SC: O(1)
    private int longestOnes(int[] nums, int k) {
        int left = 0, zeros = 0, maxLen = 0;

        for(int right=0; right<nums.length; right++) {
            if(nums[right] == 0) {
                zeros++;
            }

            while(zeros > k) {
                if(nums[left] == 0) {
                    zeros--;
                }

                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
