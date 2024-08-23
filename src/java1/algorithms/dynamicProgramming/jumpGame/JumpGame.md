**Description:**
Given an integer array `nums` where each element `nums[i]` indicates your maximum jump length at that position. Return `true` if you can reach the last position starting from first position, or `false` otherwise.

**Note:** If the jump value is 0, then you cannot move forward from that position.

## Examples:
Example 1:

Input: nums = [3,2,1,1,4]
Output: true

Example 2: 

Input: nums = [3,2,1,0,5]
Output: false

**Algorithmic Steps(Approach 1&2)**
This problem is solved efficiently using **Dynamic programming** approach by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

1. Calculate the length of input array `nums` in a variable `length`.
   
2. Add base case conditions by returning `true` if the length of the array is one and return `false` if the first character is zero when there are more than one character. This is because if the length is one, you already reached the destination. Also, there is no way to reach the destionation if the first character is zero.

3. Initialize an array(`dp`) with the same length of an input array. By default, all values are assigned to `false`. However, the first value is initialized to `true` because you can reach the destination without any jumps.
   
4. Iterate over all the elements starting from second position to last position using index variable `i`.
   
5. For each iteration `i`, 
    1. Iterate over all the elements using index variable `j` until before the outer index varaible(`i`) .
        1. For each iteration `j`, update the jump status for index `i` to true when the jump status on index `j` is `true` and sum of index position and it's value greater than or equal to outer index variable.
        2. Exit from the nested iteration once the previous step conditions are statified. i.e, You can able to jump to specific position of the outer index.
   
6. Repeat step5 until all the last element.
7. Return the jump status of last index position(`dp[length-1]`) which indicates whether you can jump to end or not.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n ^ 2)`, where `n` is the number of elements. This is because we need to traverse each element and find the jump status from the starting position. 

Here, we are using `dp` array to store the jump status for each element. Hence, the space complexity will be `O(n)`.
