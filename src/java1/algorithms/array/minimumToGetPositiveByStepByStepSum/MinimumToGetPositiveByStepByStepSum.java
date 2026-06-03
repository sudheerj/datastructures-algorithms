package minimumToGetPositiveByStepByStepSum;

public class MinimumToGetPositiveByStepByStepSum {
    //Find prefixSum and minPrefixSum in each iteration. TC: O(n) SC: O(1)
    private int minStartValue(int[] nums) {
        int prefixSum = 0, minPrefixSum = 0;

        for(int num: nums) {
            prefixSum += num;
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
        }

        return 1-minPrefixSum;
    }
}
