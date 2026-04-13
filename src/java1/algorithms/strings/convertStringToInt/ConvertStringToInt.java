package java1.algorithms.strings.convertStringToInt;

public class ConvertStringToInt {
    public static void main(String[] args) {
        String[] testCases = {"42", "   -42", "4193 with words", "", "   ", "+1", "words and 987", "-91283472332", "91283472332", "  0012a42"};
        int[] expected     = {42,   -42,      4193,              0,  0,     1,    0,               -2147483648,    2147483647,    12};

        for (int i = 0; i < testCases.length; i++) {
            int result = myAtoi(testCases[i]);
            System.out.println("\"" + testCases[i] + "\" => " + result + (result == expected[i] ? " ✓" : " ✗ (expected " + expected[i] + ")"));
        }
    }

    private static int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int i = 0, n = str.length();

        //Skip any spaces
        while(i<n && str.charAt(i) == ' ') i++;

        //Check signs
        int sign = 1;
        if(i<n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        //Convert digits
        long result = 0;
        while(i < n && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i) - '0');
            //Clamp early to avoid overflow
            if((result * sign) > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if((result * sign) < Integer.MIN_VALUE) return Integer.MIN_VALUE; 
            i++;
        }

        return (int)(result * sign);
    }
}
