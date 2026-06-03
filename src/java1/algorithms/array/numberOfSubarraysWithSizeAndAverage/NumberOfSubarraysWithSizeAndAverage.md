# Number of Sub-arrays of Size K and Average ≥ Threshold

## Problem
Given an array of integers `nums`, an integer `k`, and an integer `threshold`, return the number of contiguous subarrays of size `k` whose average is greater than or equal to `threshold`.

## Approach
- Use a sliding window of size `k` to maintain the sum of the current window.
- For each window, check if the sum is at least `k * threshold` (to avoid floating point division).
- Increment the count if the condition is met.
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Test Cases
| nums                        | k | threshold | Output | Explanation                |
|-----------------------------|---|-----------|--------|----------------------------|
| [2,2,2,2,5,5,5,8]           | 3 | 4         | 3      | [5,5,5], [5,5,8], [2,5,5]  |
| [1,1,1,1,1,1,1,1]           | 4 | 2         | 0      |                            |
| [11,13,17,23,29,31,7,5,2,3] | 3 | 20        | 6      |                            |
| [7,7,7,7,7,7,7]             | 3 | 7         | 5      | all windows                |
| [1,2,3,4,5,6,7,8,9]         | 2 | 8         | 4      | [8,9], [7,8], [6,7], [5,6] |
| [5,5,5,5,5]                 | 1 | 5         | 5      | all elements               |
| [1,2,3,1,2,3,1,2,3]         | 3 | 4         | 0      |                            |
| [10,9,8,7,6,5,4,3,2,1]      | 5 | 7         | 2      | [10,9,8,7,6], [9,8,7,6,5]  |

## Code Links
- [Java](NumberOfSubarraysWithSizeAndAverage.java)
- [Python](../../../../python/algorithms/array/number_of_subarrays_with_size_and_average.py)
- [JavaScript](../../../../javascript/algorithms/array/numberOfSubarraysWithSizeAndAverage.js)
