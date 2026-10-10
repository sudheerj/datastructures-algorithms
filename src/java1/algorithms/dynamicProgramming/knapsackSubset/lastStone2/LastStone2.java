package java1.algorithms.dynamicProgramming.knapsackSubset.lastStone2;

public class LastStone2 {
    private static int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int stone : stones) {
            total += stone;
        }

        int target = total / 2;

        int[] dp = new int[target + 1];

        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }

        return total - 2 * dp[target];
    }

    public static void main(String[] args) {

        System.out.println(lastStoneWeightII(new int[] { 2, 7, 4, 1, 8, 1 })); // 1

        System.out.println(lastStoneWeightII(new int[] { 31, 26, 33, 21, 40 })); // 5

        System.out.println(lastStoneWeightII(new int[] { 1, 2 })); // 1

        System.out.println(lastStoneWeightII(new int[] { 1, 1 })); // 0

        System.out.println(lastStoneWeightII(new int[] { 5 })); // 5

        System.out.println(lastStoneWeightII(new int[] { 1, 2, 3, 4, 5 })); // 1
    }
}
