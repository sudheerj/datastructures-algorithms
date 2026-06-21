package java1.algorithms.strings.slidingWindow.replaceSubstringForBalancedString;

public class ReplaceSubstringForBalancedString {
    //Variable-size sliding window TC: O(n) SC: O(1)
    //Key logic: Find the min substring window to be replaced to make outside window valid.
    private static int balancedString(String s) {
        int n = s.length();
        int target = n/4;

        int[] count = new int[128];

        //count full string
        for(char ch: s.toCharArray()) {
            count[ch]++;
        }

        int left = 0, minLength = n;

        for(int right=0; right<n; right++) {
            count[s.charAt(right)]--;

            while(left <= right && count['Q'] <= target && count['W'] <= target && count['E'] <= target && count['R'] <=target) {
                minLength = Math.min(minLength, right-left+1);
                count[s.charAt(left)]++;
                left++;
            }

        }

        return minLength;
    }

    public static void main(String[] args) {

        String[] tests = {
            "QWER",
            "QQWE",
            "QQQW",
            "QQQQ",
            "WQWRQQQW",
            "QWQWQWQW",
            "QWERQWER",
            "QQQWWWEERR",
            "WWQQRRQQEE",
            "QWEEQQRRWWQWER"
        };

        for (String s : tests) {
            System.out.println("Input : " + s);
            System.out.println("Output: " + balancedString(s));
            System.out.println("----------------------");
        }
    }
}
