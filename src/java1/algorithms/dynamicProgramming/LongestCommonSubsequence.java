//Two dimensional DP bottom-up:- TC:O(m * n) SC:O(m* n)
package java1.algorithms.dynamicProgramming;

public class LongestCommonSubsequence {
    private static int lengthOfLCS(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i= text1.length()-1; i>=0; i--) {
            for(int j= text2.length()-1; j>=0; j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String text1 = "abcdef", text2 = "acbefd", text3 = "abc", text4 = "def";
        System.out.println(lengthOfLCS(text1, text2));
        System.out.println(lengthOfLCS(text3, text4));
    }
}
