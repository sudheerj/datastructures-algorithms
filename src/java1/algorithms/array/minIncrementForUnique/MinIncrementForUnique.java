package minIncrementForUnique;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinIncrementForUnique {
    //Sorting + greedy solution TC: O(n log n) SC: O(1)
    private int minIncrementForUnique1(int[] nums) {
        Arrays.sort(nums);

        int moves = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                moves += 1 + nums[i-1] - nums[i];
                nums[i] = nums[i-1] + 1;
            }
        }

        return moves;
    }
    //Counting/Bucket solution(frequency propagation) TC: O(n + R) SC: O(R) R=max + n
    private int minIncrementForUnique2(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int max = 0;

        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
            max = Math.max(max, num);
        }

        int moves = 0;
        //frequency propagation
        for(int i=0; i<nums.length+max; i++) {
            int freq = freqMap.getOrDefault(i, 0);
            if(freq > 1) {
                int extra = freq - 1;
                freqMap.put(i+1, freqMap.getOrDefault(i+1, 0) + extra);
                moves += extra;
            }
        }

        return moves;
    }
    public static void main(String[] args) {
        MinIncrementForUnique sol = new MinIncrementForUnique();
        int[][] tests = {
            {1,2,2}, // 1
            {3,2,1,2,1,7}, // 6
            {0,2,2,2,3,7}, // 5
            {1,1,1,1}, // 6
            {0,0,0,0,0}, // 10
            {1,2,3}, // 0
            {2,2,2,2,2,2,2}, // 21
            {100,100,100}, // 3
        };
        int[] expected = {1,6,5,6,10,0,21,3};
        for (int i = 0; i < tests.length; i++) {
            int[] input1 = java.util.Arrays.copyOf(tests[i], tests[i].length);
            int[] input2 = java.util.Arrays.copyOf(tests[i], tests[i].length);
            int result1 = sol.minIncrementForUnique1(input1);
            int result2 = sol.minIncrementForUnique2(input2);
            boolean pass = result1 == expected[i] && result2 == expected[i];
            System.out.printf("Test %d: Output1=%d, Output2=%d, Expected=%d [%s]\n", i+1, result1, result2, expected[i], pass ? "PASS" : "FAIL");
        }
    }
}
