# Find the Smallest Divisor Given a Threshold

## Problem
Given an array of integers `nums` and an integer `threshold`, choose a positive integer divisor, divide all the array by it, and sum the division's ceiling values. Find the smallest divisor such that the result is less than or equal to `threshold`.

Each result of the division is rounded to the nearest integer greater than or equal to that element (`ceil`).

LeetCode: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

---

## Approaches

### 1. Binary Search — O(n log m)
Binary search on the answer space `[1, max(nums)]`. For each candidate divisor, compute the ceiling sum and narrow the range.

### 2. Linear Scan (Brute Force) — O(n * m)
Try every divisor from `1` to `max(nums)` and return the first one whose ceiling sum ≤ threshold.

---

## Steps (Binary Search)

1. Set `left = 1`, `right = max(nums)`.
2. While `left <= right`:
   - Compute `divisor = left + (right - left) / 2`.
   - Compute `sum = Σ ceil(num / divisor)` for each `num`.
   - If `sum <= threshold`, record divisor and search left: `right = divisor - 1`.
   - Else search right: `left = divisor + 1`.
3. Return `left`.

> `ceil(a / b)` without floating point: `(a + b - 1) / b` (integer arithmetic)

---

## Example

```
nums = [1, 2, 5, 9], threshold = 6

Binary search space: [1, 9]

divisor = 5 → ceil(1/5)+ceil(2/5)+ceil(5/5)+ceil(9/5) = 1+1+1+2 = 5 ≤ 6 → right = 4
divisor = 2 → ceil(1/2)+ceil(2/2)+ceil(5/2)+ceil(9/2) = 1+1+3+5 = 10 > 6 → left = 3
divisor = 3 → ceil(1/3)+ceil(2/3)+ceil(5/3)+ceil(9/3) = 1+1+2+3 = 7 > 6 → left = 4
divisor = 4 → ceil(1/4)+ceil(2/4)+ceil(5/4)+ceil(9/4) = 1+1+2+3 = 7 > 6 → left = 5

left (5) > right (4) → return 5
```

---

## Test Cases

| nums                | threshold | output  | notes                            |
| ------------------- | --------- | ------- | -------------------------------- |
| [1, 2, 5, 9]        | 6         | 5       | LeetCode example 1               |
| [2, 3, 5, 7, 11]    | 11        | 3       | LeetCode example 2               |
| [19]                | 5         | 4       | single element: ceil(19/4)=5     |
| [1, 2, 3]           | 6         | 1       | divisor=1 already satisfies      |
| [44, 22, 33, 11, 1] | 5         | 44      | needs maximum element as divisor |
| [1]                 | 1         | 1       | smallest possible input          |
| [1000000]           | 1         | 1000000 | max value edge case              |

### Walkthrough — `nums = [2, 3, 5, 7, 11]`, `threshold = 11`

```
Search space: [1, 11]

divisor = 6  → 1+1+1+2+2 = 7  ≤ 11 → right = 5
divisor = 3  → 1+1+2+3+4 = 11 ≤ 11 → right = 2
divisor = 1  → 2+3+5+7+11= 28 > 11 → left = 2
divisor = 2  → 1+2+3+4+6 = 16 > 11 → left = 3

left (3) > right (2) → return 3
```

### Walkthrough — `nums = [19]`, `threshold = 5`

```
Search space: [1, 19]

divisor = 10 → ceil(19/10) = 2 ≤ 5 → right = 9
divisor = 5  → ceil(19/5)  = 4 ≤ 5 → right = 4
divisor = 2  → ceil(19/2)  = 10 > 5 → left = 3
divisor = 3  → ceil(19/3)  = 7  > 5 → left = 4
divisor = 4  → ceil(19/4)  = 5  ≤ 5 → right = 3

left (4) > right (3) → return 4
```

---

## Complexity

|               | Time       | Space |
| ------------- | ---------- | ----- |
| Binary Search | O(n log m) | O(1)  |
| Brute Force   | O(n * m)   | O(1)  |

> `n` = length of nums, `m` = max element in nums
