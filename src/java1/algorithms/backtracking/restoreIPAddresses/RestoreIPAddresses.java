package java1.algorithms.backtracking.restoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    private static List<String> restoreIPAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 12)
            return result;
        backtrack(0, 0, "", s, result);
        return result;
    }

    private static void backtrack(int i, int dots, String currIp, String s, List<String> result) {
        if (dots == 4 && i == s.length()) {
            result.add(currIp.substring(0, currIp.length() - 1));
            return;
        }

        if (dots > 4)
            return;
        for (int j = i; j < Math.min(i + 3, s.length()); j++) {
            if (i != j && s.charAt(i) == '0')
                continue;
            if (Integer.parseInt(s.substring(i, j + 1)) < 256) {
                backtrack(j + 1, dots + 1, currIp + s.substring(i, j + 1) + ".", s, result);
            }
        }
    }

    public static void main(String[] args) {
        String[] testCases = {
                "25525511135", // ["255.255.11.135", "255.255.111.35"]
                "0000", // ["0.0.0.0"]
                "101023", // ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
                "1111", // ["1.1.1.1"]
                "010010" // ["0.10.0.10","0.100.1.0"]
        };
        for (int i = 0; i < testCases.length; i++) {
            String s = testCases[i];
            System.out.println("Test case " + (i + 1) + ": Input: '" + s + "'");
            List<String> result = restoreIPAddresses(s);
            System.out.println("Output: " + result);
        }
    }
}
