package java1.algorithms.strings.betterStringCompression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BetterStringCompression {
    //Character frequency with order list TC: O(n) SC: O(k) k= number of unique characters
    private String betterCompression(String compressed) {
        Map<Character, Integer> freqMap = new HashMap<>();
        List<Character> order = new ArrayList<>();

        int i = 0;
        int n = compressed.length();

        while(i<n) {
            char ch = compressed.charAt(i);
            i++;

            int num = 0;
            while(i < n && Character.isDigit(compressed.charAt(i))) {
                num = num * 10 + (compressed.charAt(i)-'0');
                i++;
            }

            if(!freqMap.containsKey(ch)) {
                freqMap.put(ch, num);
                order.add(ch);
            } else {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0)+num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch: order) {
            sb.append(ch).append(freqMap.get(ch));
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        BetterStringCompression obj = new BetterStringCompression();
        String[][] testCases = {
            {"a3b2c1", "a3b2c1"},
            {"a12b56c1a2", "a14b56c1"},
            {"x1y2z3x4", "x5y2z3"},
            {"a1b1c1d1e1f1", "a1b1c1d1e1f1"},
            {"a10b10a10", "a20b10"},
            {"a1b2c3d4e5f6g7h8i9j10", "a1b2c3d4e5f6g7h8i9j10"},
            {"a1a1a1a1", "a4"},
            {"m5n10m5n10", "m10n20"}
        };
        for (String[] test : testCases) {
            String input = test[0];
            String expected = test[1];
            String result = obj.betterCompression(input);
            String status = result.equals(expected) ? "PASS" : "FAIL";
            System.out.printf("Input: \"%s\" | Output: \"%s\" | Expected: \"%s\" | %s\n", input, result, expected, status);
        }
    }
}
