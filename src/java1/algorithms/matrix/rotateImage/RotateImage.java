package java1.algorithms.matrix.rotateImage;

import java.util.Arrays;

public class RotateImage {
    // TC: O(n^2) SC: O(1)
    private static void rotate(int[][] matrix) {
        int left =0, right = matrix[0].length-1;

        while (left < right) {
            for(int i=0; i< right-left; i++) {
                int top = left, bottom = right;

                //Store the topLeft
                int topLeft = matrix[top][left+i];

                //Move bottom left into top left
                matrix[top][left+i] = matrix[bottom-i][left];

                //Move bottom right into bottom left
                matrix[bottom-i][left] = matrix[bottom][right-i];

                //Move top right into bottom right
                matrix[bottom][right-i] = matrix[top+i][right];

                //Move top left into top right
                matrix[top+i][right] = topLeft;
            }
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2},
            {3, 4}
        };
        int[][] matrix2 = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int[][] matrix3 = {
            {1, 2, 3, 4}, 
            {5, 6, 7, 8},
            {9, 10, 11, 12}, 
            {13, 14, 15, 16}
        };
        rotate(matrix1);
        rotate(matrix2);
        rotate(matrix3);
        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(matrix2));
        System.out.println(Arrays.deepToString(matrix3));
    }
}
