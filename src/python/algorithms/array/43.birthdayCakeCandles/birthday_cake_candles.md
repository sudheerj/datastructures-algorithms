# **Birthday Cake Candles**

## **Problem Statement**
Count the number of candles with the maximum height, representing the number of candles that can be blown out.

---

## **Examples**

### Example 1:
- **Input**: `candles = [3, 2, 1, 3]`
- **Output**: `2` (Two candles have height 3)

### Example 2:
- **Input**: `candles = [4, 4, 4, 4]`
- **Output**: `4`

---

## **Algorithmic Approach**

1. Find the maximum height among all candles.
2. Count how many candles have the maximum height.
3. Return the count.

This can be done in one pass or two passes.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single or two passes through the array.

- **Space Complexity**: `O(1)`  
  Only constant extra space used.
