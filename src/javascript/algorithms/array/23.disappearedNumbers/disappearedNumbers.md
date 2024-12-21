**Description:**
Given an integer array `nums` of length `n` where `nums[i]` is in the range `[1, n]`,  find an array of all the integers in the range(`[1,n]`) that do not appear in given `nums` array. 

**Note:** The solution needs to be done without an extra space.

### Examples
Example 1:

Input: nums = [6, 3, 1, 5, 3, 7, 5]
Output: [2,4]

Example 2:

Input: nums = [1,1],
Output: [2]

**Algorithmic Steps**
This problem is solved with the help of array traversal and marking the available numbers. The algorithmic approach can be summarized as follows:

1. Create a function named `findDisappearedNumbers`, which accepts input array(`nums`) to find the disppeared numbers.
   
2. Iterate over given array(`num`), fetch the respective index(0 based) for absolute current value. If the number at the index position is positive, mark the number by negating it.

3. Define an empty missing numbers array(`missingNumbers`).
   
4. Iterate over the input array again, add the next index position as missing number(`i+1`) to missing numbers array.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements in an array. This is because we need to iterate over all the elements at most twice for finding the missing numbers.
 
It takes constant time complexity of `O(1)` due to no additional datastructure been used other than output array(not considered as extra memory).