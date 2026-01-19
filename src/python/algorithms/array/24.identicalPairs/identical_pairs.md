# **Number of Identical Pairs**

## **Problem Statement**
Given an array of integers `nums`, return the number of good pairs. A pair `(i, j)` is called good if `nums[i] == nums[j]` and `i < j`.

---

## **Examples**

### Example 1:
- **Input**: `nums = [1, 2, 3, 1, 1, 3]`
- **Output**: `4`
- **Explanation**: There are 4 good pairs: (0,3), (0,4), (3,4), (2,5).

### Example 2:
- **Input**: `nums = [1, 1, 1, 1]`
- **Output**: `6`

---

## **Algorithmic Approach (Frequency Map)**

1. Create a frequency map to count occurrences.
2. Iterate through the array:
   - If the number exists in the map, add its current count to the total pairs.
   - Increment the count for that number.
3. Return the total pairs.

**Alternative**: For each number with frequency `n`, the number of pairs is `n * (n - 1) / 2`.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array.

- **Space Complexity**: `O(n)`  
  For the frequency map.
