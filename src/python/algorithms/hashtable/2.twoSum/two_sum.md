**Problem statement:**
Given an array of integers `nums` and an integer `target`, return the two indices `i` and `j` such that `nums[i] + nums[j] == target` and `i != j`.

**Note:** You may assume that each input has exactly one pair of indices `i` and `j` that satisfy the two sum conditions. Return the indices pair in any order.

## Examples:
Example 1:

Input: nums = [3, 4, 9, 14], target=12
Output: [0, 2]

Example 2: 

Input: nums = [5, 7, 4, 7], target=14
Output: [1, 3]

Example 3: 

Input: nums = [7, 1, 13, 1], target=10
Output: []

Example 4: 

Input: nums = [-5, -4, -3, -1, -2], target=-10
Output: []

**Algorithmic Steps**
This problem is solved in a one pass with the help of dictionary data structure. The algorithmic approach can be summarized as follows:


1. Add a preliminary check to verify the length of input array and return an empty array if the length is less than 2.

2. Initialize an index dictionary (i.e, `index_map`) to store the current iteration number as key and index as value.

3. Iterate over the input array using index pointer until the end of the array. 

4. Find the complement by subtracting the target and current number. If the complement already exists in the dictionary, return the indices of complement and current number as output.

5. If the complement doesn't exist in our index_map, just add the current number and its index to the dictionary.

6. Repeat steps 4–5 until there are indices present to meet the target or the index pointer reaches the end of the array.

7. Return an empty array if there are no indices present in an array.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)` because we are traversing the array only once. Remember that checking an element existence in a dictionary or adding an element to a dictionary takes a constant time (i.e, `O(1)`).

Also, it requires space complexity of `O(n)` because we are using dictionary data structure. In the worst case, when there are no indices, you need to insert all the elements of an array into dictionary.
