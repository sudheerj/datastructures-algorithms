**Description:**
Given an array `nums` of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.

## Problem Statement:
You are given an array of integers. Return the maximum sum you can obtain such that the sum is divisible by 3. You can choose any subset of the elements to maximize the sum, as long as the final sum is divisible by 3.

## Examples:

**Example 1:**
```python
Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
```

**Example 2:**
```python
Input: nums = [4]
Output: 0
Explanation: Since 4 is not divisible by 3, do not pick any number.
```

**Example 3:**
```python
Input: nums = [1,2,3,4,4]
Output: 12
Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
```

**Example 4:**
```python
Input: nums = [2,6,2,2,7]
Output: 15
Explanation: Pick numbers 6, 2, and 7. Their sum is 15.
```

**Example 5:**
```python
Input: nums = [5,3,1,2]
Output: 9
Explanation: Pick numbers 5, 3, and 1. Their sum is 9.
```

## Algorithmic Steps (Dynamic Programming Approach)

This problem is solved efficiently using **Dynamic Programming** by tracking the maximum sum for each possible remainder when divided by 3. The key insight is that we only need to track three states: remainders 0, 1, and 2.

1. **Initialize a DP list**: Create a list `dp` of size 3 where:
   - `dp[0]` stores the maximum sum that gives remainder 0 when divided by 3 (i.e., divisible by 3)
   - `dp[1]` stores the maximum sum that gives remainder 1 when divided by 3
   - `dp[2]` stores the maximum sum that gives remainder 2 when divided by 3

2. **Process each number**: For each number in the input array:
   - Create a snapshot of the current `dp` state using list slicing (to avoid overwriting during iteration)
   - For each existing sum in the snapshot:
     - Calculate the new sum by adding the current number
     - Calculate the remainder of the new sum when divided by 3
     - Update `dp[remainder]` with the maximum of its current value and the new sum

3. **Return the result**: After processing all numbers, `dp[0]` contains the maximum sum divisible by 3.

## Key Insights:

- **Remainder tracking**: By tracking sums based on their remainder when divided by 3, we ensure that we always know the best sum for each remainder state.
- **State transition**: When we add a number to an existing sum, the new remainder is `(old_sum + num) % 3`.
- **Space efficiency**: We only need to track 3 values (one for each possible remainder), making this a space-efficient solution.

## Why it works:

When two numbers are added, their combined remainder modulo 3 is:
```python
(a + b) % 3 == ((a % 3) + (b % 3)) % 3
```

This property allows us to build up sums efficiently by tracking only the remainder states.

## Time and Space Complexity:

**Time Complexity:** `O(n)` where `n` is the length of the input array.
- We iterate through each number once
- For each number, we perform a constant-time operation (checking 3 states)
- Overall: O(n × 3) = O(n)

**Space Complexity:** `O(1)` 
- We only use a fixed-size list of 3 elements regardless of input size
- The temporary snapshot list is also of size 3

## Constraints:
- 1 ≤ len(nums) ≤ 4 × 10⁴
- 1 ≤ nums[i] ≤ 10⁴

## Running the tests:
```bash
python greatest_sum_divisible_by_three.py
```
