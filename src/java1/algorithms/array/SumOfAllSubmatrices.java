package java1.algorithms.array;

public class SumOfAllSubmatrices {
    
    public static int sumOfAllSubmatrices(int[][] A) {
        int n = A.length;
        int sum = 0;

        // Iterate through the matrix using nested loops
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int topLeft = (i + 1) * (j + 1);
                int bottomLeft = (n - i) * (n - j);
                sum += topLeft * bottomLeft * A[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2},
            {3, 4}
        };
        System.out.println(sumOfAllSubmatrices(matrix)); // Example output: 120
    }

}

// Time Complexity - O(n^2)
// Space Complexity - O(1)