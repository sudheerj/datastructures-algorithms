**Description:**
Given an array of integers `nums`, find the length of the longest increasing subsequence.

## Examples:
Example 1:

Input: nums = [9,7,1,4,2,6,10,12]
Output: 4

Example 2: 

Input: nums = [5,4,3,2,1]
Output: 1

**Algorithmic Steps(Approach 1&2)**
This problem is solved efficiently using **dynamic programming** approach by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

1. Create an array(`dp`) to hold the longest increasing sequence(`LHS`) for each number of input array. Initialize the array values with `1` considering the minimum possible longest sequence with each letter.
   
2. Initialize the maximum length of substring found so far(`maxLength`) with `1`.
   
3. Iterate each element from last to beginning of an input array using an index variable(`i`). Here, we are following bottom to top dynamic programming approach.

4. Add a nested loop to iterate the elements which exists next to outer index position. i.e, `j = i+ 1`

5. Compare the outer index position value with nested index position value. If the outer index position value is less than nested position value, find the maximum value between outer index position value and nested index position value incremented by one. The maximum value needs to be stored in the particular position of `LHS` array.

6. Repeat step 5 for each outer index position.
   
7. Update the maximum sequence by calculating the maximum of current maximum and longest sequence stored for each outer index position.

8. Return `maxLength` after the outer loop which indicates longest increasing sequence.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n * 2)`, where `n` is the number of elements in a given array. This is because we are traversing all the elements and finding the longest sequence for each element. 

Here, we will use array datastructure to store the longest increasing sequence for each element. Hence, the space complexity will be `O(n)`.
