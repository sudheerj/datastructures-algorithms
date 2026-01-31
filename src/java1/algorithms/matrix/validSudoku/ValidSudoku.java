package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Valid Sudoku
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3 x 3 sub-boxes must contain the digits 1-9 without repetition.
 *
 * Time Complexity: O(1) - fixed 9x9 board
 * Space Complexity: O(1) - fixed size sets
 */
public class ValidSudoku {

    /**
     * Use sets to track seen numbers
     * TC: O(1), SC: O(1)
     */
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];

                if (num == '.') {
                    continue;
                }

                // Calculate box index (0-8)
                int boxIdx = (r / 3) * 3 + (c / 3);

                // Check if number already exists
                if (rows[r].contains(num) || cols[c].contains(num) || boxes[boxIdx].contains(num)) {
                    return false;
                }

                // Add number to sets
                rows[r].add(num);
                cols[c].add(num);
                boxes[boxIdx].add(num);
            }
        }

        return true;
    }

    /**
     * Alternative: Use a single set with encoded keys
     * TC: O(1), SC: O(1)
     */
    public boolean isValidSudokuSingleSet(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];

                if (num == '.') {
                    continue;
                }

                String rowKey = "row" + r + ":" + num;
                String colKey = "col" + c + ":" + num;
                String boxKey = "box" + (r / 3) + "," + (c / 3) + ":" + num;

                if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                    return false;
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();

        // Example 1: Valid sudoku
        char[][] board1 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Is valid sudoku: " + solution.isValidSudoku(board1)); // true

        // Example 2: Invalid sudoku
        char[][] board2 = {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Is valid sudoku: " + solution.isValidSudoku(board2)); // false
    }
}
