**Description:**
Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value. If `target` is not found in the array, return `[-1, -1]`. You must write an algorithm with `O(log n)` runtime complexity.

### Examples
**Example 1:**
Input: nums = [5, 7, 7, 8, 8, 10], target = 8

Output: [3, 4]

**Example 2:**
Input: nums = [5, 7, 7, 8, 8, 10], target = 6

Output: [-1, -1]

**Example 3:**
Input: nums = [], target = 0

Output: [-1, -1]

**Algorithmic Steps:**

This problem is solved using **binary search** twice to find the first and last positions independently. The algorithmic approach can be summarized as follows:

1. Define a helper function `findBound(nums, target, findFirst)` that performs a modified binary search.

2. Initialize `left`, `right`, and `index` variables. `index` stores the most recent position where the target was found.

3. Perform binary search: when the target is found at `mid`, store `mid` in `index` and continue searching — shrink to the **left half** (`right = mid - 1`) if finding the first occurrence, or to the **right half** (`left = mid + 1`) if finding the last occurrence.

4. If `nums[mid] < target`, move `left` to `mid + 1`. If `nums[mid] > target`, move `right` to `mid - 1`.

5. Call `findBound` twice — once with `findFirst = true` and once with `findFirst = false` — to get the starting and ending positions.

6. Return the result as `[firstIndex, lastIndex]`.

**Time and Space complexity:**

This algorithm has a time complexity of `O(log n)`, where `n` is the number of elements. Binary search is performed twice, each taking `O(log n)`.

The space complexity is `O(1)`, as only a few extra variables are used.
