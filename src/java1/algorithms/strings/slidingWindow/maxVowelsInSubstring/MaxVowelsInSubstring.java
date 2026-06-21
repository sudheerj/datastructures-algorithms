package java1.algorithms.strings.slidingWindow.maxVowelsInSubstring;

public class MaxVowelsInSubstring {
    //Fixed-size sliding window TC:O(n) SC: O(1)
    private static int maxVowels(String s, int k) {
        int count = 0, maxVowels = 0;

        //first window
        for(int i=0; i<k; i++) {
            if(isVowel(s.charAt(i))) {
                count++;
            }
        }

        maxVowels = Math.max(maxVowels, count);

        //sliding window
        for(int i=k; i<s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                count++;
            }

            if(isVowel(s.charAt(i-k))) {
                count--;
            }

            maxVowels = Math.max(maxVowels, count);
        }

        return maxVowels;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));   // 3
        System.out.println(maxVowels("aeiou", 2));       // 2
        System.out.println(maxVowels("leetcode", 3));    // 2
        System.out.println(maxVowels("rhythms", 4));     // 0
        System.out.println(maxVowels("tryhard", 4));     // 1
    }
}
