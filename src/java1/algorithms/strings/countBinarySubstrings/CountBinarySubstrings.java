package java1.algorithms.strings.countBinarySubstrings;

public class CountBinarySubstrings {
    private static int countBinarySubstrings(String str) {
        int prev = 0; //previous group length
        int curr = 1; //current group length
        int i = 1;
        int count = 0;

        while(i < str.length()) {
            if(str.charAt(i) == str.charAt(i-1)) { // extend the current group
                curr++;
            } else { //start a new group
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
            i++;
        }

        count += Math.min(prev, curr);
        return count;
    }

    public static void main(String[] args) {
        // "00110011" -> 6
        System.out.println(countBinarySubstrings("00110011") + " (expected 6)");
        // "10101" -> 4
        System.out.println(countBinarySubstrings("10101") + " (expected 4)");
        // "00011" -> 2
        System.out.println(countBinarySubstrings("00011") + " (expected 2)");
        // "0" -> 0
        System.out.println(countBinarySubstrings("0") + " (expected 0)");
        // "01" -> 1
        System.out.println(countBinarySubstrings("01") + " (expected 1)");
        // "000111" -> 3
        System.out.println(countBinarySubstrings("000111") + " (expected 3)");
    }

}
