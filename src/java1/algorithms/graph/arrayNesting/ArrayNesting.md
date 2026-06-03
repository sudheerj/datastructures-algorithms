# Array Nesting (LeetCode 565)

Given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1], return the length of the longest set S, where S[i] = {nums[i], nums[nums[i]], nums[nums[nums[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of the element nums[i], the next element in S should be nums[nums[i]], and then nums[nums[nums[i]]], and so on. By that rule, we stop adding right before a duplicate element occurs in S.

## Example

Input: nums = [5,4,0,3,1,6,2]
Output: 4
Explanation: The longest set S = {5, 6, 2, 0}, therefore answer is 4.

Input: nums = [0,1,2]
Output: 1

## Approaches

### 1. In-place Marking (O(n) time, O(1) space)
Mark visited elements by setting them to -1. For each unvisited index, traverse the cycle and count its length.

### 2. Visited Array (O(n) time, O(n) space)
Use a boolean array to track visited indices. For each unvisited index, traverse the cycle and count its length.

## Java Implementation
See [ArrayNesting.java](../../java1/algorithms/graph/arrayNesting/ArrayNesting.java)

## Python Implementation
See [arrayNesting.py](../../../../python/algorithms/array/arrayNesting.py)

## JavaScript Implementation
See [arrayNesting.js](../../../../javascript/algorithms/array/arrayNesting.js)

## Test Cases
| Input                | Output |
|----------------------|--------|
| [5,4,0,3,1,6,2]      | 4      |
| [0,1,2]              | 1      |
| [1,0,3,4,2]          | 3      |
| [2,0,1]              | 3      |
| [1,2,3,4,0]          | 5      |
| [0]                  | 1      |
| [1,2,0]              | 3      |
