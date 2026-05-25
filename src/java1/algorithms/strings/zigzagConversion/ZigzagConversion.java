package java1.algorithms.strings.zigzagConversion;

public class ZigzagConversion {
    //Simulation with direction switching TC: O(n) SC: O(n)
    private static String zigzagConversion(String s, int numRows) {
        //edge case
        if(numRows <= 1 || numRows >= s.length()) return s;

        //create rows
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0; i< numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        int dir = 1;

        for(char ch: s.toCharArray()) {
            rows[currRow].append(ch);
            //Change direction at top or bottom
            if(currRow == 0 || currRow == numRows-1) {
                dir *= -1;
            }
            currRow += dir;
        }

        //Combine rows
        StringBuilder sb = new StringBuilder();
        for(StringBuilder row: rows) {
            sb.append(row);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        // Example 1: "PAYPALISHIRING", 3
        // Expected: "PAHNAPLSIIGYIR"
        System.out.println(zigzagConversion("PAYPALISHIRING", 3));

        // Example 2: "PAYPALISHIRING", 4
        // Expected: "PINALSIGYAHRPI"
        System.out.println(zigzagConversion("PAYPALISHIRING", 4));

        // Example 3: "A", 1
        // Expected: "A"
        System.out.println(zigzagConversion("A", 1));

        // Example 4: "AB", 1
        // Expected: "AB"
        System.out.println(zigzagConversion("AB", 1));

        // Example 5: "ABC", 2
        // Expected: "ACB"
        System.out.println(zigzagConversion("ABC", 2));
    }
}
