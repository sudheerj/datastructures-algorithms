# **Find Middle Node**

## **Problem Statement**
Given the head of a singly linked list, return the middle node. If two middle nodes, return the second one.

---

## **Examples**

### Example 1:
- **Input**: `[1,2,3,4,5]`
- **Output**: Node 3

### Example 2:
- **Input**: `[1,2,3,4,5,6]`
- **Output**: Node 4 (second middle)

---

## **Algorithmic Approach (Slow and Fast Pointers)**

1. Initialize slow and fast pointers at head.
2. Move slow by 1, fast by 2.
3. When fast reaches end, slow is at middle.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the list.

- **Space Complexity**: `O(1)`  
  Only two pointers used.
