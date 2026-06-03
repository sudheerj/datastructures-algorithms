package java1.algorithms.array.heightChecker;

public class HeightChecker {
    // frequency counting TC: O(n) SC: O(1); n = number of students
    public static int heightChecker(int[] heights) {
        int[] count = new int[101];

        for (int height : heights) {
            count[height]++;
        }

        int mismatches = 0;
        int currentHeight = 1;
        for (int i = 0; i < heights.length; i++) {
            while (count[currentHeight] == 0) {
                currentHeight++;
            }

            if (heights[i] != currentHeight) {
                mismatches++;
            }

            count[currentHeight]--;
        }

        return mismatches;
    }

    public static void main(String[] args) {
        Object[][] tests = {
                // Test 1: LeetCode example — 3 students out of position
                new Object[] { new int[] { 1, 1, 4, 2, 1, 3 }, 3 },
                // Test 2: all students out of position
                new Object[] { new int[] { 5, 1, 2, 3, 4 }, 5 },
                // Test 3: already sorted — no mismatches
                new Object[] { new int[] { 1, 2, 3, 4, 5 }, 0 },
                // Test 4: mixed mismatches
                new Object[] { new int[] { 2, 1, 2, 1, 1, 2, 2, 1 }, 4 },
                // Test 5: single student — always matches
                new Object[] { new int[] { 1 }, 0 },
                // Test 6: all same height — no mismatches
                new Object[] { new int[] { 3, 3, 3, 3 }, 0 },
        };

        for (int t = 0; t < tests.length; t++) {
            int[] heights = (int[]) tests[t][0];
            int expected = (int) tests[t][1];
            int result = heightChecker(heights);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }
    }
}
