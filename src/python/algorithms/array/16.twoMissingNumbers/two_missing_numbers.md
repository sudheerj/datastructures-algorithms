# **Two Missing Numbers**

## **Problem Statement**
Given an array containing `n` distinct numbers from `1` to `n+2`, find the two missing numbers.

---

## **Examples**

### Example 1:
- **Input**: `nums = [3, 2, 5, 1, 6, 8]`
- **Output**: `[4, 7]`

### Example 2:
- **Input**: `nums = [1, 2, 4, 5, 6]`
- **Output**: `[3, 7]`

---

## **Algorithmic Approach**

### Approach 1: Using Boolean Array (O(n) space)
1. Create a boolean array of size `n + 2`.
2. Mark each present number.
3. Find indices that are not marked.

### Approach 2: Using Math (O(1) space)
1. Calculate the sum of missing numbers using the formula: `expected_sum - actual_sum`.
2. Calculate the average of missing numbers: `missing_sum // 2`.
3. Calculate expected sum until average and actual sum until average.
4. The difference gives the first missing number.
5. Subtract from total missing sum to get the second.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array.

- **Space Complexity**: `O(n)` or `O(1)`  
  Depending on the approach used.
