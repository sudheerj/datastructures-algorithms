**Description:**
Given an integer array `nums`, find the sum of the elements of `nums` between indices `left` and `right` inclusive where `left <= right`. 

**Note:** The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right. If the index is on the left edge of an array, the left sum becomes `0` because there are no left elements. It also applies to the right edge of an array. Return -1, if no such index found.

### Examples
Example 1:

Input: nums = [6, -3, 1, 5, 3, 7, -5], left=0 right=3
Output: 9

Example 2:

Input: nums = [6, -3, 1, 5, 3, 7, -5], left=2 right=6
Output: 11

Example 3:

Input: nums = [6, -3, 1, 5, 3, 7, -5], left=0 right=6
Output: 14

**Algorithmic Steps**
This problem is solved with the help of array traversal and finding sum of the elements. The algorithmic approach can be summarized as follows:

1. Define a prefix sum variable(`prefixSum`) to calculate the sum of all elements with in a given array range.

2. The given input array needs to be iterated and store the prefix sum of each index position to avoid recomputing the sum for each given range.

3. Create a `sumRange` function/method to calculate the sum of elements with in given range. This is derived by substracting the left sum from right sum.
   
4. Invoke sumRange function with given `left` and `right` indices to find the sum of elements.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements in an array. This is because we need to iterate over all the elements at most once for constructing the prefix sum array.
 
It takes constant time complexity of `O(1)` due to no additional datastructure been used other than prefix sum variable.