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

/**
 * Use sets to track seen numbers
 * @param {character[][]} board
 * @return {boolean}
 */
function isValidSudoku(board) {
    const rows = Array.from({ length: 9 }, () => new Set());
    const cols = Array.from({ length: 9 }, () => new Set());
    const boxes = Array.from({ length: 9 }, () => new Set());

    for (let r = 0; r < 9; r++) {
        for (let c = 0; c < 9; c++) {
            const num = board[r][c];

            if (num === '.') {
                continue;
            }

            // Calculate box index (0-8)
            const boxIdx = Math.floor(r / 3) * 3 + Math.floor(c / 3);

            // Check if number already exists
            if (rows[r].has(num) || cols[c].has(num) || boxes[boxIdx].has(num)) {
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
 * @param {character[][]} board
 * @return {boolean}
 */
function isValidSudokuSingleSet(board) {
    const seen = new Set();

    for (let r = 0; r < 9; r++) {
        for (let c = 0; c < 9; c++) {
            const num = board[r][c];

            if (num === '.') {
                continue;
            }

            const rowKey = `row${r}:${num}`;
            const colKey = `col${c}:${num}`;
            const boxKey = `box${Math.floor(r / 3)},${Math.floor(c / 3)}:${num}`;

            if (seen.has(rowKey) || seen.has(colKey) || seen.has(boxKey)) {
                return false;
            }

            seen.add(rowKey);
            seen.add(colKey);
            seen.add(boxKey);
        }
    }

    return true;
}

// Test cases
const board1 = [
    ["5", "3", ".", ".", "7", ".", ".", ".", "."],
    ["6", ".", ".", "1", "9", "5", ".", ".", "."],
    [".", "9", "8", ".", ".", ".", ".", "6", "."],
    ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
    ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
    ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
    [".", "6", ".", ".", ".", ".", "2", "8", "."],
    [".", ".", ".", "4", "1", "9", ".", ".", "5"],
    [".", ".", ".", ".", "8", ".", ".", "7", "9"]
];
console.log("Is valid sudoku:", isValidSudoku(board1)); // true

const board2 = [
    ["8", "3", ".", ".", "7", ".", ".", ".", "."],
    ["6", ".", ".", "1", "9", "5", ".", ".", "."],
    [".", "9", "8", ".", ".", ".", ".", "6", "."],
    ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
    ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
    ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
    [".", "6", ".", ".", ".", ".", "2", "8", "."],
    [".", ".", ".", "4", "1", "9", ".", ".", "5"],
    [".", ".", ".", ".", "8", ".", ".", "7", "9"]
];
console.log("Is valid sudoku:", isValidSudoku(board2)); // false
