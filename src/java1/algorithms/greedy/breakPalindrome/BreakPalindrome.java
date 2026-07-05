package java1.algorithms.greedy.breakPalindrome;

public class BreakPalindrome {
    //Greedy + lexiographical optimization TC: O(n/2) ~= O(n) SC: O(n)
    private static String breakPalindrome(String palindrome) {
        int n = palindrome.length();

        //if string has only one character, its impossible to breakPalindrome
        if(n == 1) {
            return "";
        }

        char[] chars = palindrome.toCharArray();
        //check only the first half
        for(int i=0; i<n/2; i++) {
            if(chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }

        //if all characters of palindrome are 'a'
        chars[n-1] = 'b';

        return new String(chars);
    }

    public static void main(String[] args) {
        String[] testCases = {
            "abccba",
            "a",
            "aa",
            "aba",
            "abba",
            "aaa",
            "aaaa",
            "zzzz",
            "racecar",
            "aabaa"
        };

        for (String test : testCases) {
            System.out.println("Input : " + test);
            System.out.println("Output: " + breakPalindrome(test));
            System.out.println("-------------------------");
        }
    }
}
