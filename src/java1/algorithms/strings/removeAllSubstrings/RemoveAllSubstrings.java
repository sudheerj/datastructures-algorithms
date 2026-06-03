package java1.algorithms.strings.removeAllSubstrings;

public class RemoveAllSubstrings {
    // StringBuffer with suffix match TC: O(n * m) SC: O(n)
    private String removeOccurances(String s, String part) {
        StringBuilder result = new StringBuilder();
        int m = part.length();

        for (char ch : s.toCharArray()) {
            result.append(ch);
            if (result.length() >= m) {
                boolean match = true;
                for (int i = 0; i < m; i++) {
                    if (result.charAt(result.length() - m + i) != part.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.delete(result.length() - m, result.length());
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        RemoveAllSubstrings solver = new RemoveAllSubstrings();
        String[][] tests = {
            {"daabcbaabcbc", "abc"},
            {"axxxxyyyyb", "xy"},
            {"aabababa", "aba"},
            {"aaaaa", "aa"},
            {"abcabcabc", "abc"},
            {"", "a"},
            {"abc", "d"}
        };
        String[] expected = {"dab", "ab", "ba", "a", "", "", "abc"};
        for (int i = 0; i < tests.length; i++) {
            String result = solver.removeOccurances(tests[i][0], tests[i][1]);
            String status = result.equals(expected[i]) ? "PASS" : "FAIL";
            System.out.printf("Test %d | Output: %s | Expected: %s | %s\n", i+1, result, expected[i], status);
        }
    }
}
