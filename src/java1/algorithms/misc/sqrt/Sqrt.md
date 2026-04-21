# Sqrt (Square Root) Algorithm

This folder contains implementations for finding the integer square root of a non-negative integer (i.e., the greatest integer less than or equal to the true square root).

## Problem
Given a non-negative integer `num`, compute and return the integer square root of `num`.

## Java Implementation
- `sqrt1(int num)`: Uses binary search to find the integer square root.
- `sqrt2(int num)`: Uses a linear scan to find the integer square root.

## Example Test Cases

| Input | Expected Output | Notes                |
|-------|----------------|----------------------|
| 0     | 0              | Edge case            |
| 1     | 1              | Edge case            |
| 4     | 2              | Perfect square       |
| 8     | 2              | Not a perfect square |
| 9     | 3              | Perfect square       |
| 15    | 3              | Not a perfect square |
| 16    | 4              | Perfect square       |
| 25    | 5              | Perfect square       |
| 26    | 5              | Not a perfect square |
| 100   | 10             | Large perfect square |
| 101   | 10             | Large not perfect    |

## Approach
- **Binary Search:** Efficient for large numbers, repeatedly narrows the search range.
- **Linear Scan:** Simple, but less efficient for large numbers.

## Complexity
- Binary Search: O(log n)
- Linear Scan: O(√n)
