**Description:**
Given a 2-dimensional array of size `m x n` (where `m` is the number of rows and `n` is the number of columns), calculate the number of unique paths to reach from the top-left corner to the bottom-right corner.

**Note:** You can only move either right or down at any point in time.

## Examples:
Example 1:

Input: m1 = 4, n1 = 5
Output: 35

Example 2: 

Input: m2 = 3, n2 = 3
Output: 6

**Algorithmic Steps(Approach 1&2)**
This problem is solved efficiently using **Dynamic programming** approach by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

1. Accept row(`m`) and column(`n`) values as input arguments.

1. Initialize a row with the size of number of columns(`n`) by filling all the values to `1`. There is because there will be only one way to reach each cell in the first row.
   
2. Iterate over all the rows starting from second row to last row using index variable `i`.
   
3. For each iteration `i`, 
    1. Initialize a new row(`newRow`) by filling all the values with zero.
    2. Initialize the first column's value of new row to `1` as there will be only one way to reach first column cells. 
    3. Iterate over all the columns from second column to last column using index variable `j`.
        1. For each iteration `j`, update the new row value by sum up previous row cell(`row[j]`) and previous index value of new row(`newRow[j-1]`)
    4. Assign the updated current row to previous row value for the next iteration.
   
4. Repeat step3 until all the rows traversed.
5. Return the last index position of row(i.e, `row[n-1]`) which represents the number of unique paths to reach bottom-right corner cell.


**Time and Space complexity:**
This algorithm has a time complexity of `O(m * n)`, where `m` is the number of rows and `n ` is the number of columns. This is because we need to traverse each cell in a two-dimentional array. 

Here, we are using `row` array of length `n` as additonal datastructure to store the possible unique paths in each row. Hence, the space complexity will be `O(n)`.
