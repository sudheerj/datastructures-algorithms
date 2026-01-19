# **Count Apples and Oranges**

## **Problem Statement**
Sam's house is located between points s and t. An apple tree is at point a, and an orange tree is at point b. Given the distances apples and oranges fall from their respective trees, count how many apples and oranges land on Sam's house.

---

## **Examples**

### Example 1:
- **Input**: `s = 7, t = 11, a = 5, b = 15, apples = [-2, 2, 1], oranges = [5, -6]`
- **Output**: `1` apple, `1` orange
- **Explanation**:
  - Apples land at: 3, 7, 6 → Only 7 is in range [7,11]
  - Oranges land at: 20, 9 → Only 9 is in range [7,11]

---

## **Algorithmic Approach**

1. For each apple distance:
   - Calculate landing position = a + distance.
   - Check if position is in range [s, t].
   - Increment apple count if true.
2. Repeat for oranges using tree position b.
3. Return both counts.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m + n)`  
  Where m is number of apples and n is number of oranges.

- **Space Complexity**: `O(1)`  
  Only two counters used.
