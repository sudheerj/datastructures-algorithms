
/*
 * Roman to Integer
 *
 * Time Complexity: O(n), where n is the length of the input string.
 * Space Complexity: O(1), since the map size is constant and only a few variables are used.
 */
package java1.algorithms.misc.romanToInteger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        // Example test cases
        String[] tests = {"III", "IV", "IX", "LVIII", "MCMXCIV", "XL", "XC", "CD", "CM"};
        int[] expected = {3, 4, 9, 58, 1994, 40, 90, 400, 900};
        for (int i = 0; i < tests.length; i++) {
            int result = romanToInteger(tests[i]);
            System.out.println("romanToInteger('" + tests[i] + "') = " + result + " | Expected: " + expected[i]);
        }
    }

    private static int romanToInteger(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 2);
        map.put('X', 3);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for(int i=0; i<str.length(); i++) {
            int current = map.get(str.charAt(i));

            if(i<str.length()-1 && current < map.get(str.charAt(i +1))){
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}
