package java1.algorithms.matrix;

import java.util.*;

public class SpiralMatrix {
    // TC: O(rows*cols) SC: O(n)
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> traversal = new ArrayList<>();
        int c1 =0, c2 = matrix[0].length-1;
        int r1=0, r2= matrix.length-1;

        while(c1 <= c2 && r1 <= r2) {
            // Top row: r1: c1->c2
            for(int i=c1; i<=c2; i++) {
                traversal.add(matrix[r1][i]);
            }

            // Last column: c2: r1+1 -> r2
            for(int i=r1+1; i<=r2; i++) {
                traversal.add(matrix[i][c2]);
            }

            if(c1<c2 && r1<r2) {
                // Last row: r2: c2-1 -> c1
                for(int i= c2-1; i>=c1; i--) {
                    traversal.add(matrix[r2][i]);
                }

                // First column: c1: r2-1 -> r1+1
                for(int i= r2-1; i>=r1+1; i--) {
                    traversal.add(matrix[i][c1]);
                }
            }
            c1++;
            c2--;
            r1++;
            r2--;
        }
        return traversal;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        System.out.println(spiralOrder(matrix));
    }
}
