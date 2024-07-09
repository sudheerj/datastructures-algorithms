package java1.algorithms.array;

import java.util.Arrays;

public class SpiralOrderMatrix2 {

    public static int[][] spiralOrderMatrix2(int A) {
        int[][] matrix = new int[A][A];
        int top = 0;
        int bottom = A - 1;
        int left = 0;
        int right = A - 1;

        int current = 1;

        while (current <= A * A) {
            // Fill from left to right along the top row
            for (int i = left; i <= right; i++) {
                matrix[top][i] = current;
                current++;
            }
            top++;

            // Fill from top to bottom along the rightmost column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = current;
                current++;
            }
            right--;

            // Fill from right to left along the bottom row
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = current;
                current++;
            }
            bottom--;

            // Fill from bottom to top along the leftmost column
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = current;
                current++;
            }
            left++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int A = 4;
        int[][] result = spiralOrderMatrix2(A);

        // Print the generated matrix
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

}

// Time Complexity - O(A * A)
// Space Complexity - O(A * A)