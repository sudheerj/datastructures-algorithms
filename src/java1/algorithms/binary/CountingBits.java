// Dynamic programming pattern:- TC:O(n) SC:O(n)
package java1.algorithms.binary;

import java.util.Arrays;

public class CountingBits {
    private static int[] countingBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        int offset = 1;
        for(int i=1; i< n+1; i++) {
            if(offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1+ dp[i-offset];
        }
        return dp;
    }

    public static void main(String[] args) {
        int num = 3;
        System.err.println(Arrays.toString(countingBits(num)));
    }
}
