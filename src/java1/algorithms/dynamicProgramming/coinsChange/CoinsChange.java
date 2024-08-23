package java1.algorithms.dynamicProgramming.coinsChange;
import java.util.*;

public class CoinsChange {
    // TC: O(amount * numberOfCoins) SC: O(amount)
    private static int coinsChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        for(int i=1; i<=amount; i++) {
            for(int coin: coins) {
                if(i-coin >=0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }
            }
        }
        return dp[amount] == amount +1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 3, 4, 5};
        int amount1 = 7;
        int[] coins2 = {2, 4};
        int amount2 = 3;
        System.out.println(coinsChange(coins1, amount1));
        System.out.println(coinsChange(coins2, amount2));
    }
}
