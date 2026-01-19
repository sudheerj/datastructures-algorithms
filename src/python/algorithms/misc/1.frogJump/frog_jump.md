# **Frog Jump**

## **Problem Statement**
A frog wants to cross a river by jumping on stones. The frog starts at stone 0 and wants to reach the last stone. If the frog's last jump was k units, it can only jump k-1, k, or k+1 units. Determine if the frog can reach the last stone.

---

## **Examples**

### Example 1:
- **Input**: `stones = [0, 1, 3, 5, 6, 8, 12, 17]`
- **Output**: `true`

### Example 2:
- **Input**: `stones = [0, 1, 2, 3, 4, 8, 9, 11]`
- **Output**: `false`

---

## **Algorithmic Approach (DP with Hash Map)**

1. Create a map where key is stone position, value is set of possible jump sizes to reach it.
2. Initialize: first stone reachable with jump size 0.
3. For each stone:
   - For each possible jump size that can reach it:
   - Calculate positions reachable with k-1, k, k+1 jumps.
   - Add valid jumps to target stones.
4. Return true if last stone has any valid jumps.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n²)`  
  Each stone can have at most n possible jump sizes.

- **Space Complexity**: `O(n²)`  
  Hash map storage.
