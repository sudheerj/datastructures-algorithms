**Problem statement:**
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

You must write an algorithm that runs in `O(n)` time and without using the division operation.

### Examples:

Example 1:
Input: nums = [1, 2, 3, 4, 5]
Output: [120,60,40,30,24]

Example 2:
Input: nums = [-3, 3, 2, 0, -4]
Output: [0,0,0,72,0]


**Algorithmic Steps:**

This problem is solved with the help of **prefix and postfix pattern** which includes elements multiplication. The algorithmic approach can be summarized as follows:

1. Initialize an empty `result` array variable to store the elements products at each index position. 

2. Initialize `prefix` and `postfix` variables to 1, which are used to keep track on the product of the elements to the left and right of the current element.

3. Iterate over the input array to find the prefix for each element. At first, assign the current prefix to result element and then update the prefix value by multiplying with current element.

4. Iterate over the input array again but in the backward direction to find the postfix value for each element. In this case, you need to multiply the current postfix with a previously calculated result element. This is needed to hold the previous prefix values of a result element. Thereafter, you can update the postfix value by multiplying with current element.

5. Return `result` which contains the product of all elements other than current element.


**Time and Space complexity:**

This algorithm has a time complexity of `O(n)(O(n) + O(n))`, where `n` is the number of elements. This is because two separate for-loops which runs the array at most once. 

Here, we don't use any additional datastructure other than the output array(excluded as per requirement). Hence, the space complexity will be O(1).