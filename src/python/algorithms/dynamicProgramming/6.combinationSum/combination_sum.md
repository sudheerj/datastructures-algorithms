# **Combination Sum**

## **Problem Statement**
Given an array of distinct integers `candidates` and a target integer, return all unique combinations where the chosen numbers sum to target. The same number may be chosen unlimited times.

---

## **Examples**

### Example 1:
- **Input**: `candidates = [2, 3, 6, 7], target = 7`
- **Output**: `[[2, 2, 3], [7]]`

### Example 2:
- **Input**: `candidates = [2, 3, 5], target = 8`
- **Output**: `[[2, 2, 2, 2], [2, 3, 3], [3, 5]]`

---

## **Algorithmic Approach (Backtracking with DP)**

### Backtracking:
1. Use recursion with current combination and remaining target.
2. For each candidate (starting from current index):
   - If candidate <= remaining: Add to combination, recurse.
   - If remaining becomes 0: Add combination to results.
3. Backtrack by removing last added element.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n^(target/min))` worst case  
  Depends on the target and minimum candidate.

- **Space Complexity**: `O(target/min)`  
  Maximum recursion depth.
