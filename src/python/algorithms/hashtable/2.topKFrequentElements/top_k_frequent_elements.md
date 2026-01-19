# **Top K Frequent Elements**

## **Problem Statement**
Given an integer array and an integer k, return the k most frequent elements.

---

## **Examples**

### Example 1:
- **Input**: `nums = [1,1,1,2,2,3], k = 2`
- **Output**: `[1, 2]`

### Example 2:
- **Input**: `nums = [1], k = 1`
- **Output**: `[1]`

---

## **Algorithmic Approach**

### Bucket Sort:
1. Count frequency of each element.
2. Create buckets where index = frequency.
3. Iterate buckets from high to low, collect k elements.

### Heap:
1. Count frequencies.
2. Use min-heap of size k.
3. Push all elements, pop when size > k.

---

## **Time and Space Complexity**

**Bucket Sort:**
- **Time Complexity**: `O(n)`
- **Space Complexity**: `O(n)`

**Heap:**
- **Time Complexity**: `O(n log k)`
- **Space Complexity**: `O(n)`
