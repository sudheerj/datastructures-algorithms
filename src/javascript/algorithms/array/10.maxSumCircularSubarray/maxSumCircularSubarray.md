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

#### Algorithm Overview

This problem is solved using a **dual application of Kadane’s algorithm**, a dynamic programming technique commonly used to find the maximum subarray sum in linear time.

In a circular array, the maximum subarray sum is either:

1.  The **maximum subarray sum** using the standard (non-circular) Kadane's algorithm.
2.  The **total array sum minus the minimum subarray sum** (which effectively gives the maximum sum of a wrapped subarray).

We compute both, and return the larger value.

#### Algorithm Steps

1.  **Edge Case Check**  
    If the input array is empty, return `0`.
2.  **Initialization**
    
    *   `globalMaxSum` and `globalMinSum` are both initialized to the first element of the array.
    *   `currentMaxSum` and `currentMinSum` (used during iteration) are initialized to the same value.
    *   `totalSum` is initialized to the first element of the array.
    
    > ⚠️ _Note:_ Initializing `globalMaxSum` or `globalMinSum` to 0 instead of the first element would give incorrect results for arrays with all negative numbers.
    
3.  **Traverse the Array**  
    For each element in the array (starting from the second one):
    *   Update `currentMaxSum = max(currentMaxSum + num, num)`
    *   Update `globalMaxSum = max(globalMaxSum, currentMaxSum)`
    *   Update `currentMinSum = min(currentMinSum + num, num)`
    *   Update `globalMinSum = min(globalMinSum, currentMinSum)`
    *   Accumulate `totalSum += num`
4.  **Final Result**
    *   If all elements are negative, `globalMaxSum` will be the correct answer (since `totalSum - globalMinSum` would be 0).
    *   Otherwise, return the maximum of:
        *   `globalMaxSum` (standard Kadane’s)
        *   `totalSum - globalMinSum` (circular case)

#### Time and Space Complexity

*   **Time Complexity:** `O(n)`  
    We iterate over the array exactly once.
*   **Space Complexity:** `O(1)`  
    The algorithm uses a constant amount of extra space for tracking sums.