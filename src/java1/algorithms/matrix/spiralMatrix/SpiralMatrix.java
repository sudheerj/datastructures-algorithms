package java1.algorithms.matrix.spiralMatrix;

import java.util.*;

public class SpiralMatrix {
    // TC: O(m*n) SC: O(1)
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> traversal = new ArrayList<>();
        int left =0, right = matrix[0].length-1;
        int top =0, bottom= matrix.length-1;

        while(left <= right && top <= bottom) {
            // Top row elements
            for(int i=left; i<=right; i++) {
                traversal.add(matrix[top][i]);
            }

            top++;

            // Last column elements
            for(int i=top; i<=bottom; i++) {
                traversal.add(matrix[i][right]);
            }

            right--;

            if(left<=right && top<=bottom) {
                // Last row elements
                for(int i= right; i>=left; i--) {
                    traversal.add(matrix[bottom][i]);
                }

                bottom--;

                // First column elements
                for(int i= bottom; i>=top; i--) {
                    traversal.add(matrix[i][left]);
                }

                left++;
            }

        }
        return traversal;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2}, {3, 4}
        };
        int[][] matrix2 = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        int[][] matrix3 = {
            {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        };
        
        System.out.println(spiralOrder(matrix1));
        System.out.println(spiralOrder(matrix2));
        System.out.println(spiralOrder(matrix3));
    }
}
