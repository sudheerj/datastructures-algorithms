# **Maximum Length Between Equal Characters**

## **Problem Statement**
Given a string `s`, return the length of the longest substring between two equal characters, excluding the two characters. Return `-1` if there is no such substring.

---

## **Examples**

### Example 1:
- **Input**: `s = "aa"`
- **Output**: `0`

### Example 2:
- **Input**: `s = "abca"`
- **Output**: `2`

### Example 3:
- **Input**: `s = "cbzxy"`
- **Output**: `-1`

---

## **Algorithmic Approach (First Occurrence Map)**

1. Create a dictionary to store the first occurrence of each character.
2. Iterate through the string:
   - If character seen before: Calculate length between current and first occurrence.
   - Update max length if larger.
   - If not seen: Store current index as first occurrence.
3. Return max length or -1.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the string.

- **Space Complexity**: `O(1)`  
  At most 26 characters stored.
