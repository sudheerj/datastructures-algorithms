# **Swap First and Last**

## **Problem Statement**
Swap the first and last nodes of a doubly linked list.

---

## **Examples**

### Example 1:
- **Input**: `[1, 2, 3, 4, 5]`
- **Output**: `[5, 2, 3, 4, 1]`

---

## **Algorithmic Approach**

1. Handle edge cases: empty list or single node.
2. Swap values of head and tail nodes.
   - Or swap the actual nodes by updating pointers.

### Value Swap (Simple):
Just swap `head.value` and `tail.value`.

### Node Swap (Complex):
Update prev/next pointers for head, tail, and adjacent nodes.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(1)`  
  Direct access to head and tail.

- **Space Complexity**: `O(1)`  
  Only constant extra space.
