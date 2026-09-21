package java1.algorithms.array.rangeSumQueries.jellyBeans;

import java.util.Arrays;

public class JellyBeans {
    private static long[] jellyBeans(int n, int[][] operations) {
        long[] diff = new long[n+2];

        //process updates
        for(int[] operation: operations) {
            int left = operation[0];
            int right = operation[1];
            int beans = operation[2];

            diff[left] += beans;
            diff[right+1] -= beans;
        }

        //convert diff array to final values
        long[] result = new long[n];
        int current = 0;

        for(int i=1; i<=n; i++) {
            current += diff[i];
            result[i-1] = current;
        }

        return result;
    }
    public static void main(String[] args) {

        int n = 5;

        int[][] operations = {
            {1, 3, 10},
            {2, 5, 5},
            {3, 4, 2}
        };

        long[] result = jellyBeans(n, operations);

        System.out.println(Arrays.toString(result));
    }
}
