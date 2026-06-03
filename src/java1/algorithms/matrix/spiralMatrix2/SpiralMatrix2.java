package java1.algorithms.matrix.spiralMatrix2;

public class SpiralMatrix2 {
    private int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int left =0, right = matrix[0].length, top = 0, bottom = matrix.length;
        int num = 1;

        while(left < right && top < bottom) {
            for(int i= left; i<right; i++) {
                matrix[top][i] = num++;
            }

            top++;

            for(int i=top; i<bottom; i++) {
                matrix[i][right-1] = num++;
            }

            right--;

            if(!(left < right && top < bottom)) break;

            for(int i=right-1;i>=left; i--) {
                matrix[bottom-1][i] = num++;
            }

            bottom--;

            for(int i= bottom-1; i>=top; i--) {
                matrix[i][left] = num++;
            }

            left++;

        }
        
        return matrix;
    }
}
