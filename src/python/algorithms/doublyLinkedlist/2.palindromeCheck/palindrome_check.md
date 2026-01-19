# **Palindrome Check**

## **Problem Statement**
Check if a doubly linked list is a palindrome.

---

## **Examples**

### Example 1:
- **Input**: `[1, 2, 3, 2, 1]`
- **Output**: `true`

### Example 2:
- **Input**: `[1, 2, 3, 4, 5]`
- **Output**: `false`

---

## **Algorithmic Approach**

Leverage doubly linked list's bidirectional access:
1. Use two pointers: one from head, one from tail.
2. Compare values moving inward.
3. Continue until pointers meet or cross.
4. Return false if any mismatch found.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Compare n/2 pairs.

- **Space Complexity**: `O(1)`  
  Only two pointers used.
