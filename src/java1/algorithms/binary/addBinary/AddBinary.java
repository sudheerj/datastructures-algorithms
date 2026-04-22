package java1.algorithms.binary.addBinary;

public class AddBinary {
    public static void main(String[] args) {
        String[][] testCases = {
                { "11", "1", "100" },
                { "1010", "1011", "10101" },
                { "0", "0", "0" },
                { "1", "0", "1" },
                { "111", "111", "1110" },
                { "", "1", "1" },
                { "1", "", "1" },
                { "", "", "" }
        };
        for (int i = 0; i < testCases.length; i++) {
            String a = testCases[i][0];
            String b = testCases[i][1];
            String expected = testCases[i][2];
            String result = addBinary(a, b);
            System.out.printf("Test %d: addBinary('%s', '%s') = '%s' | Expected: '%s' | %s\n",
                    i + 1, a, b, result, expected, result.equals(expected) ? "PASS" : "FAIL");
        }
    }

    private static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int currTotal = carry;

            if (i >= 0)
                currTotal += a.charAt(i--) - '0';
            if (j >= 0)
                currTotal += b.charAt(j--) - '0';

            result.append(currTotal % 2);
            carry = currTotal / 2;
        }
        return result.reverse().toString();
    }
}
