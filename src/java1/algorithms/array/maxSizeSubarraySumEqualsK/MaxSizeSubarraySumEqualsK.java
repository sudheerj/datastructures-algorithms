package maxSizeSubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarraySumEqualsK {
    //Using prefixSum map({sum, index}) TC: O(n) SC: O(n)
    private int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];

            //check if whole array from 0 works
            if(sum == k) {
                maxLength = i+1;
            }

            //check if sum-k prefixsum saw before 
            if(prefixSumMap.containsKey(sum-k)) {
                int len = i - prefixSumMap.get(sum-k);
                maxLength = Math.max(maxLength, len);
            }

            //if we are seeing sum for first time
            if(!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }

        return maxLength;
    }
}
