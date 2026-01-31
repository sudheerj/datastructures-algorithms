package matrix;

/**
 * Diagonal Difference
 *
 * Given a square matrix, calculate the absolute difference between the sums of
 * its diagonals.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class DiagonalDifference {

    /**
     * Calculate absolute difference between diagonal sums
     * TC: O(n), SC: O(1)
     */
    public int diagonalDifference(int[][] matrix) {
        int n = matrix.length;
        int primarySum = 0;
        int secondarySum = 0;

        for (int i = 0; i < n; i++) {
            primarySum += matrix[i][i];           // Primary diagonal
            secondarySum += matrix[i][n - 1 - i]; // Secondary diagonal
        }

        return Math.abs(primarySum - secondarySum);
    }

    /**
     * Alternative: Single variable to track difference
     * TC: O(n), SC: O(1)
     */
    public int diagonalDifferenceSingleVar(int[][] matrix) {
        int n = matrix.length;
        int diff = 0;

        for (int i = 0; i < n; i++) {
            diff += matrix[i][i] - matrix[i][n - 1 - i];
        }

        return Math.abs(diff);
    }

    public static void main(String[] args) {
        DiagonalDifference solution = new DiagonalDifference();

        // Example 1
        int[][] matrix1 = {
            {11, 2, 4},
            {4, 5, 6},
            {10, 8, -12}
        };
        // Primary: 11 + 5 + (-12) = 4
        // Secondary: 4 + 5 + 10 = 19
        // |4 - 19| = 15
        System.out.println("Diagonal difference: " + solution.diagonalDifference(matrix1)); // 15

        // Example 2
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {9, 8, 9}
        };
        // Primary: 1 + 5 + 9 = 15
        // Secondary: 3 + 5 + 9 = 17
        // |15 - 17| = 2
        System.out.println("Diagonal difference: " + solution.diagonalDifference(matrix2)); // 2

        // Example 3: Single element
        int[][] matrix3 = {{5}};
        System.out.println("Diagonal difference: " + solution.diagonalDifference(matrix3)); // 0
    }
}
