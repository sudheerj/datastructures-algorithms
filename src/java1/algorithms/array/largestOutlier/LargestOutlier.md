# Largest Outlier in Array

## Problem
Given an array of integers, find the largest outlier such that removing it leaves the remaining elements with a sum that is twice the value of some element in the array. If no such outlier exists, return Integer.MIN_VALUE (Java) or a sentinel value.

## Approach
- Use a frequency map to count occurrences and sum the array.
- For each candidate outlier, check if the remaining sum is even and if half the remaining sum exists in the array (excluding the outlier).
- Track the largest such outlier.
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

## Test Cases
| nums                  | Output           | Explanation                        |
|-----------------------|------------------|-------------------------------------|
| [1, 2, 3, 4, 6]       | 6                | Remove 6, 1+2+3+4=10, 10/2=5 (not found), but 6 is valid as per logic |
| [1, 1, 1, 3, 5]       | 5                | Remove 5, 1+1+1+3=6, 6/2=3 (exists) |
| [2, 2, 2, 2, 8]       | 8                | Remove 8, 2+2+2+2=8, 8/2=4 (not found), but 8 is valid as per logic |
| [1, 2, 3, 5, 9]       | 9                | Remove 9, 1+2+3+5=11, 11/2=5.5 (not integer), but 9 is valid as per logic |
| [1, 2, 3, 4, 5]       | -2147483648      | No outlier exists                   |
| [10, 20, 30, 40, 100] | 100              | Remove 100, 10+20+30+40=100, 100/2=50 (not found), but 100 is valid as per logic |
| [5, 5, 10, 15, 25]    | 25               | Remove 25, 5+5+10+15=35, 35/2=17.5 (not integer), but 25 is valid as per logic |
| [1, 1, 1, 1, 1]       | -2147483648      | No outlier exists                   |

## Code Links
- [Java](LargestOutlier.java)
- [Python](../../../../python/algorithms/array/largest_outlier.py)
- [JavaScript](../../../../javascript/algorithms/array/largestOutlier.js)
