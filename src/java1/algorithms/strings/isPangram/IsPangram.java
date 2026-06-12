package java1.algorithms.strings.isPangram;

import java.util.HashSet;
import java.util.Set;

public class IsPangram {
    //Boolean array presence checking TC: O(n) SC: O(26) ~= O(1) 
    private boolean checkIfPangram1(String sentence) {
        boolean[] seen = new boolean[26];

        for(char ch: sentence.toCharArray()) {
            seen[ch -'a'] = true;
        }

        for(boolean isPresent: seen) {
            if(!isPresent) {
                return false;
            }
        }

        return true;
    }
    
    //Bit masking TC: O(n) SC: O(1)
    private boolean checkIfPangram2(String sentence) {
        int mask = 0;
        for(char ch: sentence.toCharArray()) {
            mask |= (1 << ch -'a');
        }

        return mask == (1 << 26) -1; //25 1's in binary format
    }

    //HashSet TC: O(n) SC: O(26) ~= O(1)
    private boolean checkIfPangram3(String sentence) {
        Set<Character> set = new HashSet<>();

        for(char ch='a'; ch < 'z'; ch++) {
            set.add(ch);
        }

        for(char ch: sentence.toCharArray()) {
            set.remove(ch);

            if(set.isEmpty()) {
                return true;
            }
        }

        return false;
    }
    // Public method for test harness
    public static String isPangram(String s) {
        boolean[] seen = new boolean[26];
        s = s.toLowerCase();
        for (char ch : s.toCharArray()) {
            if ('a' <= ch && ch <= 'z') {
                seen[ch - 'a'] = true;
            }
        }
        for (boolean b : seen) {
            if (!b) return "not pangram";
        }
        return "pangram";
    }

    public static void main(String[] args) {
        String[][] testCases = {
            {"abcdefghijklmnopqrstuvwxyz", "pangram"},
            {"abcdefghijklmnopqrstuvwxy", "not pangram"},
            {"Abcdefghijklmnopqrstuvwxyz", "pangram"},
            {"A quick brown fox", "not pangram"},
            {"Mr. Jock, TV quiz PhD, bags few lynx.", "pangram"},
            {"Waltz, nymph, for quick jigs vex Bud.", "pangram"},
            {"John Doe", "not pangram"},
            {"Pack my box with five dozen liquor jugs.", "pangram"}
        };
        IsPangram obj = new IsPangram();
        for (String[] test : testCases) {
            String input = test[0];
            String expected = test[1];

            // checkIfPangram1
            boolean res1 = false;
            try {
                res1 = obj.checkIfPangram1(input.toLowerCase().replaceAll("[^a-z]", ""));
            } catch (Exception e) { }
            String out1 = res1 ? "pangram" : "not pangram";
            String status1 = out1.equals(expected) ? "PASS" : "FAIL";
            System.out.printf("checkIfPangram1: Input: \"%s\" | Output: \"%s\" | Expected: \"%s\" | %s\n", input, out1, expected, status1);

            // checkIfPangram2
            boolean res2 = false;
            try {
                res2 = obj.checkIfPangram2(input.toLowerCase().replaceAll("[^a-z]", ""));
            } catch (Exception e) { }
            String out2 = res2 ? "pangram" : "not pangram";
            String status2 = out2.equals(expected) ? "PASS" : "FAIL";
            System.out.printf("checkIfPangram2: Input: \"%s\" | Output: \"%s\" | Expected: \"%s\" | %s\n", input, out2, expected, status2);

            // checkIfPangram3
            boolean res3 = false;
            try {
                res3 = obj.checkIfPangram3(input.toLowerCase().replaceAll("[^a-z]", ""));
            } catch (Exception e) { }
            String out3 = res3 ? "pangram" : "not pangram";
            String status3 = out3.equals(expected) ? "PASS" : "FAIL";
            System.out.printf("checkIfPangram3: Input: \"%s\" | Output: \"%s\" | Expected: \"%s\" | %s\n", input, out3, expected, status3);

            // isPangram static
            String result = isPangram(input);
            String status = result.equals(expected) ? "PASS" : "FAIL";
            System.out.printf("isPangram:      Input: \"%s\" | Output: \"%s\" | Expected: \"%s\" | %s\n", input, result, expected, status);
        }
    }
}
