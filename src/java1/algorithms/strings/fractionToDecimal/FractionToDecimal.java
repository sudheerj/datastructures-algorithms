package java1.algorithms.strings.fractionToDecimal;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    //Cycle detection TC: O(n) SC: O(n); n = number of unique remainders
    private static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        //sign handling
        if((numerator < 0) ^ (denominator <0)){
            result.append("-");
        }

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        //integer part
        result.append(num/den);
        long remainder = num%den;

        if(remainder == 0) return result.toString();

        result.append(".");

        //Store remainder and its position
        Map<Long, Integer> seen = new HashMap<>();

        while(remainder > 0) {

            //if remainder repeating -> start adding remainder
            if(seen.containsKey(remainder)) {
                int index = seen.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            //Store remainder -> position
            seen.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder/den);
            remainder %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] inputs = {
            {1, 2},
            {2, 1},
            {4, 333},
            {1, 3},
            {-1, -2},
        };
        String[] expected = {"0.5", "2", "0.(012)", "0.(3)", "0.5"};

        for (int i = 0; i < inputs.length; i++) {
            String result = fractionToDecimal(inputs[i][0], inputs[i][1]);
            String status = result.equals(expected[i]) ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected[i]);
        }
    }
}
