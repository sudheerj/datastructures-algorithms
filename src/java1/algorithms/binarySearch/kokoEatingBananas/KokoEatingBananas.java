package java1.algorithms.binarySearch.kokoEatingBananas;

public class KokoEatingBananas {
    // Binary search TC: O(n * log(maxPile)) SC: O(1)
    public static int minEatingSpeedBinarySearch(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) right = Math.max(right, pile);
        int minSpeed = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int pile : piles) hours += Math.ceil((double)pile / mid);
            if (hours <= h) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }

    // BruteForce TC: O(n * maxPile)  SC: O(1)
    public static int minEatingSpeedBruteForce(int[] piles, int h) {
        int right = 0;
        for (int pile : piles) right = Math.max(right, pile);
        for (int k = 1; k <= right; k++) {
            int hours = 0;
            for (int pile : piles) hours += Math.ceil((double)pile / k);
            if (hours <= h) return k;
        }
        return right;
    }

    // Inline test harness
    public static void main(String[] args) {
        int[][] testPiles = {
            {3, 6, 7, 11},
            {30, 11, 23, 4, 20},
            {30, 11, 23, 4, 20}
        };
        int[] testH = {8, 5, 6};
        int[] expected = {4, 30, 23};

        System.out.println("Testing KokoEatingBananas (Binary Search):");
        for (int i = 0; i < testPiles.length; i++) {
            int res = minEatingSpeedBinarySearch(testPiles[i], testH[i]);
            System.out.println((res == expected[i] ? "PASS" : "FAIL") + " Test " + (i+1) + ": got " + res + ", expected " + expected[i]);
        }

        System.out.println("\nTesting KokoEatingBananas (Brute Force):");
        for (int i = 0; i < testPiles.length; i++) {
            int res = minEatingSpeedBruteForce(testPiles[i], testH[i]);
            System.out.println((res == expected[i] ? "PASS" : "FAIL") + " Test " + (i+1) + ": got " + res + ", expected " + expected[i]);
        }
    }
}
