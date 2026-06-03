**Problem statement:** Write an efficient algorithm that searches for a value `target` in an `m x n` integer matrix. The matrix has the property that each row is sorted in ascending order left to right, and each column is sorted in ascending order top to bottom.

### Examples

```
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

Input: matrix = [[1,3,5],[2,4,6],[3,5,7]], target = 4
Output: true
```

**Algorithmic Steps**

1. Start from the **top-right corner** (`row = 0`, `col = cols - 1`).
2. While `row < rows` and `col >= 0`:
   - If `matrix[row][col] == target`, return `true`.
   - If `matrix[row][col] < target`, increment `row` (move down — current column can't contain target).
   - Else (`matrix[row][col] > target`), decrement `col` (move left — current row can't contain target).
3. Return `false` if the loop exits without finding the target.

| Complexity | Value |
|---|---|
| Time | O(m + n) |
| Space | O(1) |
