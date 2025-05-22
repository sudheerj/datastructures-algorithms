**Description:**
Given a sorted array `nums` in ascending order that has been rotated at an unknown pivot point, search for a target value. If the target is found in the array, return its index; otherwise, return -1.

**Note:** The array contains no duplicate values. The solution should have a runtime complexity of O(log n).

### Examples
Example 1:

Input: nums = [3, 4, 5, 6, 7, 0, 1, 2], target = 7
Output: 4

Example 2:

Input: nums = [3, 4, 5, 6, 7, 0, 1, 2], target = 9
Output: -1

Example 3 (Edge Case):

Input: nums = [1], target = 1
Output: 0

**Algorithm overview:**
This problem is solved using a modified **binary search** technique. In a rotated sorted array, there are two sorted subarrays. The key insight is to determine which subarray is sorted and then check if the target lies within that sorted portion.

#### Detailed steps:

1. **Initialize Pointers**  
   Set `left` pointer to the beginning (index 0) and `right` pointer to the end (index length-1) of the array.

2. **Binary Search Loop**  
   Continue searching while `left` pointer is less than or equal to `right` pointer.

3. **Find Middle Element**  
   Calculate the middle index using `mid = Math.floor((left + right) / 2)`.

4. **Check for Target Match**  
   If the middle element equals the target (`nums[mid] === target`), return the middle index immediately.

5. **Determine Which Half is Sorted**  
   - If `nums[left] <= nums[mid]`, the left half is sorted.
   - Otherwise, the right half is sorted.

6. **Search in Sorted Half**  
   - If the left half is sorted:
     - Check if the target is within the range `nums[left]` to `nums[mid-1]`.
     - If yes, search the left half by setting `right = mid - 1`.
     - If no, search the right half by setting `left = mid + 1`.

   - If the right half is sorted:
     - Check if the target is within the range `nums[mid+1]` to `nums[right]`.
     - If yes, search the right half by setting `left = mid + 1`.
     - If no, search the left half by setting `right = mid - 1`.

7. **Repeat or Return**  
   Repeat steps 3-6 until either the target is found or the search space is exhausted.

8. **Not Found Case**  
   If the loop terminates without finding the target, return -1.

## Time and Space Complexity

- **Time Complexity:** `O(log n)`  
  The algorithm uses a binary search approach, dividing the search space in half with each iteration. Even though the array is rotated, we can still determine which half to search in constant time.

- **Space Complexity:** `O(1)`  
  The algorithm uses only a constant amount of extra space regardless of input size, as it only requires a few variables (`left`, `right`, and `mid`) to track the search space.
