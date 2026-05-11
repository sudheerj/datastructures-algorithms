package java1.algorithms.matrix.transposeMatrix;

public class TransposeMatrix {
    private static int[][] transpose(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result[c][r] = matrix[r][c];
            }
        }

        return result;
    }

    private static void printMatrix(int[][] m) {
        for (int[] row : m) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < row.length; i++) {
                sb.append(row[i]);
                if (i < row.length - 1)
                    sb.append(", ");
            }
            System.out.println(sb.append("]").toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test 1: 2x3 matrix
        int[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println("Transpose of 2x3:");
        printMatrix(transpose(m1));
        // [1, 4]
        // [2, 5]
        // [3, 6]

        // Test 2: 3x3 square matrix
        int[][] m2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("Transpose of 3x3:");
        printMatrix(transpose(m2));
        // [1, 4, 7]
        // [2, 5, 8]
        // [3, 6, 9]

        // Test 3: 1x1 matrix
        int[][] m3 = { { 42 } };
        System.out.println("Transpose of 1x1:");
        printMatrix(transpose(m3));
        // [42]

        // Test 4: 1x3 row vector
        int[][] m4 = { { 1, 2, 3 } };
        System.out.println("Transpose of 1x3:");
        printMatrix(transpose(m4));
        // [1]
        // [2]
        // [3]
    }
}
