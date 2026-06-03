package java1.algorithms.dynamicProgramming.longestIncreasingSequence.russianDollEnvelopes;

import java.util.Arrays;

public class RussianDollEnvelopes {

    //Sorting + LIS with binary search TC: O(n log n) SC: O(n)
    private int maxEnvelopes(int[][] envelopes) {
        //Sort by width in ASC, if tie sort height in DESC
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) return b[1] -a[1];

            return a[0] - b[0];
        });

        //LIS on heights
        int[] lis = new int[envelopes.length];
        int size = 0;

        for(int[] env: envelopes) {
            int h = env[1];

            int left = 0, right = size;

            while(left < right) {
                int mid = left + (right-left)/2;

                if(lis[mid] < h) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            lis[left] = h;

            if(left == size) {
                size++;
            }

        }

        return size;
    }

    public static void main(String[] args) {
            RussianDollEnvelopes solver = new RussianDollEnvelopes();
            int[][][] testEnvelopes = {
                {{5,4},{6,4},{6,7},{2,3}},
                {{1,1},{1,1},{1,1}},
                {{4,5},{4,6},{6,7},{2,3},{1,1}},
                {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}},
                {{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}}
            };
            int[] expected = {3, 1, 4, 5, 3};
            for (int i = 0; i < testEnvelopes.length; i++) {
                int result = solver.maxEnvelopes(testEnvelopes[i]);
                String status = result == expected[i] ? "PASS" : "FAIL";
                System.out.printf("Test %d | Output: %d | Expected: %d | %s\n", i+1, result, expected[i], status);
            }
    }
}
