# **Merge Two Sorted Lists**

## **Problem Statement**
Merge two sorted linked lists and return it as a sorted list.

---

## **Examples**

### Example 1:
- **Input**: `list1 = [1,2,4], list2 = [1,3,4]`
- **Output**: `[1,1,2,3,4,4]`

---

## **Algorithmic Approach**

### Iterative:
1. Create dummy node as placeholder.
2. Compare nodes from both lists, append smaller one.
3. Move pointer in the list from which node was taken.
4. Attach remaining nodes from non-empty list.
5. Return dummy.next.

### Recursive:
1. Base case: one list is empty, return other.
2. Compare heads, recursively merge rest.

---

## **Time and Space Complexity**

**Iterative:**
- **Time Complexity**: `O(n + m)`
- **Space Complexity**: `O(1)`

**Recursive:**
- **Time Complexity**: `O(n + m)`
- **Space Complexity**: `O(n + m)` (call stack)
