package java1.algorithms.strings.slidingWindow.equalSubstringsWithInBudget;

public class EqualSubstringsWithInBudget {
    //Sliding window TC: O(n) SC: O(1)
    private static int equalSubstring(String s, String t, int maxCost) {
        int left = 0, cost = 0, maxLength = 0;

        for(int right = 0; right<s.length(); right++) {
            cost += Math.abs(s.charAt(right) - t.charAt(right));

            while(cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));

                left++;
            }

            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }
    public static void main(String[] args) {

        System.out.println(equalSubstring("abcd", "bcdf", 3));     // 3
        System.out.println(equalSubstring("abcd", "cdef", 3));     // 1
        System.out.println(equalSubstring("abcd", "acde", 0));     // 1
        System.out.println(equalSubstring("aaaa", "aaaa", 0));     // 4
        System.out.println(equalSubstring("abcd", "zzzz", 100));   // 4
        System.out.println(equalSubstring("abcd", "zzzz", 1));     // 0
        System.out.println(equalSubstring("a", "b", 1));           // 1
        System.out.println(equalSubstring("a", "c", 1));           // 0
        System.out.println(equalSubstring("", "", 5));             // 0
        System.out.println(equalSubstring("krrgw", "zjxss", 19));  // 2
        System.out.println(equalSubstring("abcdxyz", "abcfxyw", 2)); // 6
        System.out.println(equalSubstring("abcdef", "bcdefg", 6)); // 6
    }
}
