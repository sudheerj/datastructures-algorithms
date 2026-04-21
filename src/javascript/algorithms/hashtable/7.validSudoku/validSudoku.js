
// Solution 1: Set-based
function isValidSudoku1(board) {
  const rows = Array.from({ length: 9 }, () => new Set());
  const cols = Array.from({ length: 9 }, () => new Set());
  const boxes = Array.from({ length: 9 }, () => new Set());
  for (let r = 0; r < 9; r++) {
    for (let c = 0; c < 9; c++) {
      const val = board[r][c];
      if (val === ".") continue;
      const boxIdx = Math.floor(r / 3) * 3 + Math.floor(c / 3);
      if (rows[r].has(val) || cols[c].has(val) || boxes[boxIdx].has(val)) {
        return false;
      }
      rows[r].add(val);
      cols[c].add(val);
      boxes[boxIdx].add(val);
    }
  }
  return true;
}

// Solution 2: Boolean Array
function isValidSudoku2(board) {
  const rows = Array.from({ length: 9 }, () => Array(9).fill(false));
  const cols = Array.from({ length: 9 }, () => Array(9).fill(false));
  const boxes = Array.from({ length: 9 }, () => Array(9).fill(false));
  for (let r = 0; r < 9; r++) {
    for (let c = 0; c < 9; c++) {
      const val = board[r][c];
      if (val === ".") continue;
      const num = parseInt(val) - 1;
      const boxIdx = Math.floor(r / 3) * 3 + Math.floor(c / 3);
      if (rows[r][num] || cols[c][num] || boxes[boxIdx][num]) {
        return false;
      }
      rows[r][num] = cols[c][num] = boxes[boxIdx][num] = true;
    }
  }
  return true;
}

// Solution 3: Map-based
function isValidSudoku3(board) {
  const rows = {};
  const cols = {};
  const boxes = {};
  for (let r = 0; r < 9; r++) {
    for (let c = 0; c < 9; c++) {
      const val = board[r][c];
      if (val === ".") continue;
      const boxIdx = `${Math.floor(r / 3)}-${Math.floor(c / 3)}`;
      if ((rows[r] && rows[r][val]) || (cols[c] && cols[c][val]) || (boxes[boxIdx] && boxes[boxIdx][val])) {
        return false;
      }
      rows[r] = rows[r] || {};
      cols[c] = cols[c] || {};
      boxes[boxIdx] = boxes[boxIdx] || {};
      rows[r][val] = true;
      cols[c][val] = true;
      boxes[boxIdx][val] = true;
    }
  }
  return true;
}


// Example 1: Valid Sudoku
const board1 = [
  ["5", "3", ".", ".", "7", ".", ".", ".", "."],
  ["6", ".", ".", "1", "9", "5", ".", ".", "."],
  [".", "9", "8", ".", ".", ".", ".", "6", "."],
  ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
  ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
  ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
  [".", "6", ".", ".", ".", ".", "2", "8", "."],
  [".", ".", ".", "4", "1", "9", ".", ".", "5"],
  [".", ".", ".", ".", "8", ".", ".", "7", "9"],
];
console.log("isValidSudoku1:", isValidSudoku1(board1)); // Expected: true
console.log("isValidSudoku2:", isValidSudoku2(board1)); // Expected: true
console.log("isValidSudoku3:", isValidSudoku3(board1)); // Expected: true

// Example 2: Invalid Sudoku (duplicate in row)
const board2 = [
  ["8", "3", ".", ".", "7", ".", ".", ".", "."],
  ["6", ".", ".", "1", "9", "5", ".", ".", "."],
  [".", "9", "8", ".", ".", ".", ".", "6", "."],
  ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
  ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
  ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
  [".", "6", ".", ".", ".", ".", "2", "8", "."],
  [".", ".", ".", "4", "1", "9", ".", ".", "5"],
  [".", ".", ".", ".", "8", ".", ".", "7", "9"],
];
console.log("isValidSudoku1:", isValidSudoku1(board2)); // Expected: false
console.log("isValidSudoku2:", isValidSudoku2(board2)); // Expected: false
console.log("isValidSudoku3:", isValidSudoku3(board2)); // Expected: false
