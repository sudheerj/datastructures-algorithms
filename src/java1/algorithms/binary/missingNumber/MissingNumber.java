package java1.algorithms.binary.missingNumber;

public class MissingNumber {
    //Using XOR operation - TC: O(n) SC: O(1)
    private static int missingNumber1(int[] nums) {
        int missingNumber = nums.length;
        for(int i=0; i< nums.length; i++) {
            missingNumber ^= nums[i] ^ i;
        }
        return missingNumber;
    }

    // non-binary solution TC: O(n) SC: O(1)
    private static int missingNumber2(int[] nums) {
        int missingNumber = nums.length;
        for(int i=0; i< nums.length; i++) {
            missingNumber +=  i - nums[i];
        }
        return missingNumber;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 0};
        int[] nums2 = {5, 9, 7, 1, 2, 4, 0, 6, 8, 3};
        System.out.println(missingNumber1(nums1)); 
        System.out.println(missingNumber2(nums1)); 

        System.out.println(missingNumber1(nums2)); 
        System.out.println(missingNumber2(nums2)); 
    }
}

