# Count Number of Teams

## Problem
Given an array rating, count the number of teams of 3 soldiers (i, j, k) with 0 <= i < j < k < n such that either:
- rating[i] < rating[j] < rating[k] (increasing)
- rating[i] > rating[j] > rating[k] (decreasing)

## Approach
- For each index j, count how many elements to the left are less/greater and how many to the right are greater/less, then sum the products for all j.
- **Time Complexity:** O(n^2)
- **Space Complexity:** O(1)

## Test Cases
| rating                | Output | Explanation                |
|-----------------------|--------|----------------------------|
| [2, 5, 3, 4, 1]       | 3      | (2,3,1), (2,4,1), (5,3,1)  |
| [2, 1, 3]             | 0      |                            |
| [1, 2, 3, 4]          | 4      | all increasing triplets     |
| [4, 3, 2, 1]          | 4      | all decreasing triplets     |
| [1, 3, 2, 4, 5]       | 5      |                            |
| [1, 2, 3, 2, 1]       | 6      |                            |
| [1, 1, 1, 1]          | 0      |                            |
| [1, 2, 1, 2, 1, 2]    | 0      |                            |

## Code Links
- [Java](CountNumberOfTeams.java)
- [Python](../../../../python/algorithms/array/count_number_of_teams.py)
- [JavaScript](../../../../javascript/algorithms/array/countNumberOfTeams.js)
