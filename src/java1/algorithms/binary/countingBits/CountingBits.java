// Dynamic programming pattern:- TC:O(n) SC:O(n)
package java1.algorithms.binary.countingBits;

import java.util.Arrays;

public class CountingBits {
    private static int[] countingBits1(int n) {
        int[] ans = new int[n+1];
        int offset = 1;
        for(int i=1; i< n+1; i++) {
            if(offset * 2 == i) {
                offset = i;
            }
            ans[i] = 1+ ans[i-offset];
        }
        return ans;
    }

    private static int[] countingBits2(int n) {
        int[] ans = new int[n+1];
        for(int i=1; i< n+1; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 6;
        System.out.println(Arrays.toString(countingBits1(num1)));
        System.out.println(Arrays.toString(countingBits1(num2)));

        System.out.println(Arrays.toString(countingBits2(num1)));
        System.out.println(Arrays.toString(countingBits2(num2)));
    }
}
