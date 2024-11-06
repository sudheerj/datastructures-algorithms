package java1.algorithms.array.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    private static List<List<Integer>> generatePascalTriangle(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>(row+1);
            currentRow.add(1);
            for (int col = 1; col < row; col++) {
                currentRow.add(triangle.get(row-1).get(col-1) + triangle.get(row-1).get(col));
            }
            if(row >0) {
                currentRow.add(1);
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
