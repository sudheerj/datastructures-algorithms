# Russian Doll Envelopes

## Problem
Given a list of envelopes with widths and heights, find the maximum number of envelopes you can Russian doll (put one inside another). An envelope can fit into another if and only if both the width and height of one envelope is greater than the other.

## Approach
- Sort envelopes by width ascending, and by height descending for equal widths.
- Find the Longest Increasing Subsequence (LIS) of heights using binary search (patience sorting).
- The length of the LIS is the answer.
- **Time Complexity:** O(n log n)
- **Space Complexity:** O(n)

## Test Cases
| envelopes                                   | Output | Explanation                                  |
|---------------------------------------------|--------|----------------------------------------------|
| [[5,4],[6,4],[6,7],[2,3]]                   | 3      | [[2,3],[5,4],[6,7]]                          |
| [[1,1],[1,1],[1,1]]                         | 1      | Only one envelope can be used                |
| [[4,5],[4,6],[6,7],[2,3],[1,1]]             | 4      | [[1,1],[2,3],[4,6],[6,7]]                    |
| [[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]] | 5 | [[2,100],[3,200],[4,300],[5,400],[6,370],[7,380]] |
| [[1,3],[3,5],[6,7],[6,8],[8,4],[9,5]]       | 3      | [[1,3],[3,5],[6,7]] or [[1,3],[3,5],[6,8]]   |

## Code Links
- [Java](RussianDollEnvelopes.java)
- [Python](../../../../python/algorithms/dynamicProgramming/longest_increasing_sequence/russian_doll_envelopes.py)
- [JavaScript](../../../../javascript/algorithms/dynamicProgramming/longestIncreasingSequence/russianDollEnvelopes.js)
