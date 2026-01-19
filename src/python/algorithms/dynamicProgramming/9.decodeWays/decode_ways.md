# **Decode Ways**

## **Problem Statement**
A message containing letters A-Z can be encoded as numbers 1-26. Given a string of digits, return the number of ways to decode it.

---

## **Examples**

### Example 1:
- **Input**: `s = "12"`
- **Output**: `2` ("AB" or "L")

### Example 2:
- **Input**: `s = "226"`
- **Output**: `3` ("BZ", "VF", "BBF")

---

## **Algorithmic Approach (Dynamic Programming)**

1. `dp[i]` = number of ways to decode string up to index i.
2. For each position:
   - If current digit is valid (1-9): Add `dp[i-1]`
   - If two digits form valid code (10-26): Add `dp[i-2]`
3. Handle leading zeros (return 0 if string starts with '0').

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the string.

- **Space Complexity**: `O(1)` (optimized)  
  Only two variables needed.
