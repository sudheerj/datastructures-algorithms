package java1.algorithms.dynamicProgramming.maxEnergyDungeon;

public class MaxEnergyDungeon {
    //1D dynamic programming iterating from right to left TC: O(n) SC: O(n)
    private static int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];

        int maxEnergy = Integer.MIN_VALUE;

        for(int i=n-1; i>=0; i--) {
            dp[i] = energy[i];

            if(i+k < n) {
                dp[i] += dp[i+k];
            }

            maxEnergy = Math.max(maxEnergy, dp[i]);
        }

        return maxEnergy;
    }

    //In-place dynamic programming TC: O(n) SC: O(1)
    private static int maximumEnergyInPlace(int[] energy, int k) {
        int n = energy.length;
        int maxEnergy = Integer.MIN_VALUE;

        for(int i=n-1; i>=0; i--) {
            if(i+k < n) {
                energy[i] += energy[i+k];
            }

            maxEnergy = Math.max(maxEnergy, energy[i]);
        }

        return maxEnergy;
    }

    public static void main(String[] args) {

        System.out.println(maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3));     // 3
        System.out.println(maximumEnergy(new int[]{-2, -3, -1}, 2));           // -1
        System.out.println(maximumEnergy(new int[]{1, 2, 3, 4, 5}, 2));        // 9
        System.out.println(maximumEnergy(new int[]{10}, 1));                   // 10
        System.out.println(maximumEnergy(new int[]{3, -2, 5, -1, 4}, 2));      // 12
        System.out.println(maximumEnergy(new int[]{-5, -2, -8, -1}, 1));       // -1

        System.out.println(maximumEnergyInPlace(new int[]{5, 2, -10, -5, 1}, 3));     // 3
        System.out.println(maximumEnergyInPlace(new int[]{-2, -3, -1}, 2));           // -1
        System.out.println(maximumEnergyInPlace(new int[]{1, 2, 3, 4, 5}, 2));        // 9
        System.out.println(maximumEnergyInPlace(new int[]{10}, 1));                   // 10
        System.out.println(maximumEnergyInPlace(new int[]{3, -2, 5, -1, 4}, 2));      // 12
        System.out.println(maximumEnergyInPlace(new int[]{-5, -2, -8, -1}, 1)); // -1
    }
}
