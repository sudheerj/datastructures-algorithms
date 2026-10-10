**Description:**
Given two strings `str1` and `str2`, find the length of their longest common subsequence. Return 0, in case there is no common subsequence.

## Examples:
Example 1:

Input: str1 = 'abcdef', str2 = 'acbefd'
Output: 4

Example 2: 

Input: str1 = 'abcd', str2 = 'efgh'
Output: 0

**Algorithmic Steps(Approach 1&2)**
This problem is solved efficiently using **two dimensional bottom-up dynamic programming** approach by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

1. Create a two-dementional array(`dp`) to hold the longest common subsequence between two strings( `str1` and `str2`). Initialize the array values with `0` indicating no common letters between the strings.
      
2. Iterate first string(`str1`) characters from last to beginning index using an index variable(`i`). This iteration represents rows in 2-dimentional array.

3. Add a nested loop to iterate the second string(`str2`) elements last to beginning index using an index variable(`j`). These elements represent columns in a two-dimentional array.

4. If the letters of two strings are the same at the diagonal position, there is a match for the characters and the value at the diagonal position(`dp[i][j]`) needs to be incremented by 1 compared to the previous diagonal value.

5. Otherwise(if the letters are not same), the value at the diagonal position(`dp[i][j]`) is calculated by maximum of it's right and bottom value(`Math.max(dp[i][j+1], dp[i+1][j])`).
   
6. Repeat steps 4-5 until all the 2D array elements traversed

7. Return `dp[0][0]` next to the outer loop which indicates longest common sequence.


**Time and Space complexity:**
This algorithm has a time complexity of `O(m * n)`, where `m` is the number of elements in a first string and `n` is the number of elements in a second string. This is because we are traversing all the elements of a two-dementional array which represents possible sequences of two strings. 

Here, we will use two dimentional array datastructure to store the longest common sequence. Hence, the space complexity will be `O(m * n)`.
