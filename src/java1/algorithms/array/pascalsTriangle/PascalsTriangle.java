package pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    //2D DP problem TC: O(n^2) SC: O(n^2)
    private static List<List<Integer>> generatePascalTriangle(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>(row+1);
            for (int col = 0; col <= row; col++) {
                if(col == 0 || col == row) {
                    currentRow.add(1);
                } else {
                    currentRow.add(triangle.get(row-1).get(col-1) + triangle.get(row-1).get(col));
                }
            }
            triangle.add(currentRow);
        }
        return triangle;
    }
    public static void main(String[] args) {
        int numRows1 = 5;
        System.out.println(generatePascalTriangle(numRows1));
        int numRows2 = 1;
        System.out.println(generatePascalTriangle(numRows2));
    }
}
