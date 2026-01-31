# **Valid Sudoku**

## **Problem Statement**
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the nine 3 x 3 sub-boxes must contain the digits 1-9 without repetition.

---

## **Examples**

### Example 1:
- **Input**: Valid partially filled Sudoku board
- **Output**: `true`

### Example 2:
- **Input**: Board with duplicate 8 in first column
- **Output**: `false`

---

## **Algorithmic Approach**

1. Create sets to track numbers seen in each row, column, and 3x3 box.
2. Iterate through each cell:
   - Skip empty cells ('.').
   - Calculate box index: `(row / 3) * 3 + (col / 3)`.
   - Check if number already exists in row, column, or box set.
   - If duplicate found, return false.
   - Otherwise, add number to respective sets.
3. Return true if no duplicates found.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(1)`  
  Fixed 9x9 board size (81 cells).

- **Space Complexity**: `O(1)`  
  Fixed size sets (27 sets with at most 9 elements each).
