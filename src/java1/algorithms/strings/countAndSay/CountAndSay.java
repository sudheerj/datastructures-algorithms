package java1.algorithms.strings.countAndSay;

public class CountAndSay {
    public static void main(String[] args) {
        int[] testN = { 1, 2, 3, 4, 5, 6 };
        String[] expected = { "1", "11", "21", "1211", "111221", "312211" };

        for (int i = 0; i < testN.length; i++) {
            String result = countAndSay("", testN[i]);
            System.out.println("n=" + testN[i] + " => \"" + result + "\""
                    + (result.equals(expected[i]) ? " ✓" : " ✗ (expected \"" + expected[i] + "\")"));
        }
    }

    private static String countAndSay(String str, int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count).append(result.charAt(result.length() - 1));
            result = sb.toString();
        }

        return result;
    }
}
