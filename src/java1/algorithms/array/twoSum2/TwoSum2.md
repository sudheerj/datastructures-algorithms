**Description:**
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where `index1` must be less than `index2`.

## Example:
Input: numbers = [2,7,11,15,9], target = 16
Output: [2,5]
Explanation: The sum of 7 and 9 is 16. Therefore index1 = 2, index2 = 5.

**Algorithmic Steps:**
This problem is solved with the help of two pointer technique. The algorithmic approach can be summarized as follows: 

1. Initialize `left` and `right` pointers to `0` and last index(`length-1`) of the input array.

2. Iterate over input array and find the `total` of left and right elements each time.

3. If the total is equal to the target, return the left and right indexes incremented by one. By default, left and right variables indexed with zero where the output needs to be 1 index based.

4. If the total is greater than target, decrement the right pointer to decrease the total value as per given target.

5. If the total is less than target, increment the left pointer to increase the total value as per given target.

6. Repeat 2-5 steps until the two numbers sum is equal to the target.

7. Return `[-1, -1]` incase of no matching numbers whose sum not equal to the target.

**Time and Space complexity:**
This algorithm takes a time complexity of O(n), where n is the number of elements in an array. This is because we are traversing the array at most once. 

Here, we don't use any additional datastructure other than two constant pointer variables. Hence, the space complexity will be O(1).