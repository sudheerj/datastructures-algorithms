**Description:**
Given a sorted array `nums` of length `n` with all unique elements, in which the array is rotated between 1 and n times. Return the minimum element of this array.

**Note:** You need to write an algorithm that runs in `O(log n)` time.

### Examples
Example 1:
Input: nums = [3, 4, 5, 6, 7, 1, 2]
Output: 1

Example 2:
Input: nums = [ 0, 1, 2, 4, 5, 6, 7, 8]
Output: 0

**Algorithmic Steps:**

This problem can be efficiently solved using the **binary search** technique. Because the array is a rotated version of a sorted array, it consists of two ascending subarrays. By identifying which subarray contains the minimum element, we can narrow down the search. The minimum value will always be the leftmost element of the correctly identified subarray. The algorithmic approach can be summarized as follows:


1. **Initialize the Result:**
   - Set the initial minimum value `result` to the first element of the array.

2. **Handle Base Cases:**
   - If the array length is `1`, return the only element.
   - If the array length is `2`, return the smaller of the two elements.

3. **Set Search Boundaries:**
   - Initialize two pointers: `left` at the start (index 0), and `right` at the end (index `n - 1`) of the array.

4. **Iterate Using Binary Search:**
   - While `left < right`:
     - Check if the subarray between `left` and `right` is already sorted:
       - If `nums[left] < nums[right]`, return `nums[left]` as the minimum.
     - Compute the middle index: `mid = Math.floor((left + right) / 2)`.

5. **Decide Which Half to Search:**
   - If `nums[mid] > nums[right]`:
     - The minimum lies in the **right half**.
     - Move `left` pointer to `mid + 1`.
   - Otherwise:
     - The minimum lies in the **left half** (including `mid`).
     - Move `right` pointer to `mid`.

6. **Return Minimum:**
   - After the loop ends, `nums[left]` holds the minimum element in the rotated sorted array.


**Time and Space complexity:**

This algorithm has a time complexity of `O(log n)`, where `n` is the number of elements. This is because we divide the array into two subarray each time and find the minimum element in the correct subarray using binary search algorithm. 

Here, we don't use any additional datastructure other than the result variable. Hence, the space complexity will be O(1).