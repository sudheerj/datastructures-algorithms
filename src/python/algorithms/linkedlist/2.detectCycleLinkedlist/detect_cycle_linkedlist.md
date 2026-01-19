# **Detect Cycle in Linked List**

## **Problem Statement**
Given head of a linked list, determine if the linked list has a cycle in it.

---

## **Examples**

### Example 1:
- **Input**: `head = [3,2,0,-4], pos = 1`
- **Output**: `true` (tail connects to node at index 1)

### Example 2:
- **Input**: `head = [1], pos = -1`
- **Output**: `false`

---

## **Algorithmic Approach (Floyd's Cycle Detection)**

1. Use two pointers: slow (moves 1 step) and fast (moves 2 steps).
2. Move both pointers until they meet or fast reaches end.
3. If they meet: cycle exists.
4. If fast reaches null: no cycle.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Fast pointer will either reach end or catch slow pointer.

- **Space Complexity**: `O(1)`  
  Only two pointers used.
