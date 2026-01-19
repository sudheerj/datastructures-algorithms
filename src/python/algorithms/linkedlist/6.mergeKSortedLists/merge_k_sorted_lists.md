# **Merge K Sorted Lists**

## **Problem Statement**
Merge k sorted linked lists and return as one sorted list.

---

## **Examples**

### Example 1:
- **Input**: `lists = [[1,4,5],[1,3,4],[2,6]]`
- **Output**: `[1,1,2,3,4,4,5,6]`

---

## **Algorithmic Approach**

### Priority Queue (Min Heap):
1. Add head of each list to min heap.
2. Extract minimum, add to result.
3. If extracted node has next, add next to heap.
4. Repeat until heap is empty.

### Divide and Conquer:
1. Recursively merge pairs of lists.
2. Similar to merge sort.

---

## **Time and Space Complexity**

**Priority Queue:**
- **Time Complexity**: `O(N log k)`  
  N = total nodes, k = number of lists.
- **Space Complexity**: `O(k)` for heap.

**Divide and Conquer:**
- **Time Complexity**: `O(N log k)`
- **Space Complexity**: `O(log k)` for recursion.
