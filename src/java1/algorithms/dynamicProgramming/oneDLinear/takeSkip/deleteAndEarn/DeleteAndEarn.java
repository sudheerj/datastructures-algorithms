package java1.algorithms.dynamicProgramming.oneDLinear.takeSkip.deleteAndEarn;

public class DeleteAndEarn {
    // DP Two variables TC: O(n + max) SC: O(max)
    public static int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Convert duplicates into points
        int[] points = new int[max + 1];

        for (int num : nums) {
            points[num] += num;
        }

        int earn1 = 0, earn2 = 0;

        for (int i = 1; i <= max; i++) {
            int newEarn = Math.max(points[i] + earn1, earn2);
            earn1 = earn2;
            earn2 = newEarn;
        }

        return earn2;
    }

    public static void main(String[] args) {
        int[][] tests = {
                { 3, 4, 2 },
                { 2, 2, 3, 3, 3, 4 },
                { 1 },
                { 2, 2, 2, 2 },
                { 1, 1, 1, 2, 4, 5, 5, 5, 6 }
        };
        int[] expected = { 6, 9, 1, 8, 18 };
        String[] labels = {
                "Example 1",
                "Example 2",
                "single value",
                "repeated value",
                "non-adjacent values with duplicates"
        };

        for (int i = 0; i < tests.length; i++) {
            int actual = deleteAndEarn(tests[i]);
            System.out.println("[" + (actual == expected[i] ? "PASS" : "FAIL") + "] "
                    + labels[i] + ": " + actual + " (expected " + expected[i] + ")");
        }
    }
}
