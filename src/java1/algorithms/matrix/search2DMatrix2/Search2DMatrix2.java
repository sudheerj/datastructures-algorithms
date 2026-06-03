package java1.algorithms.matrix.search2DMatrix2;

public class Search2DMatrix2 {
    // Eliminate row or column TC: O(m+n) SC: O(1) m = number of rows, n = number of
    // columns
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0, col = cols - 1; // start from top-right

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] < target)
                row++; // move down
            else if (matrix[row][col] > target)
                col--; // move left
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] m1 = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        int[][] m2 = { { 1, 1 } };
        int[][] m3 = { { 1, 3, 5 }, { 2, 4, 6 }, { 3, 5, 7 } };

        Object[][] tests = {
                { m1, 5, true },
                { m1, 20, false },
                { m1, 15, true },
                { m2, 2, false },
                { m2, 1, true },
                { m3, 4, true },
        };

        for (Object[] test : tests) {
            int[][] matrix = (int[][]) test[0];
            int target = (int) test[1];
            boolean expected = (boolean) test[2];
            boolean result = searchMatrix(matrix, target);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] target=" + target + " result=" + result + " expected=" + expected);
        }
    }
}
