# **Remove Duplicates from Sorted List**

## **Problem Statement**
Given a sorted linked list, delete all duplicates such that each element appears only once.

---

## **Examples**

### Example 1:
- **Input**: `[1,1,2]`
- **Output**: `[1,2]`

### Example 2:
- **Input**: `[1,1,2,3,3]`
- **Output**: `[1,2,3]`

---

## **Algorithmic Approach**

1. Start from head.
2. While current and current.next exist:
   - If current.val == current.next.val: Skip duplicate.
   - Else: Move to next node.
3. Return head.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the list.

- **Space Complexity**: `O(1)`  
  In-place modification.
