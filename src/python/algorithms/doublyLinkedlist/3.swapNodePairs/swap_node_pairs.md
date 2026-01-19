# **Swap Node Pairs**

## **Problem Statement**
Swap every two adjacent nodes in a doubly linked list.

---

## **Examples**

### Example 1:
- **Input**: `[1, 2, 3, 4]`
- **Output**: `[2, 1, 4, 3]`

### Example 2:
- **Input**: `[1, 2, 3, 4, 5]`
- **Output**: `[2, 1, 4, 3, 5]`

---

## **Algorithmic Approach**

1. Process pairs of nodes.
2. For each pair:
   - Swap the two nodes by updating their prev/next pointers.
   - Update connections to previous and next pairs.
3. Handle edge cases: odd number of nodes (last node stays).

### Value Swap (Simple):
Just swap values of adjacent nodes.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Process each node once.

- **Space Complexity**: `O(1)`  
  In-place modification.
