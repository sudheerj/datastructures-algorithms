package java1.algorithms.matrix.diagonalTraverse;

import java.util.Arrays;

public class DiagonalTraverse {
    //Anti-diagonal traversal with direction switching TC: O(m * n) SC: O(m * n)
    //Zigzag pattern with Even diagonal-> Up-right and Odd diagonal -> Down-left having row + col = constant condition
    private int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int rows = matrix.length, cols = matrix[0].length;

        int[] result = new int[rows * cols];

        int row=0, col=0;
        boolean movingUp = true; // true= up-right, false = down-left

        for(int i=0; i<result.length; i++) {
            result[i] = matrix[row][col];

            if(movingUp) {
                if(col == cols-1) {
                    row++;
                    movingUp = false;
                } else if(row == 0) {
                    col++;
                    movingUp = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if(row == rows-1) {
                    col++;
                    movingUp = true;
                } else if(col == 0) {
                    row++;
                    movingUp = true;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DiagonalTraverse sol = new DiagonalTraverse();

        int[][][] tests = {
            {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            {{1, 2, 3, 4}, {5, 6, 7, 8}},
            {{1, 2, 3, 4, 5}},
            {{1}, {2}, {3}, {4}},
            {{42}},
            {{1, 2}, {3, 4}, {5, 6}}
        };

        for (int[][] test : tests) {
            System.out.println(Arrays.toString(sol.findDiagonalOrder(test)));
        }
    }
}
