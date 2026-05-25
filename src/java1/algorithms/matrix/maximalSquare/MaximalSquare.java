package java1.algorithms.matrix.maximalSquare;

import java.util.Arrays;

public class MaximalSquare {
    // Using DP bottom-up approach TC: O(m * n) SC: O(m * n)
    private static int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == '1') {
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = 1 + Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]); //checking top, left & diagonal
                    }
                    maxSide = Math.max(maxSide, dp[r][c]);
                }
            }
        }
        return maxSide * maxSide;
    }

    //Top-down DP memoization with Recursive DFS TC:O(m * n) SC: O(m * n)
    private static int maximalSquareMemo(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int maxSide = 0;

        for (int i = 0; i < rows; i++) {
            Arrays.fill(memo[i], -1);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(matrix[r][c] == '1') {
                    maxSide = Math.max(maxSide, dfs(matrix, memo, r, c));
                }
            }
        }

        return maxSide * maxSide;
    }

    private static int dfs(char[][] matrix, int[][] memo, int r, int c) {
        if (r >= matrix.length || c >= matrix[0].length)
            return 0;

        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        int down = dfs(matrix, memo, r + 1, c);
        int right = dfs(matrix, memo, r, c + 1);
        int diagonal = dfs(matrix, memo, r + 1, c + 1);

        if (matrix[r][c] == '1') {
            memo[r][c] = 1 + Math.min(Math.min(down, right), diagonal);
        } else {
            memo[r][c] = 0;
        }

        return memo[r][c];
    }

    // Using Optimized 1 DP bottom-up approach TC: O(m * n) SC: O(m * n)
    private int maximalSquareOptimized(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] dp = new int[cols];
        int maxSide = 0;

        for(int r=0; r< rows; r++) {
            int diagonal = 0;
            for(int c=0; c<cols; c++) {
                int top = dp[c];

                if(matrix[r][c] == '1') {
                    if(r == 0 || c == 0) {
                        dp[c] = 1;
                    } else {
                        dp[c] = 1 + Math.min(Math.min(top, dp[c-1]), diagonal);
                        maxSide = Math.max(maxSide, dp[c]);
                    }
                } else {
                    dp[c] = 0;
                }
                diagonal = top;
            }
        }

        return maxSide * maxSide;
    }


    public static void main(String[] args) {
        // 2x2 square of 1s exists -> 4
        System.out.println(maximalSquare(new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        }) + " (expected 4)");

        // single 1 -> 1
        System.out.println(maximalSquare(new char[][] {
                { '0', '1' },
                { '1', '0' }
        }) + " (expected 1)");

        // all zeros -> 0
        System.out.println(maximalSquare(new char[][] {
                { '0' }
        }) + " (expected 0)");

        // all ones 3x3 -> 9
        System.out.println(maximalSquare(new char[][] {
                { '1', '1', '1' },
                { '1', '1', '1' },
                { '1', '1', '1' }
        }) + " (expected 9)");

        // single cell 1 -> 1
        System.out.println(maximalSquare(new char[][] {
                { '1' }
        }) + " (expected 1)");

        System.out.println("\n-- Memo --");

        // 2x2 square of 1s exists -> 4
        System.out.println(maximalSquareMemo(new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        }) + " (expected 4)");

        // diagonal 1s -> 1
        System.out.println(maximalSquareMemo(new char[][] {
                { '0', '1' },
                { '1', '0' }
        }) + " (expected 1)");

        // all zeros -> 0
        System.out.println(maximalSquareMemo(new char[][] {
                { '0' }
        }) + " (expected 0)");

        // all ones 3x3 -> 9
        System.out.println(maximalSquareMemo(new char[][] {
                { '1', '1', '1' },
                { '1', '1', '1' },
                { '1', '1', '1' }
        }) + " (expected 9)");

        // single cell 1 -> 1
        System.out.println(maximalSquareMemo(new char[][] {
                { '1' }
        }) + " (expected 1)");

        System.out.println("\n-- Optimized --");
        MaximalSquare solOpt = new MaximalSquare();

        // 2x2 square of 1s exists -> 4
        System.out.println(solOpt.maximalSquareOptimized(new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        }) + " (expected 4)");

        // diagonal 1s -> 1
        System.out.println(solOpt.maximalSquareOptimized(new char[][] {
                { '0', '1' },
                { '1', '0' }
        }) + " (expected 1)");

        // all zeros -> 0
        System.out.println(solOpt.maximalSquareOptimized(new char[][] {
                { '0' }
        }) + " (expected 0)");

        // all ones 3x3 -> 9
        System.out.println(solOpt.maximalSquareOptimized(new char[][] {
                { '1', '1', '1' },
                { '1', '1', '1' },
                { '1', '1', '1' }
        }) + " (expected 9)");

        // single cell 1 -> 1
        System.out.println(solOpt.maximalSquareOptimized(new char[][] {
                { '1' }
        }) + " (expected 1)");
    }
}
