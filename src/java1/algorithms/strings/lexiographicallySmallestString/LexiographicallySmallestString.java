package java1.algorithms.strings.lexiographicallySmallestString;

public class LexiographicallySmallestString {
    // Greedy string segment transformation TC: O(n) SC: O(n)
    private String smallestString(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int i = 0;
        // skip leading 'a' letters
        while (i < n && arr[i] == 'a') {
            i++;
        }
        // if all characters are 'a', replace last char to 'z'
        if (i == n) {
            arr[n - 1] = 'z';
            return new String(arr);
        }
        // apply operation on first non-a segment
        while (i < n && arr[i] != 'a') {
            arr[i] = (char) (arr[i] - 1);
            i++;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        LexiographicallySmallestString solver = new LexiographicallySmallestString();
        String[][] tests = {
            {"abcde", "aabcd", "aabcd"},
            {"aabc", "aabc", "aaab"},
            {"aaaa", "aaaa", "aaaz"},
            {"bca", "aca", "aba"},
            {"azaz", "azaz", "ayaz"},
            {"a", "a", "z"},
            {"b", "b", "a"},
            {"ab", "ab", "aa"},
            {"ba", "ba", "aa"}
        };
        for (int i = 0; i < tests.length; i++) {
            String input = tests[i][0];
            String expected = tests[i][2];
            String result = solver.smallestString(input);
            String status = result.equals(expected) ? "PASS" : "FAIL";
            System.out.printf("Test %d | Output: %s | Expected: %s | %s\n", i + 1, result, expected, status);
        }
    }
}
