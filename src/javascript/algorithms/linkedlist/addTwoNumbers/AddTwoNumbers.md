# Add Two Numbers

## Problem
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each node contains a single digit. Add the two numbers and return the sum as a linked list.

LeetCode: https://leetcode.com/problems/add-two-numbers/

---

## Approach — Iterative with carry

Traverse both lists simultaneously, summing digits and propagating carry. Use a dummy head node to simplify result list construction.

**TC: O(max(m, n)) — SC: O(max(m, n))**

---

## Steps

1. Create a `dummy` head and a `curr` pointer.
2. Initialise `carry = 0`.
3. While either list has nodes remaining **or** carry is non-zero:
   - Read `v1` from `l1` (0 if exhausted), `v2` from `l2`.
   - Compute `v = v1 + v2 + carry`.
   - `carry = Math.floor(v / 10)`, new digit = `v % 10`.
   - Append new node with digit to result.
   - Advance `l1`, `l2`, `curr`.
4. Return `dummy.next`.

---

## Example

```
l1: 2 → 4 → 3   (represents 342)
l2: 5 → 6 → 4   (represents 465)

Step 1: 2+5+0=7  carry=0  → node(7)
Step 2: 4+6+0=10 carry=1  → node(0)
Step 3: 3+4+1=8  carry=0  → node(8)

Result: 7 → 0 → 8  (represents 807) ✓
```

---

## Test Cases

| l1 (reversed)   | l2 (reversed) | result (reversed) | actual sum            |
| --------------- | ------------- | ----------------- | --------------------- |
| [2, 4, 3]       | [5, 6, 4]     | [7, 0, 8]         | 342 + 465 = 807       |
| [0]             | [0]           | [0]               | 0 + 0 = 0             |
| [9,9,9,9,9,9,9] | [9,9,9,9]     | [8,9,9,9,0,0,0,1] | 9999999+9999=10009998 |
| [5]             | [5]           | [0, 1]            | 5 + 5 = 10            |
| [9, 9]          | [1]           | [0, 0, 1]         | 99 + 1 = 100          |

### Walkthrough — `[9,9,9,9,9,9,9]` + `[9,9,9,9]`

```
9+9+0=18  carry=1 → 8
9+9+1=19  carry=1 → 9
9+9+1=19  carry=1 → 9
9+9+1=19  carry=1 → 9
9+0+1=10  carry=1 → 0
9+0+1=10  carry=1 → 0
9+0+1=10  carry=1 → 0
0+0+1=1   carry=0 → 1

Result: [8, 9, 9, 9, 0, 0, 0, 1]  (represents 10009998) ✓
```

---

## Complexity

|           | Time         | Space        |
| --------- | ------------ | ------------ |
| Iterative | O(max(m, n)) | O(max(m, n)) |

> `m` = length of l1, `n` = length of l2
