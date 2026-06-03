# Koko Eating Bananas

## Problem
Koko loves to eat bananas. There are `n` piles of bananas, the `i`-th pile has `piles[i]` bananas. The guards have gone and will come back in `h` hours. Koko can decide her eating speed of `k` bananas per hour. Each hour, she chooses a pile and eats up to `k` bananas from that pile. If the pile has less than `k` bananas, she eats all of them and won't eat more bananas during that hour.

Return the minimum integer `k` such that she can eat all the bananas within `h` hours.

## Example
```
Input: piles = [3,6,7,11], h = 8
Output: 4

Input: piles = [30,11,23,4,20], h = 5
Output: 30

Input: piles = [30,11,23,4,20], h = 6
Output: 23
```

## Approach
- **Binary Search:** Search for the minimum `k` between 1 and max(piles). For each `k`, check if Koko can finish in `h` hours.
- **Brute Force:** Try every possible `k` from 1 to max(piles).

## Complexity
- Binary Search: Time $O(n \log M)$, Space $O(1)$, where $M$ is the largest pile
- Brute Force: Time $O(nM)$, Space $O(1)$

## LeetCode
- [LeetCode 875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)
