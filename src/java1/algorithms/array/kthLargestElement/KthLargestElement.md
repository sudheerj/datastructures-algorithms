**Problem statement:** Given an integer array `nums` and an integer `k`, return the `kth` largest element in the array. Note that it is the `kth` largest element in sorted order, not the `kth` distinct element.

## Examples:

```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```

## Approach 1: Sorting

**Algorithmic Steps**

1. Sort the array in ascending order.
2. Return the element at index `nums.length - k`.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n log n) |
| Space | O(1) or O(n) depending on sorting algorithm |

## Approach 2: Min-Heap of Size k

**Algorithmic Steps**

1. Create a min-heap (PriorityQueue).
2. Iterate through each element and add it to the heap.
3. If heap size exceeds `k`, remove the minimum element.
4. After all elements are processed, the top of the heap is the kth largest.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n log k) |
| Space | O(k) |

## Approach 3: Max-Heap

**Algorithmic Steps**

1. Add all elements into a max-heap.
2. Poll from the heap `k - 1` times to discard the top k-1 largest elements.
3. The element now at the top is the kth largest.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n log n) |
| Space | O(n) |

## Approach 4: QuickSelect

**Algorithmic Steps**

1. Compute `target = n - k`, which is the index of the kth largest element in a sorted ascending array.
2. Choose the rightmost element as the pivot and run Lomuto partition.
3. If `pivotIndex == target`, return `nums[pivotIndex]`.
4. If `pivotIndex < target`, recurse on the right half `(pivotIndex+1, right)`.
5. Otherwise, recurse on the left half `(left, pivotIndex-1)`.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n) average, O(n²) worst case |
| Space | O(n) recursion stack |
