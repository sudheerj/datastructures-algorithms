**Description:**

Given an `m x n` grid, return the number of unique paths from the top-left to the bottom-right corner. You can only move either right or down at any point in time.


## Examples

**Example 1:**
```
Input: m = 3, n = 3
Output: 6
Explanation: There are 6 unique paths in a 3x3 grid.
```

**Example 2:**
```
Input: m = 4, n = 5
Output: 35
Explanation: There are 35 unique paths in a 4x5 grid.
```

**Example 3 (Edge):**
```
Input: m = 1, n = 5
Output: 1
```

**Example 4 (Edge):**
```
Input: m = 5, n = 1
Output: 1
```

## Algorithm steps
This problem is solved using **dynamic programming** to avoid recomputation of subproblems.

1. Accept row (`m`) and column (`n`) values as input arguments.

2. Initialize a row with the size of number of columns (`n`) by filling all the values to `1`. This is because there will be only one way to reach each cell in the first row.

3. Iterate over all the rows starting from second row to last row using index variable `i`.

4. For each iteration `i`,
    1. Initialize a new row (`new_row`) by filling all the values with zero.
    2. Initialize the first column's value of new row to `1` as there will be only one way to reach first column cells.
    3. Iterate over all the columns from second column to last column using index variable `j`.
        1. For each iteration `j`, update the new row value by sum up previous row cell (`row[j]`) and previous index value of new row (`new_row[j-1]`)
    4. Assign the updated current row to previous row value for the next iteration.

5. Repeat step3 until all the rows traversed.
6. Return the last index position of row (i.e, `row[n-1]`) which represents the number of unique paths to reach bottom-right corner cell.

**Time and Space complexity:**
This algorithm has a time complexity of `O(m * n)`, where `m` is the number of rows and `n` is the number of columns. This is because we need to traverse each cell in a two dimensional array. 

Here, we are using `row` array of length `n` as additional data structure to store the possible unique paths in each row. Hence, the space complexity will be `O(n)`.
