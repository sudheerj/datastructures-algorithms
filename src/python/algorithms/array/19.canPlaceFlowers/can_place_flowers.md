# **Can Place Flowers**

## **Problem Statement**
You have a long flowerbed in which some plots are planted (1) and some are not (0). Flowers cannot be planted in adjacent plots. Given an integer `n`, return `true` if `n` new flowers can be planted without violating the no-adjacent-flowers rule.

---

## **Examples**

### Example 1:
- **Input**: `flowerbed = [1, 0, 0, 0, 1], n = 1`
- **Output**: `true`

### Example 2:
- **Input**: `flowerbed = [1, 0, 0, 1], n = 1`
- **Output**: `false`

---

## **Algorithmic Approach (Greedy)**

1. Initialize a counter for planted flowers.
2. Iterate through the flowerbed:
   - Check if current plot is empty (0) AND:
     - Either at start OR previous plot is empty (0) AND
     - Either at end OR next plot is empty (0)
   - If all conditions met:
     - Plant a flower (set to 1).
     - Increment counter.
     - If counter >= n, return `true`.
3. Return `counter >= n`.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the flowerbed.

- **Space Complexity**: `O(1)`  
  Only constant extra space is used.
