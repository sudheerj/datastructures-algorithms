# **Max Counters**

## **Problem Statement**
You are given N counters, all initialized to 0. Operations can be:
- `increase(X)`: Counter X is increased by 1.
- `max counter`: All counters are set to the maximum value.

Return the values of all counters after all operations.

---

## **Examples**

### Example 1:
- **Input**: `n = 5, operations = [3, 4, 4, 6, 1, 4, 4]`
- **Output**: `[3, 2, 2, 4, 2]`

---

## **Algorithmic Approach (Lazy Update)**

1. Initialize counters array, max value, and last update value.
2. For each operation:
   - If valid counter (1 to n): Apply lazy update if needed, then increment.
   - If n+1: Store current max as deferred update.
3. Final pass: Apply lazy update to all counters.

This avoids O(n) work for each max counter operation.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n + m)`  
  Where m is operations length.

- **Space Complexity**: `O(n)`  
  For the counters array.
