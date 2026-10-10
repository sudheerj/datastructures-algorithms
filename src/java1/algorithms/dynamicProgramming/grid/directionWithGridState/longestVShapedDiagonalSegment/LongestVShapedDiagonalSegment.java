package java1.algorithms.dynamicProgramming.grid.directionWithGridState.longestVShapedDiagonalSegment;

public class LongestVShapedDiagonalSegment {
    // DFS memoization TC: O(m * n) SC: O(m * n)
    public static int lenOfVDiagonal(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 0 = southeast, 1 = southwest, 2 = northwest, 3 = northeast
        int[][] dirs = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
        Integer[][][][] dp = new Integer[rows][cols][4][2];
        int answer = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != 1) {
                    continue;
                }

                for (int dir = 0; dir < 4; dir++) {
                    answer = Math.max(answer, 1 + dfs(grid, r, c, dir, 1, dirs, dp));
                }
            }
        }

        return answer;
    }

    // Returns the longest valid segment starting at (r, c).
    public static int dfs(int[][] grid, int r, int c, int dir, int canTurn, int[][] dirs, Integer[][][][] dp) {
        // Already calculated
        if (dp[r][c][dir][canTurn] != null) {
            return dp[r][c][dir][canTurn];
        }

        // Pattern: 1 -> 2 -> 0 -> 2 -> 0 ...
        int nextValue = grid[r][c] == 1 ? 2 : 2 - grid[r][c];

        // Move on to next step
        int nr = r + dirs[dir][0];
        int nc = c + dirs[dir][1];

        // Check outside grid or invalid value
        if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] != nextValue) {
            return dp[r][c][dir][canTurn] = 0;
        }

        // Option1: Can go straight
        int best = dfs(grid, nr, nc, dir, canTurn, dirs, dp);

        // Option2: Turn clockwise once
        if (canTurn == 1) {
            int nextDir = (dir + 1) % 4;

            best = Math.max(best, dfs(grid, nr, nc, nextDir, 0, dirs, dp));
        }

        // count the next cell
        return dp[r][c][dir][canTurn] = 1 + best;
    }

    public static void main(String[] args) {
        int[][][] grids = {
                {
                        { 2, 2, 1, 2, 2 },
                        { 2, 0, 2, 2, 0 },
                        { 2, 0, 1, 1, 0 },
                        { 1, 0, 2, 2, 2 },
                        { 2, 0, 0, 2, 2 }
                },
                {
                        { 2, 2, 2, 2, 2 },
                        { 2, 0, 2, 2, 0 },
                        { 2, 0, 1, 1, 0 },
                        { 1, 0, 2, 2, 2 },
                        { 2, 0, 0, 2, 2 }
                },
                {
                        { 1, 2, 2, 2, 2 },
                        { 2, 2, 2, 2, 0 },
                        { 2, 0, 0, 0, 0 },
                        { 0, 0, 2, 2, 2 },
                        { 2, 0, 0, 2, 0 }
                },
                { { 1 } },
                { { 1, 1 }, { 1, 1 } }
        };
        int[] expected = { 5, 4, 5, 1, 1 };
        String[] labels = {
                "Example 1: clockwise turn",
                "Example 2: shorter diagonal",
                "Example 3: alternate turn",
                "single cell",
                "no matching diagonal continuation"
        };

        for (int i = 0; i < grids.length; i++) {
            int result = lenOfVDiagonal(grids[i]);
            System.out.println("[" + (result == expected[i] ? "PASS" : "FAIL") + "] "
                    + labels[i] + ": " + result + " (expected " + expected[i] + ")");
        }
    }
}
