# **Equi Leader**

## **Problem Statement**
Find the number of equi leaders - indices S such that the leader (majority element) of sequences [0..S] and [S+1..N-1] are the same.

---

## **Examples**

### Example 1:
- **Input**: `nums = [4, 3, 4, 4, 4, 2]`
- **Output**: `2`

### Example 2:
- **Input**: `nums = [1, 2, 1, 1, 2, 1]`
- **Output**: `2`

---

## **Algorithmic Approach**

1. Find the leader candidate using Boyer-Moore voting algorithm.
2. Count total occurrences of the leader.
3. Verify it's actually a leader (> n/2 occurrences).
4. Iterate through possible split points:
   - Track leader count in left part.
   - Calculate leader count in right part.
   - Check if leader is majority in both parts.
   - Increment equi leader count if true.
5. Return count.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Multiple passes through the array.

- **Space Complexity**: `O(1)`  
  Only constant extra space used.
