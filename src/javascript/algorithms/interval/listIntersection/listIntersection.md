# listIntersection.js

Given two lists of closed intervals, each list pairwise disjoint and sorted, return the intersection of the two interval lists.

## Steps
1. Use two pointers `i` and `j`, one for each list.
2. Find the overlap: `start = max(firstStart, secondStart)`, `end = min(firstEnd, secondEnd)`.
3. If `start <= end`, a valid intersection exists — add `[start, end]` to the result.
4. Move the pointer whose interval ends first (it cannot contribute to further intersections).
5. Repeat until one list is exhausted.

## Example

**Input:**  
firstList = [[0,2],[5,10]], secondList = [[1,5],[8,12]]  
**Output:** [[1,2],[5,5],[8,10]]

## Test Cases

| firstList                         | secondList                        | Output                                    |
|-----------------------------------|-----------------------------------|-------------------------------------------|
| [[0,2],[5,10],[13,23],[24,25]]    | [[1,5],[8,12],[15,24],[25,26]]    | [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]] |
| [[0,2],[5,10]]                    | [[1,5],[8,12]]                    | [[1,2],[5,5],[8,10]]                      |
| [[0,2],[5,7]]                     | [[3,4],[8,10]]                    | []                                        |
| [[0,5]]                           | []                                | []                                        |
| [[1,10]]                          | [[2,3],[4,6]]                     | [[2,3],[4,6]]                             |
| [[1,5]]                           | [[1,5]]                           | [[1,5]]                                   |

## Complexity
- Time: O(n + m)
- Space: O(1) excluding result
