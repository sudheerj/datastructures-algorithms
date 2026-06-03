# Minimum Increment to Make Array Unique

Given an array of integers, increment elements as needed so that every element is unique. Return the minimum number of increments required.

## Problem
Given an integer array `nums`, return the minimum number of increments to make every value in `nums` unique.

## Approach
- **Sorting + Greedy:** Sort the array, increment duplicates to the next available value.
- **Counting/Bucket:** Use a frequency map and propagate extra counts forward.
- Time: O(n log n) for sorting, O(n + R) for counting (R = max + n)
- Space: O(1) for sorting, O(R) for counting

## Java Implementation
See [MinIncrementForUnique.java](MinIncrementForUnique.java)

## Python Implementation
See [min_increment_for_unique.py](../../../../python/algorithms/array/min_increment_for_unique.py)

## JavaScript Implementation
See [minIncrementForUnique.js](../../../../javascript/algorithms/array/minIncrementForUnique.js)

## Example Test Cases
| nums                  | Output |
|-----------------------|--------|
| [1,2,2]               | 1      |
| [3,2,1,2,1,7]         | 6      |
| [0,2,2,2,3,7]         | 8      |
| [1,1,1,1]             | 6      |
| [0,0,0,0,0]           | 10     |
| [1,2,3]               | 0      |
| [2,2,2,2,2,2,2]       | 21     |
| [100,100,100]         | 3      |

## Test Output
All operations should match the expected output above.
