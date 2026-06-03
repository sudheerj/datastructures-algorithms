# Max Area of Island

## Problem
Given a 2D grid of 0's (water) and 1's (land), return the area of the largest island in the grid. An island is a group of 1's connected 4-directionally (horizontal or vertical).

## Example
```
Input: grid = [
  [0,0,1,0,0,0,0,1,0,0,0,0,0],
  [0,0,0,0,0,0,0,1,1,1,0,0,0],
  [0,1,1,0,1,0,0,0,0,0,0,0,0],
  [0,1,0,0,1,1,0,0,1,0,1,0,0],
  [0,1,0,0,1,1,0,0,1,1,1,0,0],
  [0,0,0,0,0,0,0,0,0,0,1,0,0]
]
Output: 6

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
```

## Approach
- **DFS:** For each cell, if it's land, run DFS to count the area and mark visited.
- **BFS:** For each cell, if it's land, run BFS to count the area and mark visited.

## Complexity
- Time: $O(mn)$ for both DFS and BFS
- Space: $O(mn)$ for visited/recursion/queue

## LeetCode
- [LeetCode 695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/)
