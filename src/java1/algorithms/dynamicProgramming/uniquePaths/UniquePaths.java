package java1.algorithms.dynamicProgramming.uniquePaths;
import java.util.*;

public class UniquePaths {
    //Dynamic programming:- TC:O(m*n) OC:O(n)
    private static int uniquePaths2(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for(int i=1; i<m; i++){
            int[] newRow = new int[n];
            newRow[0] = 1;
            for(int j=1; j<n; j++) {
                newRow[j] = row[j] + newRow[j-1];
            }
            row = newRow;
        }
        return row[n-1];
    }

    //Dynamic programming:- TC:O(m*n) OC:O(m*n)
    private static int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i== 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
         int m1 = 4, n1 = 5, m2 = 3, n2 = 3;
         System.out.println(uniquePaths1(m1, n1));
         System.out.println(uniquePaths2(m1, n1));
         System.out.println(uniquePaths1(m2, n2));
         System.out.println(uniquePaths2(m2, n2));
    }
}
