package java1.algorithms.binary.missingNumber;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    // Non-binary solution(i.e, sum difference) TC: O(n) SC: O(1)
    private static int missingNumber1(int[] nums) {
        int missingNumber = nums.length;
        for(int i=0; i< nums.length; i++) {
            missingNumber +=  i - nums[i];
        }
        return missingNumber;
    }
    //Using XOR operation - TC: O(n) SC: O(1)
    private static int missingNumber2(int[] nums) {
        int missingNumber = nums.length;
        for(int i=0; i< nums.length; i++) {
            missingNumber ^= i ^ nums[i];
        }
        return missingNumber;
    }

    //Using hashset TC: O(n) SC: O(n)
    private static int missingNumber3(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums) {
            numSet.add(num);
        }

        int n = nums.length;
        for(int i=0; i<=n; i++) {
            if(!numSet.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,1,0};
        int[] nums2 = {5,9,7,1,2,4,0,6,8,3};
        int[] nums3 = {0};
        int[] nums4 = {1};
        int[] nums5 = {0,1,2,3,4,5,6,7,9};

        // Approach 1: sum difference
        int r1 = missingNumber1(nums1);
        System.out.println("Test 1a (sum) - [3,1,0]: " + (r1 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=2");
        int r2 = missingNumber1(nums2);
        System.out.println("Test 2a (sum) - 10-elem missing 10: " + (r2 == 10 ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=10");
        int r3 = missingNumber1(nums3);
        System.out.println("Test 3a (sum) - [0]: " + (r3 == 1 ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=1");
        int r4 = missingNumber1(nums4);
        System.out.println("Test 4a (sum) - [1]: " + (r4 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=0");
        int r5 = missingNumber1(nums5);
        System.out.println("Test 5a (sum) - missing 8: " + (r5 == 8 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=8");

        // Approach 2: XOR
        int r6 = missingNumber2(nums1);
        System.out.println("Test 1b (xor) - [3,1,0]: " + (r6 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r6 + " expected=2");
        int r7 = missingNumber2(nums2);
        System.out.println("Test 2b (xor) - 10-elem missing 10: " + (r7 == 10 ? "[PASS]" : "[FAIL]") + " result=" + r7 + " expected=10");
        int r8 = missingNumber2(nums3);
        System.out.println("Test 3b (xor) - [0]: " + (r8 == 1 ? "[PASS]" : "[FAIL]") + " result=" + r8 + " expected=1");
        int r9 = missingNumber2(nums4);
        System.out.println("Test 4b (xor) - [1]: " + (r9 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r9 + " expected=0");
        int r10 = missingNumber2(nums5);
        System.out.println("Test 5b (xor) - missing 8: " + (r10 == 8 ? "[PASS]" : "[FAIL]") + " result=" + r10 + " expected=8");

        // Approach 3: HashSet
        int r11 = missingNumber3(nums1);
        System.out.println("Test 1c (set) - [3,1,0]: " + (r11 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r11 + " expected=2");
        int r12 = missingNumber3(nums2);
        System.out.println("Test 2c (set) - 10-elem missing 10: " + (r12 == 10 ? "[PASS]" : "[FAIL]") + " result=" + r12 + " expected=10");
        int r13 = missingNumber3(nums3);
        System.out.println("Test 3c (set) - [0]: " + (r13 == 1 ? "[PASS]" : "[FAIL]") + " result=" + r13 + " expected=1");
        int r14 = missingNumber3(nums4);
        System.out.println("Test 4c (set) - [1]: " + (r14 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r14 + " expected=0");
        int r15 = missingNumber3(nums5);
        System.out.println("Test 5c (set) - missing 8: " + (r15 == 8 ? "[PASS]" : "[FAIL]") + " result=" + r15 + " expected=8");
    }
}

