package java1.algorithms.misc.multiplyStrings;

public class MultiplyStrings {
    private String multiplyStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] res = new int[m + n];
        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                int digit = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                res[i + j] += digit;
                res[i + j + 1] += res[i + j] / 10;
                res[i + j] = res[i + j] % 10;
            }
        }

        StringBuilder result = new StringBuilder();
        int i = res.length - 1;
        while (i >= 0 && res[i] == 0) {
            i--;
        }
        while (i >= 0) {
            result.append(res[i--]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        String[][] testCases = {
            {"2", "3"},         // 6
            {"123", "456"},     // 56088
            {"0", "12345"},     // 0
            {"999", "999"},     // 998001
            {"123456789", "987654321"} // 121932631112635269
        };
        for (int i = 0; i < testCases.length; i++) {
            String num1 = testCases[i][0], num2 = testCases[i][1];
            System.out.println("Test case " + (i + 1) + ": num1 = '" + num1 + "', num2 = '" + num2 + "'");
            String result = ms.multiplyStrings(num1, num2);
            System.out.println("Output: " + result);
        }
    }
}
