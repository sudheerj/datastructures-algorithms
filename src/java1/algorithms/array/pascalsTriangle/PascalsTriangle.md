**Description:**
Given an integer `numRows`, find the first `numRows` of Pascal's triangle. In Pascal's triangle, each number is formed by the sum of the two numbers directly above it except for boundaries(with value 1).

![Screenshot](../../../../images/pascal-triangle.png)

### Examples
Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1
Output: [[1]]

**Algorithmic Steps**
This problem is solved with the help of sequential numbers sum and average calculations. The algorithmic approach can be summarized as follows:

1. Initialize the triangle(`triangle`) with an empty to hold the rows of Pascal triangle.

2. Iterate over the rows starting from `0` to the given number of rows(`numRows`) provided.

3. Create each row initialized with `row+1` array elements and the first element is set to 1. This is because all border elements will be 1 in the triangle.

4. Iterate over the columns starting from `1` to `row-1` to calculate the new row values. Each cell value is calculated by the sum of two elements directly above it from the previous row.

5. Set the last element of each row to 1, except for the first row. 

6. Add the completed row to the triangle list.

7. Return the completed triangle upon generation of each row completed.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n^2)`, where `n` is the number of given rows. This is because we need to iterate over `n` rows and for each row, there can be upto `n` valued to be generated.
 
The output array needs `O(n^2)` space to accomodate all the triangle elements, where `n` is the number of given rows.. Hence, the total space complexity is `O(n^2)`.