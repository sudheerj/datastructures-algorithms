package java1.algorithms.matrix.setMatrixZeroes;
import java.util.*;

public class SetMatrixZeroes {
    //TC: O(m*n) SC:O(1)
    private static void setZeros(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean rowZero = false;

        //Determine which rows/columns needs to be set to zero
        for(int r=0; r< rows; r++) {
            for(int c=0; c<cols; c++) {
                if(matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    if(r >0) {
                        matrix[r][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }

        for(int r=1; r<rows; r++) {
            for(int c=1; c<cols; c++) {
                if(matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int r=1; r<rows; r++) {
                matrix[r][0] = 0;
            }
        }

        if(rowZero) {
            for(int c=0; c<cols; c++) {
                matrix[0][c] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 0, 1}, {1, 0, 1}, {0, 1, 1}
        };
        int[][] matrix2 = {
            {1, 2, 3}, {4, 0, 6}, {7, 8, 9}
        };
        setZeros(matrix1);
        setZeros(matrix2);
        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(matrix2));
    }
}
