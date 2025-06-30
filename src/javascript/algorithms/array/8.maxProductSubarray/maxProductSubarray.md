**Description:**
Given an integer array `nums` that contains both positive and negative integers, find a contiguous subarray that has the largest product, and return the product.

### Examples
**Example 1:**
Input: nums = [6, 7,-4, 5, 8, ]
Output: 6

Example 2:
Input: nums = [-2, 0, -2]
Output: 0

## Algorithmic Steps

This problem is efficiently solved using a variation of **Kadane's Algorithm** tailored for products. It tracks both the **maximum** and **minimum** product ending at each position, due to the behavior of negative numbers.

1. **Initialize** three variables with the first element of the array `nums[0]`:
   - `globalMax`: Holds the maximum product found so far.
   - `currentMax`: Tracks the maximum product ending at the current index.
   - `currentMin`: Tracks the minimum product ending at the current index.

    > **Note:** We initialize all three with the first element instead of 1 or 0 to properly account for arrays with negative or single values.

2. **Iterate** over the array starting from the second element to last element:

3. If the current element `num` is negative, switch current maximum and current minimum values.

4. For each element `num`:
   - Update current maximum(`currentMax`) and current minimum(`currentMin`) values:
     - `currentMax = Math.max(currentMax * num, num)`
     - `currentMin = Math.min(currentMin * num, num)`

5. **Update** the global maximum sum `globalMax` by taking the maximum of previous global maximum and current maximum:
   - `globalMax`
   - `currentMax`  
   This ensures the highest product is captured across the entire array.

6. After the loop completes, **return** the `globalMax`, which contains the maximum product of any contiguous subarray.

## Time and Space Complexity

- **Time Complexity**: `O(n)` — We traverse the input array once.
- **Space Complexity**: `O(1)` — No extra space is used except for a few variables.
