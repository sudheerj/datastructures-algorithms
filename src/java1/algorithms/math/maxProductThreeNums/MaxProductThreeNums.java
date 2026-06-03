package java1.algorithms.math.maxProductThreeNums;

import java.util.Arrays;

public class MaxProductThreeNums {
   //Simple sorting solution TC: O(n log n) SC: O(1)
   public static int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return Math.max(nums[n-3] * nums[n-2] * nums[n-1], nums[0] * nums[1] * nums[n-1]);
   }

   //Optimal greedy solution TC: O(n) SC: O(1)
   public static int maximumProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num: nums) {
            //update largest 3 elements
            if(num > max1) {
                max3= max2;
                max2 = max1;
                max1 = num;
            } else if(num > max2) {
                max3 = max2;
                max2 = num;
            } else if(num > max3) {
                max3 = num;
            }

            //update smallest 2 elements
            if(num < min1) {
                min2 = min1;
                min1 = num;
            } else if(num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
   }

   public static void main(String[] args) {
        int[][] inputs = {
                { -3, 1, 2, -2, 5, 6 },
                { -10, -10, 1, 3, 2 },
                { 1, 2, 3 },
                { -1, -2, -3, -4 },
                { -5, -4, 1, 2, 3 },
                { 1, 2, 3, 4 },
        };
        int[] expected = { 60, 300, 6, -6, 60, 24 };

        System.out.println("=== maximumProduct1 (sorting) ===");
        for (int i = 0; i < inputs.length; i++) {
            int result = maximumProduct1(inputs[i].clone());
            String status = result == expected[i] ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected[i]);
        }

        System.out.println("=== maximumProduct2 (greedy) ===");
        for (int i = 0; i < inputs.length; i++) {
            int result = maximumProduct2(inputs[i].clone());
            String status = result == expected[i] ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected[i]);
        }
   }
}
