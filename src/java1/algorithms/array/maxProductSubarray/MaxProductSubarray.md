**Description:**
Given an integer array `nums` that contains both positive and negative integers, find a contiguous subarray that has the largest product, and return the product.

### Examples
**Example 1:**
Input: nums = [6, 7,-4, 5, 8, ]
Output: 6

Example 2:
Input: nums = [-2,0,-2]
Output: 0

**Algorithmic Steps:**

This problem is solved with the help of Kadane's algorithm(dynamic programming technique). The algorithmic approach can be summarized as follows:

1. Initialize the maximum product subarray(`result`) with a first number. 

 **Note:** It is not suggested to assign the value to either 0 or 1 because the maximum value can be less than or equal to 0.

2. Initialize two variables named `currentMax` and `currentMin` to `1`. They are used to keep track of the running maximum and minimum products.

3. Iterate over the entire input array using for-each loop

4. Find the temporary maximum and minimum products for each current element.

5. Calculate the maximum value between maximum and minimum values of step4, and this calculated maximum result needs to be compared with current element to find the final current maximum product.

  **Note:** Since an array contain both positive and negative integers, the product of current element with minimum product calculated so far may result into maximum value. That is the reason why we took maximum of current maximum and current minimum proucts.

6. Calculate the minimum value between maximum and minimum values of step4, and this calculated minimum result needs to be compared with current element to find the final current minimum product. This current minimum product is useful to calculate the maximum value for the next iteration.

7. Update the global maximum product by taking the maximum of current maximum product and global maximum product of previous iteration.

8. Return the global maximum `result` after the end of for-each iteration.

**Time and Space complexity:**

This algorithm has a time complexity of `O(n)`, where `n` is the number of elements. This is because we iterate the array at most once. 

Here, we don't use any additional datastructure other than the two sum variables. Hence, the space complexity will be O(1).