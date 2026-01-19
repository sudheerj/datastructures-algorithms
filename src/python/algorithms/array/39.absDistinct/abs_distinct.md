# **Absolute Distinct**

## **Problem Statement**
Compute the number of distinct absolute values among elements of an array.

---

## **Examples**

### Example 1:
- **Input**: `nums = [-5, -3, -1, 0, 3, 6]`
- **Output**: `5` (0, 1, 3, 5, 6)

### Example 2:
- **Input**: `nums = [1, 1, 1, 1]`
- **Output**: `1`

---

## **Algorithmic Approach**

### Using Set (Simple):
1. Create a set to store absolute values.
2. Iterate through the array, adding absolute value of each element.
3. Return the size of the set.

### Using Two Pointers (Space Optimal):
1. Use two pointers from both ends of sorted array.
2. Track previous absolute value.
3. Move pointers based on which absolute value is larger.
4. Count distinct absolute values.

---

## **Time and Space Complexity**

**Set Approach:**
- **Time Complexity**: `O(n)`
- **Space Complexity**: `O(n)`

**Two Pointers (if array is sorted):**
- **Time Complexity**: `O(n)`
- **Space Complexity**: `O(1)`
