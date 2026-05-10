# Palindrome Linked List

## Problem
Given the `head` of a singly linked list, return `true` if it is a palindrome, or `false` otherwise.

LeetCode: https://leetcode.com/problems/palindrome-linked-list/

---

## Approach

**Two-pointer + in-place reverse — O(n) time, O(1) space**

1. Find the middle of the list using slow/fast pointers.
2. Reverse the second half in-place.
3. Compare the first half (starting at `head`) with the reversed second half.

---

## Steps

1. Move `slow` one step and `fast` two steps at a time until `fast` reaches the end → `slow` is at the middle.
2. Reverse the list from `slow` onward; `prev` becomes the new head of the reversed half.
3. Walk `left = head` and `right = prev` together — if any values differ, return `false`.
4. Return `true` if all values matched.

---

## Example

```
Input: 1 → 2 → 2 → 1

Step 1 — find middle:
  slow/fast start at 1
  Iteration 1: slow=2, fast=2
  Iteration 2: slow=2, fast=null  → stop, slow=2 (second half)

Step 2 — reverse second half (2 → 1):
  prev=null
  slow=2: temp=1, slow.next=null, prev=2, slow=1
  slow=1: temp=null, 1.next=2, prev=1, slow=null
  reversed: 1 → 2

Step 3 — compare:
  left=1 right=1  ✓
  left=2 right=2  ✓

Result: true
```

---

## Test Cases

| input           | output | notes                  |
|-----------------|--------|------------------------|
| [1,2,2,1]       | true   | even-length palindrome |
| [1,2,3,2,1]     | true   | odd-length palindrome  |
| [7]             | true   | single node            |
| [5,5]           | true   | two equal nodes        |
| [1,2]           | false  | two different nodes    |
| [1,2,3,4,5]     | false  | longer non-palindrome  |

---

## Complexity

| | Time | Space |
|-|------|-------|
| Slow/Fast + reverse | O(n) | O(1) |
