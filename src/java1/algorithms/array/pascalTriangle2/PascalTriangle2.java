package pascalTriangle2;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    //Copy from previous row TC: O(k^2) SC: O(k)
    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for(int i=1; i<=rowIndex; i++) {
            List<Integer> next = new ArrayList<>();
            //Add first element
            next.add(1);

            //Middle elements
            for(int j=1; j<i; j++) {
                next.add(row.get(j-1)+row.get(j));
            }

            //add last element
            next.add(1);

            row = next;
        }

        return row;
    }

    //In-place updates TC: O(k^2) SC: O(k)
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for(int i=0; i<=rowIndex; i++) {
            row.add(1);
        }

        for(int i=2; i<=rowIndex; i++) {
            //Right -> Left to avoid overwrite values
            for(int j=i-1; j>0;j--) {
                row.set(j, row.get(j-1)+row.get(j));
            }
        }

        return row;
    }

    public static void main(String[] args) {
        Object[][] tests = {
                { 0, List.of(1) },
                { 1, List.of(1, 1) },
                { 2, List.of(1, 2, 1) },
                { 3, List.of(1, 3, 3, 1) },
                { 4, List.of(1, 4, 6, 4, 1) },
                { 5, List.of(1, 5, 10, 10, 5, 1) },
        };

        System.out.println("=== getRow1 (copy from previous row) ===");
        for (Object[] test : tests) {
            int rowIndex = (int) test[0];
            @SuppressWarnings("unchecked")
            List<Integer> expected = (List<Integer>) test[1];
            List<Integer> result = getRow1(rowIndex);
            String status = result.equals(expected) ? "PASS" : "FAIL";
            System.out.println("[" + status + "] rowIndex=" + rowIndex + " result=" + result + " expected=" + expected);
        }

        System.out.println("=== getRow2 (in-place updates) ===");
        for (Object[] test : tests) {
            int rowIndex = (int) test[0];
            @SuppressWarnings("unchecked")
            List<Integer> expected = (List<Integer>) test[1];
            List<Integer> result = getRow2(rowIndex);
            String status = result.equals(expected) ? "PASS" : "FAIL";
            System.out.println("[" + status + "] rowIndex=" + rowIndex + " result=" + result + " expected=" + expected);
        }
    }
}
