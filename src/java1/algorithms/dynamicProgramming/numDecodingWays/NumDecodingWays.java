package java1.algorithms.dynamicProgramming.numDecodingWays;

public class NumDecodingWays {
    // TC:O(n) SC:O(1)
    private static int numDecodingWays1(String str) {
        if((str.length() == 0) || (str.charAt(0) == '0')) return 0;

        if(str.length() == 1) return 1;

        int prevCount1 = 1, prevCount2 = 1;

        for(int i=2; i<=str.length(); i++) {
            int oneDigit = Integer.valueOf(str.substring(i-1, i));
            int twoDigit = Integer.valueOf(str.substring(i-2, i));
            int count = 0;

            if(oneDigit >=1) {
                count += prevCount2;
            }
            if(twoDigit >=10 && twoDigit <=26) {
                count += prevCount1;
            }
            prevCount1 = prevCount2;
            prevCount2 = count;

        }
        return prevCount2;
    }

    // TC:O(n) SC:O(n)
    private static int numDecodingWays2(String str) {
        if((str.length() == 0) || str.charAt(0) == '0') return 0;
        int[] dp = new int[str.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=str.length(); i++) {
            int oneDigit = Integer.valueOf(str.substring(i-1, i));
            int twoDigit = Integer.valueOf(str.substring(i-2, i));

            if(oneDigit >=1) {
                dp[i] += dp[i-1];
            }
            if(10 <= twoDigit && twoDigit <=26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[str.length()];
    }

    public static void main(String[] args) {
        String str1 = "221";
        String str2 = "06";
        System.out.println(numDecodingWays1(str1));
        System.out.println(numDecodingWays1(str2));
        System.out.println(numDecodingWays2(str1));
        System.out.println(numDecodingWays2(str2));
    }
}
