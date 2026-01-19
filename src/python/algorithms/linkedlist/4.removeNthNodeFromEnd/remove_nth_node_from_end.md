# **Remove Nth Node From End of List**

## **Problem Statement**
Given the head of a linked list, remove the nth node from the end and return the head.

---

## **Examples**

### Example 1:
- **Input**: `head = [1,2,3,4,5], n = 2`
- **Output**: `[1,2,3,5]`

### Example 2:
- **Input**: `head = [1], n = 1`
- **Output**: `[]`

---

## **Algorithmic Approach (Two Pointers)**

1. Create dummy node pointing to head (handles edge case of removing head).
2. Move fast pointer n+1 steps ahead.
3. Move both slow and fast until fast reaches end.
4. Now slow is at node before the one to remove.
5. Skip the target node: slow.next = slow.next.next.
6. Return dummy.next.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the list.

- **Space Complexity**: `O(1)`  
  Only two pointers used.
