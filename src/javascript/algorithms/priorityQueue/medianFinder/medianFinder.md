**Description:**
Design a data structure that supports two operations on a live stream of integers:
- `addNum(num)` — insert an integer into the data structure.
- `findMedian()` — return the median of all numbers inserted so far.

The **median** is the middle value in an ordered list. If the list has an even number of elements, the median is the average of the two middle values.

### Examples

Example 1:
addNum(1), addNum(2), findMedian()
Output: 1.5
Explanation: Sorted stream = [1, 2]. Median = (1 + 2) / 2 = 1.5

Example 2:
addNum(1), addNum(2), addNum(3), findMedian()
Output: 2.0
Explanation: Sorted stream = [1, 2, 3]. Median = 2.

Example 3:
addNum(5), findMedian()
Output: 5.0
Explanation: Only one element; median is 5.

Example 4:
addNum(40), addNum(30), addNum(50), addNum(10), addNum(20), findMedian()
Output: 30.0
Explanation: Sorted stream = [10, 20, 30, 40, 50]. Median = 30.

Example 5:
addNum(1), addNum(7), addNum(3), addNum(9), addNum(2), addNum(8), findMedian()
Output: 5.0
Explanation: Sorted stream = [1, 2, 3, 7, 8, 9]. Median = (3 + 7) / 2 = 5.

**Algorithmic Steps**
This problem is solved using a **two-heap** approach. The algorithmic approach can be summarized as follows:

1. Maintain two heaps:
   - `maxHeap` — a max-heap storing the **lower half** of numbers (top = largest in lower half).
   - `minHeap` — a min-heap storing the **upper half** of numbers (top = smallest in upper half).

2. Invariant: `maxHeap.size()` equals `minHeap.size()` (even count) **or** `maxHeap.size()` equals `minHeap.size() + 1` (odd count).

3. **addNum(num)**:
   a. Push `num` onto `maxHeap`.
   b. Move `maxHeap`'s top to `minHeap` — this ensures all elements in `maxHeap` are ≤ all elements in `minHeap`.
   c. If `maxHeap.size() < minHeap.size()`, move `minHeap`'s top back to `maxHeap` to restore the size invariant.

4. **findMedian()**:
   - If both heaps are the same size (even total): return `(maxHeap.peek() + minHeap.peek()) / 2.0`.
   - Otherwise (odd total, maxHeap has one more): return `maxHeap.peek()`.

**Time and Space complexity:**
- `addNum`: `O(log n)` — each heap push/pop is logarithmic.
- `findMedian`: `O(1)` — just reading the heap tops.
- Space: `O(n)` — all elements are stored across the two heaps.
