# Palindrome Linked List

## Problem
Given the `head` of a singly linked list, return `True` if it is a palindrome, or `False` otherwise.

LeetCode: https://leetcode.com/problems/palindrome-linked-list/

---

## Approach

**Two-pointer + in-place reverse — O(n) time, O(1) space**

1. Find the middle of the list using slow/fast pointers.
2. Reverse the second half in-place.
3. Compare the first half with the reversed second half.

---

## Steps

1. Move `slow` one step and `fast` two steps → `slow` lands at the middle.
2. Reverse from `slow` onward; `prev` becomes the reversed half's head.
3. Walk `left = head` and `right = prev` — if any values differ, return `False`.
4. Return `True`.

---

## Example

```
Input: 1 → 2 → 2 → 1

Middle: slow = 2 (index 2)

Reverse second half: 1 → 2

Compare:
  left=1 right=1  ✓
  left=2 right=2  ✓

Result: True
```

---

## Test Cases

| input           | output | notes                  |
|-----------------|--------|------------------------|
| [1,2,2,1]       | True   | even-length palindrome |
| [1,2,3,2,1]     | True   | odd-length palindrome  |
| [7]             | True   | single node            |
| [5,5]           | True   | two equal nodes        |
| [1,2]           | False  | two different nodes    |
| [1,2,3,4,5]     | False  | longer non-palindrome  |

---

## Complexity

| | Time | Space |
|-|------|-------|
| Slow/Fast + reverse | O(n) | O(1) |
