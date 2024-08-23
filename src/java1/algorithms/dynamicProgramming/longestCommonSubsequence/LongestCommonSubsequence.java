//Two dimensional DP bottom-up:- TC:O(m * n) SC:O(m* n)
package java1.algorithms.dynamicProgramming.longestCommonSubsequence;

public class LongestCommonSubsequence {
    private static int lengthOfLCS(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i= str1.length()-1; i>=0; i--) {
            for(int j= str2.length()-1; j>=0; j--) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String str1 = "abcdef", str2 = "acbefd", str3 = "abcd", str4 = "efgh";
        System.out.println(lengthOfLCS(str1, str2));
        System.out.println(lengthOfLCS(str3, str4));
    }
}
