# **Genomic Range Query**

## **Problem Statement**
A DNA sequence is represented as a string of characters A, C, G, T with impact factors 1, 2, 3, 4 respectively. For each query [P, Q], find the minimal impact factor of nucleotides in that range.

---

## **Examples**

### Example 1:
- **Input**: `S = "CAGCCTA", P = [2, 5, 0], Q = [4, 5, 6]`
- **Output**: `[2, 4, 1]`

---

## **Algorithmic Approach (Prefix Sum)**

1. Create prefix sum arrays for each nucleotide (A, C, G).
2. For each query [P, Q]:
   - Check if A exists in range (count differs from prefix).
   - Check if C exists in range.
   - Check if G exists in range.
   - Otherwise, T is the minimum.
3. Return array of minimum impact factors.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n + m)`  
  n for preprocessing, m for queries.

- **Space Complexity**: `O(n)`  
  For prefix sum arrays.
