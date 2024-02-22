//TC: O(n) SC: O(1)
package java1.algorithms.binary;

public class MissingNumber {
    private static int missingNumber1(int[] nums) {
        int missingNumber = nums.length;
        for(int i=0; i< nums.length; i++) {
            missingNumber ^= nums[i] ^ i;
        }
        return missingNumber;
    }

    // non-binary solution
    private static int missingNumber2(int[] nums) {
        int missingNumber = nums.length;
        for(int i=0; i< nums.length; i++) {
            missingNumber +=  i - nums[i];
        }
        return missingNumber;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 0};
        System.out.println(missingNumber1(nums)); 
        System.out.println(missingNumber2(nums)); 
    }
}

