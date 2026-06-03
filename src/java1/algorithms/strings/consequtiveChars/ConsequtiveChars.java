package java1.algorithms.strings.consequtiveChars;

public class ConsequtiveChars {

    //Simple scan and compare with prev char TC: O(n) SC: O(1)
    private int maxPower(String s) {
        if (s == null || s.length() == 0) return 0;
        int currentStreak = 1, longestStreak = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;
    }

        public static void main(String[] args) {
            ConsequtiveChars solver = new ConsequtiveChars();
            String[] tests = {"leetcode", "abbcccddddeeeeedcba", "triplepillooooow", "hooraaaaaaaaaaay", "tourist", "", "a"};
            int[] expected = {2, 5, 5, 11, 1, 0, 1};
            for (int i = 0; i < tests.length; i++) {
                int result = solver.maxPower(tests[i]);
                String status = result == expected[i] ? "PASS" : "FAIL";
                System.out.printf("Test %d | Output: %d | Expected: %d | %s\n", i+1, result, expected[i], status);
            }
        }
}
