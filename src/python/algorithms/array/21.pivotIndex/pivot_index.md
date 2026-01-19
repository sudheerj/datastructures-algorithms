# **Pivot Index**

## **Problem Statement**
Given an array of integers `nums`, calculate the pivot index. The pivot index is where the sum of all elements to the left equals the sum of all elements to the right.

---

## **Examples**

### Example 1:
- **Input**: `nums = [1, 7, 3, 6, 5, 6]`
- **Output**: `3`
- **Explanation**: Left sum = 1 + 7 + 3 = 11, Right sum = 5 + 6 = 11.

### Example 2:
- **Input**: `nums = [1, 2, 3]`
- **Output**: `-1`
- **Explanation**: No index satisfies the condition.

---

## **Algorithmic Approach**

1. Calculate the total sum of the array.
2. Initialize `left_sum = 0`.
3. Iterate through each index:
   - Calculate `right_sum = total_sum - left_sum - nums[i]`.
   - If `left_sum == right_sum`: Return current index.
   - Add `nums[i]` to `left_sum`.
4. Return `-1` if no pivot found.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Two passes through the array (one for total sum, one for pivot).

- **Space Complexity**: `O(1)`  
  Only constant extra space is used.
