package twoMissingNumbers;

import java.util.Arrays;

public class TwoMissingNumbers {

    //TC: O(n) SC: O(n)
    private static int[] findTwoMissingNumbers(int[] nums) {
        boolean[] present = new boolean[nums.length + 2];
        int[] missingNums = new int[2];

        for(int num: nums) {
            present[num-1] = true;
        }

        int j=0;
        for(int i=1; i<= nums.length+2; i++){
            if(!present[i-1]) {
                missingNums[j++] = i;
            }
        }

        return missingNums;
    }

    //TC: O(n) SC: O(1)
    private static int[] findTwoMissingNumbers1(int[] nums) {
        int[] missingTwoNums = new int[2];
        int len = nums.length + 2;
        int sum = (len * (len + 1))/2;
        int numsSum = 0;

        for (int num : nums) {
            numsSum += num;
        }

        int missingTwoNumsSum = sum - numsSum;
        int missingTwoNumsAvg = missingTwoNumsSum/2;

        int sumUntilAvg = missingTwoNumsAvg * (missingTwoNumsAvg + 1)/2;
        int sumUntilNumsAvg = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= missingTwoNumsAvg) {
                sumUntilNumsAvg += nums[i];
            }
        }

        int firstMissingNum = sumUntilAvg - sumUntilNumsAvg;
        missingTwoNums[0] = firstMissingNum;
        missingTwoNums[1] = missingTwoNumsSum - firstMissingNum;

        return missingTwoNums;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 5, 1, 6, 8};
        int[] nums2 = {3, 2, 5, 1, 6, 4};

        System.out.println(Arrays.toString(findTwoMissingNumbers(nums1)));
        System.out.println(Arrays.toString(findTwoMissingNumbers(nums2)));

        System.out.println(Arrays.toString(findTwoMissingNumbers1(nums1)));
        System.out.println(Arrays.toString(findTwoMissingNumbers1(nums2)));
    }
}
