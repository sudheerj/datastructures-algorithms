package java1.algorithms.matrix.toeplitzMatrix;

public class ToeplitzMatrix {
    private static boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                if(matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {

        int[][] matrix1 = {
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {6, 5, 1, 2},
            {7, 6, 5, 1}
        };

        int[][] matrix2 = {
            {1, 2, 3},
            {4, 1, 9},
            {5, 4, 1}
        };

        System.out.println("Matrix 1 is Toeplitz: "
                + isToeplitzMatrix(matrix1)); // true

        System.out.println("Matrix 2 is Toeplitz: "
                + isToeplitzMatrix(matrix2)); // false
    }
}
