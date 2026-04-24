package java1.algorithms.matrix.searchMatrix;

public class SearchMatrix {
    public static void main(String[] args) {
        // Example 1: Target present
        int[][] matrix1 = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        System.out.println("Input: matrix1, target=3 -> Output: " + searchMatrix(matrix1, 3)); // true

        // Example 2: Target absent
        System.out.println("Input: matrix1, target=13 -> Output: " + searchMatrix(matrix1, 13)); // false

        // Example 3: Single row
        int[][] matrix2 = { { 1, 2, 3, 4, 5 } };
        System.out.println("Input: matrix2, target=4 -> Output: " + searchMatrix(matrix2, 4)); // true

        // Example 4: Single column
        int[][] matrix3 = { { 1 }, { 3 }, { 5 } };
        System.out.println("Input: matrix3, target=5 -> Output: " + searchMatrix(matrix3, 5)); // true

        // Example 5: 1x1 matrix, target present
        int[][] matrix4 = { { 7 } };
        System.out.println("Input: matrix4, target=7 -> Output: " + searchMatrix(matrix4, 7)); // true

        // Example 6: 1x1 matrix, target absent
        System.out.println("Input: matrix4, target=2 -> Output: " + searchMatrix(matrix4, 2)); // false

        // Example 7: Empty matrix
        int[][] matrix5 = {};
        // Avoid calling searchMatrix on empty matrix to prevent exception
        System.out.println("Input: empty matrix, target=1 -> Output: false");
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = matrix[mid / cols][mid % cols];
            if (target > value) {
                left = mid + 1;
            } else if (target < value) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
