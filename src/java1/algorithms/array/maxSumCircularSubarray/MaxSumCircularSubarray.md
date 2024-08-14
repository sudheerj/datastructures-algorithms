**Description:**
Given a circular integer array `nums` of length `n`, return the maximum possible sum of a non-empty subarray of `nums`.

### Examples
Example 1:

Input: nums = [9, -9, 6, 11, -6, -10, 15, 1]
Output: 33

Input: nums = [6,-2,6]
Output: 12

Input: nums = [-6,-2,-6]
Output: -2

**Algorithmic Steps:**

This problem is solved with the help of Kadane's algorithm(dynamic programming technique), in which one time for finding the maximum subarray sum, and another time for finding the minimum subarray sum. The algorithmic approach can be summarized as follows:

1. Add a preliminary check for empty array and return 0 as a maximum sum.

2. Initialize overall maximum and minimum sum(i.e, `globalMaxSum` and `globalMinSum`) to first value of an input array.

  **Note:** You shouldn't initialize global maximum and minimum values to zero because it results in wrong output for all negative elements usecase.

3. Initialize current maximum and minimum values(i.e, `currMaxSum` and `currMinSum`) of each iteration to zero.

4. Initialize total sum(`totalSum`) of all the elements to zero.

5. Iterate over an input array to calculate the maximum value.

6. Calculate the maximum and minimum sum at each element positon. The minimum sum is required to derive maximum value incase of circular subarray contains maximum value.

7. Find the total sum of all the numbers and store it in

8. Calculate the maximum and minimum sum found so far(`globalMaxSum` and `globalMinSum`) by comparing with current maximum and  current minimum values.

9. Repeat steps 6-8 until all the elements traversed.

10. Return maximum of global maximum Sum and difference of total sum and globalMinSum, in case there are atleast one positive element. Otherwise return global maximum sum itself.

**Time and Space complexity:**

This algorithm has a time complexity of `O(n)`, where `n` is the number of elements. This is because we iterate the array at most once. 

Here, we don't use any additional datastructure other than the few sum variables. Hence, the space complexity will be O(1).