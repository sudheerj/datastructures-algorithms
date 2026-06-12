package largestOutlier;

import java.util.HashMap;
import java.util.Map;

public class LargestOutlier {
   //Try all candidates + validates remaining structure TC: O(n) SC: O(n)
   private int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int sum = 0;

        for(int num: nums) {
            sum += num;
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        int largestOutlier = Integer.MIN_VALUE;

        //try all candidates as outlier
        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)-1);

            int remaining = sum - num;

            if(remaining%2 == 0) {
                int target = remaining/2;

                if(freqMap.getOrDefault(target, 0) > 0) {
                    largestOutlier = Math.max(largestOutlier, num);
                }
            }

            //restore for other iterations
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        return largestOutlier;
   } 
    public static void main(String[] args) {
        LargestOutlier solver = new LargestOutlier();
        int[][] testCases = {
            {1, 2, 3, 4, 6},         // 6
            {1, 1, 1, 3, 5},         // 5
            {2, 2, 2, 2, 8},         // 8
            {1, 2, 3, 5, 9},         // 9
            {1, 2, 3, 4, 5},         // -2147483648 (no outlier)
            {10, 20, 30, 40, 100},   // 100
            {5, 5, 10, 15, 25},      // 25
            {1, 1, 1, 1, 1},         // -2147483648 (no outlier)
        };
        int[] expected = {6, 5, 8, 9, Integer.MIN_VALUE, 100, 25, Integer.MIN_VALUE};
        for (int i = 0; i < testCases.length; i++) {
            int result = solver.getLargestOutlier(testCases[i]);
            String status = result == expected[i] ? "PASS" : "FAIL";
            System.out.printf("Test %d | Output: %d | Expected: %d | %s\n", i+1, result, expected[i], status);
        }
    }

}
