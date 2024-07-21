**Problem statement:**
Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

## Examples:
Example 1:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Example 2: 

Input: nums = [1,2,3,4, 5]
Output: false

**Algorithmic Steps(Approach 1&2)**
This problem is solved with an optimal solution using either set or map to find out duplicate elements exists or not. The algorithmic approach can be summarized as follows: 

1. Create an empty set or map to store the elements.

2. Iterate an input array using for-each loop.

3. If the current element appears in a set or map, return `true` immediately to indicate duplicate elements exist.

4. Otherwise add the current element to the set or map.

5. After the for loop, return `false` to indicate there are no duplicate elements exist in the array.


**Time and Space complexity:**
This algorithm has a time complexity of O(n), where n is the number of elements in an array. This is because we are traversing the array at most once. 

Here, we use any additional datastructure like set or map. Hence, the space complexity will be O(n).
