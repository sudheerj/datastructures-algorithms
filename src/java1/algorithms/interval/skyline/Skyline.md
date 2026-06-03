# Skyline Problem (The Skyline Problem, LC 218)

## Problem Statement
Given a list of buildings in the cityscape, return the skyline formed by these buildings. Each building is represented by a triplet [left, right, height], where:
- left: x-coordinate of the left edge
- right: x-coordinate of the right edge
- height: height of the building

The skyline is a list of "key points" [x, height] where the height changes.

## Example
**Input:**
```
buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
```
**Output:**
```
[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
```

## Algorithm Steps
1. Convert each building into two events: start and end.
2. Sort all events by x-coordinate, breaking ties by height.
3. Use a multiset (TreeMap or PriorityQueue) to track current heights.
4. For each event, update the multiset and record a key point if the max height changes.

## Complexity
| Approach         | Time Complexity | Space Complexity |
|------------------|----------------|-----------------|
| Sweep-line + TreeMap | O(n log n)      | O(n)            |
| Sweep-line + PQ      | O(n^2) worst    | O(n)            |

## Test Cases
| Input | Output |
|-------|--------|
| [[1,2,1]] | [[1,1],[2,0]] |
| [[0,2,3],[2,5,3]] | [[0,3],[5,0]] |
| [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]] | [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]] |
| [[1,3,4],[3,4,4],[2,6,2]] | [[1,4],[4,2],[6,0]] |

## References
- LeetCode 218: https://leetcode.com/problems/the-skyline-problem/