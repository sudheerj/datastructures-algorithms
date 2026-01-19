# **Reverse Linked List**

## **Problem Statement**
Given the head of a singly linked list, reverse the list and return the reversed list.

---

## **Examples**

### Example 1:
- **Input**: `head = [1,2,3,4,5]`
- **Output**: `[5,4,3,2,1]`

### Example 2:
- **Input**: `head = [1,2]`
- **Output**: `[2,1]`

---

## **Algorithmic Approach**

### Iterative:
1. Initialize three pointers: prev = null, current = head.
2. While current is not null:
   - Store next node.
   - Reverse current's pointer to prev.
   - Move prev and current forward.
3. Return prev (new head).

### Recursive:
1. Base case: head is null or single node.
2. Recursively reverse rest of list.
3. Make next node point back to current.
4. Set current's next to null.

---

## **Time and Space Complexity**

**Iterative:**
- **Time Complexity**: `O(n)`
- **Space Complexity**: `O(1)`

**Recursive:**
- **Time Complexity**: `O(n)`
- **Space Complexity**: `O(n)` (call stack)
