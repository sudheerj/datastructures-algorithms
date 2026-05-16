**Description:**
Design a data structure that supports two operations on a live stream of integers:
- `add_num(num)` — insert an integer into the data structure.
- `find_median()` — return the median of all numbers inserted so far.

The **median** is the middle value in an ordered list. If the list has an even number of elements, the median is the average of the two middle values.

### Examples

Example 1:
add_num(1), add_num(2), find_median()
Output: 1.5
Explanation: Sorted stream = [1, 2]. Median = (1 + 2) / 2 = 1.5

Example 2:
add_num(1), add_num(2), add_num(3), find_median()
Output: 2.0
Explanation: Sorted stream = [1, 2, 3]. Median = 2.

Example 3:
add_num(5), find_median()
Output: 5.0
Explanation: Only one element; median is 5.

Example 4:
add_num(40), add_num(30), add_num(50), add_num(10), add_num(20), find_median()
Output: 30.0
Explanation: Sorted stream = [10, 20, 30, 40, 50]. Median = 30.

Example 5:
add_num(1), add_num(7), add_num(3), add_num(9), add_num(2), add_num(8), find_median()
Output: 5.0
Explanation: Sorted stream = [1, 2, 3, 7, 8, 9]. Median = (3 + 7) / 2 = 5.

**Algorithmic Steps**
This problem is solved using a **two-heap** approach. The algorithmic approach can be summarized as follows:

1. Maintain two heaps:
   - `max_heap` — a max-heap storing the **lower half** of numbers (top = largest in lower half). Implemented via negated values in Python's `heapq`.
   - `min_heap` — a min-heap storing the **upper half** of numbers (top = smallest in upper half).

2. Invariant: `len(max_heap)` equals `len(min_heap)` (even count) **or** `len(max_heap)` equals `len(min_heap) + 1` (odd count).

3. **add_num(num)**:
   a. Push `num` onto `max_heap` (as `-num` for max-heap behavior).
   b. Move `max_heap`'s top to `min_heap` — this ensures all elements in `max_heap` are ≤ all elements in `min_heap`.
   c. If `len(max_heap) < len(min_heap)`, move `min_heap`'s top back to `max_heap` to restore the size invariant.

4. **find_median()**:
   - If both heaps are the same size (even total): return `(-max_heap[0] + min_heap[0]) / 2.0`.
   - Otherwise (odd total, max_heap has one more): return `float(-max_heap[0])`.

**Time and Space complexity:**
- `add_num`: `O(log n)` — each heap push/pop is logarithmic.
- `find_median`: `O(1)` — just reading the heap tops.
- Space: `O(n)` — all elements are stored across the two heaps.
