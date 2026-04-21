package java1.algorithms.misc.integerToRoman;

public class IntegerToRoman {
    public static void main(String[] args) {
        // Example test cases
        int[] tests = { 3, 4, 9, 58, 1994, 40, 90, 400, 900 };
        String[] expected = { "III", "IV", "IX", "LVIII", "MCMXCIV", "XL", "XC", "CD", "CM" };
        for (int i = 0; i < tests.length; i++) {
            String result = integerToRoman(tests[i]);
            System.out.println("integerToRoman(" + tests[i] + ") = '" + result + "' | Expected: '" + expected[i] + "'");
        }
    }

    private static String integerToRoman(int number) {
        String[][] symbolList = {
                { "I", "1" }, { "V", "5" }, { "X", "10" }, { "L", "50" }, { "C", "100" }, { "D", "500" },
                { "M", "1000" }
        };

        StringBuilder sb = new StringBuilder();

        for (int i = symbolList.length - 1; i >= 0; i--) {
            String sym = symbolList[i][0];
            int val = Integer.parseInt(symbolList[i][1]);

            int count = number / val;
            if (count > 0) {
                sb.append(sym.repeat(count));
                number = number % count;
            }
        }

        return sb.toString();
    }
}
