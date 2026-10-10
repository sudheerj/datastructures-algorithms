package java1.algorithms.dynamicProgramming.grid.longestIncreasingPathInMatrix;

public class LongestIncreasingPathInMatrix {
    // 2 DP + DFS(memoization) => TC: O(m * n) SC: O(m * n)
    public static int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        int answer = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                answer = Math.max(answer, dfs(matrix, dp, dirs, r, c));
            }
        }

        return answer;
    }

    public static int dfs(int[][] matrix, int[][] dp, int[][] dirs, int r, int c) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int best = 1;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length && matrix[nr][nc] > matrix[r][c]) {
                best = Math.max(best, 1 + dfs(matrix, dp, dirs, nr, nc));
            }
        }
        dp[r][c] = best;

        return best;
    }

    public static void main(String[] args) {
        int[][][] testCases = {
                {
                        { 9, 9, 4 },
                        { 6, 6, 8 },
                        { 2, 1, 1 }
                },
                {
                        { 3, 4, 5 },
                        { 3, 2, 6 },
                        { 2, 2, 1 }
                },
                {
                        { 1 }
                },
                {
                        { 7, 7 },
                        { 7, 7 }
                }
        };
        int[] expected = { 4, 4, 1, 1 };

        for (int i = 0; i < testCases.length; i++) {
            int actual = longestIncreasingPath(testCases[i]);
            System.out.println("Test " + (i + 1) + ": expected=" + expected[i]
                    + ", actual=" + actual + (actual == expected[i] ? " [PASS]" : " [FAIL]"));
        }
    }
}
