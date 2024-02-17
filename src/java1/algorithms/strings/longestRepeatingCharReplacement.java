//Sliding window: TC:O(n) SC: O(1)
package java1.algorithms.strings;

public class LongestRepeatingCharReplacement {
    private static int longestCharReplacement(String str, int target) {
        int[] charCount = new int[26];
        int maxLength = 0;
        int maxCharFrequency = 0;
        int left =0;

        for(int right = 0; right < str.length(); right++) {
            maxCharFrequency = Math.max(maxCharFrequency, ++charCount[str.charAt(right) - 'A']);
            while((right - left + 1 - maxCharFrequency) > target) {
                charCount[str.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "AAABABBAA";
        System.out.println(longestCharReplacement(str, 2));
    }
}
