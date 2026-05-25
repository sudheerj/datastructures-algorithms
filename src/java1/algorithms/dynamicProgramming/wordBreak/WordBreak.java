package java1.algorithms.dynamicProgramming.wordBreak;
import java.util.*;

//1D Bottom-up DP with reverse iteration => TC: O(n * m * k) SC:O(n) n=number of chars in string, m = number of words in dict, k=Avg word length
public class WordBreak {
    private static boolean wordBreak(String str, List<String> wordDict) {
            boolean[] dp = new boolean[str.length()+1];
            dp[str.length()] = true;
            for(int i = str.length()-1; i>=0; i--) {
                for(String word: wordDict) {
                    if((i+ word.length() <= str.length()) && str.startsWith(word, i)) {
                        if(dp[i+ word.length()]) {
                            dp[i] = dp[i+ word.length()];
                            break;
                        }
                    }
                }
            }
            return dp[0];
    }

    public static void main(String[] args) {
        String str1 = "applepenapple";
        List<String> wordDict1 = Arrays.asList("pen", "apple");
        String str2 = "catsandog";
        List<String> wordDict2 = Arrays.asList("cats", "dog", "and", "cat");
        System.out.println(wordBreak(str1, wordDict1));
        System.out.println(wordBreak(str2, wordDict2));
    }
}
