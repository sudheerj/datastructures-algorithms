package java1.algorithms.strings.lastSubstring;

public class LastSubstring {
    //Two pointers:-String's character comparison TC:O(n) SC: O(1)
    private static String lastSubstring(String str) {
        int n = str.length();
        int i=0; //current best substring starting index
        int j=1; //challenger substring starting index
        int k=0; //offset comparisons character by character

        while(j+k < n) {
            //case 1: characters are equal -> keep checking next
            if(str.charAt(i+k) == str.charAt(j+k)) {
                k++;
            } else if(str.charAt(i+k) < str.charAt(j+k)) { //case2: challenger is better -> update best 
                i = Math.max(i+k+1, j);
                j= i+1;
                k=0;
            } else { //case3: current best is better -> skip challenger range
                j=j+k+1;
                k=0;
            }
        }

        //largest substring
        return str.substring(i);
    }

    public static void main(String[] args) {
        Object[][] tests = {
            {"abab",    "bab"},
            {"leetcode","tcode"},
            {"cacacb",  "cb"},
            {"zz",      "zz"},
            {"abcde",   "e"},
        };

        for (Object[] t : tests) {
            String input    = (String) t[0];
            String expected = (String) t[1];
            String result   = lastSubstring(input);
            String status   = result.equals(expected) ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }
    }
}
