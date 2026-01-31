package matrix;

/**
 * Unique Paths
 *
 * A robot is located at the top-left corner of an m x n grid. The robot can only
 * move either down or right at any point. How many unique paths exist to reach
 * the bottom-right corner?
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(n) optimized
 */
public class UniquePaths {

    /**
     * DP approach with space optimization
     * TC: O(m * n), SC: O(n)
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    /**
     * DP approach with 2D array
     * TC: O(m * n), SC: O(m * n)
     */
    public int uniquePaths2D(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize first row and column
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * Mathematical approach using combinations
     * C(m+n-2, m-1)
     * TC: O(min(m, n)), SC: O(1)
     */
    public int uniquePathsMath(int m, int n) {
        long result = 1;
        for (int i = 1; i < m; i++) {
            result = result * (n - 1 + i) / i;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();

        System.out.println("Unique paths(3, 7): " + solution.uniquePaths(3, 7)); // 28
        System.out.println("Unique paths(3, 2): " + solution.uniquePaths(3, 2)); // 3
        System.out.println("Unique paths(7, 3): " + solution.uniquePaths(7, 3)); // 28
        System.out.println("Unique paths(3, 3): " + solution.uniquePaths(3, 3)); // 6
        System.out.println("Unique paths (math)(3, 7): " + solution.uniquePathsMath(3, 7)); // 28
    }
}
