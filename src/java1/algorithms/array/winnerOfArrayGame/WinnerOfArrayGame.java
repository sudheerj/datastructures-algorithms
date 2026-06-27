package winnerOfArrayGame;

import java.util.Arrays;

public class WinnerOfArrayGame {
    //Simulation + Running maximum TC: O(n) SC: O(1)
    private static int getWinner(int[] arr, int k) {
        int winner = arr[0];
        int winnerCount = 0;

        for(int i=1; i<arr.length; i++) {
            if(winner > arr[i]) {
                winnerCount++;
            } else {
                winner = arr[i];
                winnerCount = 1;
            }

            if(winnerCount == k) {
                return winner;
            }
        }

        return winner;
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 1, 3, 5, 4, 6, 7};
        int k1 = 2;
        System.out.println(Arrays.toString(arr1) + ", k = " + k1 +
                " -> Winner = " + getWinner(arr1, k1));

        int[] arr2 = {3, 2, 1};
        int k2 = 10;
        System.out.println(Arrays.toString(arr2) + ", k = " + k2 +
                " -> Winner = " + getWinner(arr2, k2));

        int[] arr3 = {1, 25, 35, 42, 68, 70};
        int k3 = 1;
        System.out.println(Arrays.toString(arr3) + ", k = " + k3 +
                " -> Winner = " + getWinner(arr3, k3));

        int[] arr4 = {1, 11, 22, 33, 44, 55, 66};
        int k4 = 3;
        System.out.println(Arrays.toString(arr4) + ", k = " + k4 +
                " -> Winner = " + getWinner(arr4, k4));

        int[] arr5 = {5, 1, 2, 3, 4};
        int k5 = 4;
        System.out.println(Arrays.toString(arr5) + ", k = " + k5 +
                " -> Winner = " + getWinner(arr5, k5));

        int[] arr6 = {7, 6, 5, 4, 3, 2, 1};
        int k6 = 3;
        System.out.println(Arrays.toString(arr6) + ", k = " + k6 +
                " -> Winner = " + getWinner(arr6, k6));

        int[] arr7 = {1, 9, 8, 2, 3, 7, 6, 4, 5};
        int k7 = 7;
        System.out.println(Arrays.toString(arr7) + ", k = " + k7 +
                " -> Winner = " + getWinner(arr7, k7));

        int[] arr8 = {1, 3, 2};
        int k8 = 2;
        System.out.println(Arrays.toString(arr8) + ", k = " + k8 +
                " -> Winner = " + getWinner(arr8, k8));
    }

}
