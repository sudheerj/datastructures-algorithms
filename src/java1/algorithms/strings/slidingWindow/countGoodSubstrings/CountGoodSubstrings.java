package java1.algorithms.strings.slidingWindow.countGoodSubstrings;

public class CountGoodSubstrings {
    //Fixed-size sliding window TC: O(n) SC: O(1)
    private static int countGoodSubstrings(String s) {
        int count = 0;

        for(int i=0; i<s.length()-2; i++) {
            int first = s.charAt(i);
            int second = s.charAt(i+1);
            int third = s.charAt(i+2);

            if(first != second && second != third && third != first) {
                count++;
            }
        }

        return count;
    } 

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));   // 1
        System.out.println(countGoodSubstrings("aababcabc")); // 4
        System.out.println(countGoodSubstrings("abc"));       // 1
        System.out.println(countGoodSubstrings("aaa"));       // 0
        System.out.println(countGoodSubstrings("abcdef"));    // 4
    }
}
