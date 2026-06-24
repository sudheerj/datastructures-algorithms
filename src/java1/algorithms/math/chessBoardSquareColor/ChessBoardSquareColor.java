package java1.algorithms.math.chessBoardSquareColor;

public class ChessBoardSquareColor {
    //Parity(odd/even) of coordinates: - convert column value to a number TC: O(1) SC: O(1)
    //Columns 'a', 'c', 'e', 'g' start with black on row 1 and Columns 'b', 'd', 'f', 'h' start with white on row 1.
    private static boolean squareIsWhite(String coordinates) {
        int col = coordinates.charAt(0) - 'a' + 1;
        int row = coordinates.charAt(1) - '0';
        
        return (col + row) % 2 == 1;
    }

    public static void main(String[] args) {
        String[] tests = {
            "a1", "a2", "a3", "a8",
            "b1", "b2", "b7", "b8",
            "c1", "c7",
            "d4", "d5",
            "e4", "e5",
            "f6", "g7",
            "h1", "h2", "h3", "h8"
        };

        for (String square : tests) {
            System.out.printf(
                "%s -> %s%n",
                square,
                squareIsWhite(square) ? "White" : "Black"
            );
        }
    }


}
