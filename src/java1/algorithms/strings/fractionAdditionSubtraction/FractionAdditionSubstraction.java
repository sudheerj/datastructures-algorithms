package java1.algorithms.strings.fractionAdditionSubtraction;

public class FractionAdditionSubstraction {
    // String parsing and simulation TC: O(n) SC: O(1)
    public static String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;
        int i = 0;
        int n = expression.length();

        while (i < n) {
            // Read sign
            int sign = 1;

            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                if (expression.charAt(i) == '-') {
                    sign *= -1;
                }
                i++;
            }

            // Read numerator
            int num = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + expression.charAt(i) - '0';
                i++;
            }

            num *= sign;

            // skip '/'
            i++;

            // Read denominator
            int den = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                den = den * 10 + expression.charAt(i) - '0';
                i++;
            }

            // Add fraction numerator/denominator + num/den
            numerator = numerator * den + num * denominator;
            denominator = denominator * den;

            // Reduce fraction
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return numerator + "/" + denominator;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Object[][] tests = {
                { "-1/2+1/2", "0/1" },
                { "-1/2+1/2+1/3", "1/3" },
                { "1/3-1/2", "-1/6" },
                { "5/3+1/3", "2/1" },
                { "-3/2+3/2", "0/1" },
                { "1/4+1/4", "1/2" },
        };

        for (Object[] test : tests) {
            String expression = (String) test[0];
            String expected = (String) test[1];
            String result = fractionAddition(expression);
            String status = result.equals(expected) ? "PASS" : "FAIL";
            System.out.println(
                    "[" + status + "] expression=\"" + expression + "\" result=" + result + " expected=" + expected);
        }
    }
}
