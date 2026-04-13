**Description:**
Given an integer array `nums` sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Return the number of unique elements `k`. The first `k` elements of `nums` should hold the unique elements in their original order.

### Examples
**Example 1:**
Input: nums = [1, 1, 2]

Output: 2, nums = [1, 2, ...]

**Example 2:**
Input: nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]

Output: 5, nums = [0, 1, 2, 3, 4, ...]

**Example 3:**
Input: nums = [1]

Output: 1, nums = [1]

**Algorithmic Steps:**

This problem is solved using the **two-pointer** technique to overwrite duplicates in-place. The algorithmic approach can be summarized as follows:

1. Initialize a pointer `left` at index `0`, representing the position of the last unique element found.

2. Iterate through the array starting from index `1` using a pointer `j`.

3. At each step, compare `nums[j]` with `nums[left]`. If they are different, it means a new unique element is found.

4. Increment `left` and copy `nums[j]` to `nums[left]` to place the unique element at the next position.

5. If `nums[j]` equals `nums[left]`, skip it and move `j` forward.

6. After the loop, return `left + 1` as the count of unique elements.

**Time and Space complexity:**

This algorithm has a time complexity of `O(n)`, where `n` is the number of elements. Each element is visited exactly once.

The space complexity is `O(1)`, as the duplicates are removed in-place without using any additional data structures.
