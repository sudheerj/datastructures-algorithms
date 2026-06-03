# NumPairsDivisibleBy60

## Problem
Given a list of song durations, return the number of pairs of songs for which the total duration in seconds is divisible by 60.

## Approach
- **Remainder Hashing:** For each song, count how many previous songs have a remainder that complements the current song's remainder to 60.
- **Time Complexity:** O(n)
- **Space Complexity:** O(1) (since remainder is always in [0,59])

## Test Cases
| time                        | Output | Explanation                |
|-----------------------------|--------|----------------------------|
| [30, 20, 150, 100, 40]      | 3      | (30,150), (20,40), (100,20) |
| [60, 60, 60]                | 3      | (0,1), (0,2), (1,2)         |
| [10, 50, 90, 30]            | 2      | (10,50), (90,30)            |
| [1, 2, 3, 4, 5, 6]          | 0      |                            |
| [60, 120, 180]              | 3      | (0,1), (0,2), (1,2)         |
| [20, 40, 60, 80, 100, 120]  | 7      |                            |

## Code Links
- [Java](NumPairsDivisibleBy60.java)
- [Python](../../../../python/algorithms/array/num_pairs_divisible_by_60.py)
- [JavaScript](../../../../javascript/algorithms/array/numPairsDivisibleBy60.js)
