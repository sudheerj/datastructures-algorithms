# **Staircase**

## **Problem Statement**
Print a staircase of size n using # symbols, right-aligned.

---

## **Examples**

### Example 1:
- **Input**: `n = 4`
- **Output**:
```
   #
  ##
 ###
####
```

---

## **Algorithmic Approach**

For each row i (1 to n):
1. Print (n - i) spaces.
2. Print i hash symbols.
3. Print newline.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n²)`  
  n rows with up to n characters each.

- **Space Complexity**: `O(1)`  
  Output only, no extra storage.
