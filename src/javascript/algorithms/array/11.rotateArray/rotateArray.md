**Description**
Given an integer array `nums`, rotate the array to the right by `n` steps, where `n` is a non-negative number. The rotation is performed **in-place**, meaning no additional array is used for the operation.

### Examples
Example 1:

Input: nums = [1,2,3,4,5,6,7], n = 4
Output: [4,5,6,7,1,2,3]

Example 2:

Input: nums = [-10, 4, 5, -1], n = 2
Output: [5, -1, -10, 4]

**Algorithm overview:**
This algorithm leverages the **reversal technique** (a two-pointer approach) to efficiently rotate the array in-place.

To rotate the array to the right by `n` steps:

1.  Reverse the entire array.
2.  Reverse the first `n` elements.
3.  Reverse the remaining `length - n` elements.

#### Detailed steps:

1. **Calculate Array Length**  
   Initialize a variable `length` to store the total number of elements in the array.

2. **Edge case**
   No rotation is required when the given array is empty and number of rotations is equals to the length of an array. This condition is helpful for early exit.
   
3. **Normalize the Rotation Count**  
   Update the rotation count by taking `n % length` to handle cases where `n` exceeds the array size. This ensures we perform only the necessary rotations.

4. **Define a Reversal Helper Function**  
   Implement a helper function that reverses elements between two indices (`left` and `right`) in the array using a two-pointer technique. Swap the elements at `left` and `right`, then increment `left` and decrement `right` in each iteration until both pointers meet.

5. **Reverse the Entire Array**  
   Apply the reversal function to the full array (from index `0` to `length - 1`). This step brings the elements that need to be rotated to the front, but in reverse order.

6. **Reverse the First `n` Elements**  
   Reverse the first `n` elements (from index `0` to `n - 1`) to restore them to the correct order.

7. **Reverse the Remaining Elements**  
   Reverse the remaining elements (from index `n` to `length - 1`) to place the original beginning of the array back in the correct order.

8. **Return the Rotated Array**  
   The array has now been successfully rotated in-place and is ready for use.

## Time and Space Complexity

- **Time Complexity:** `O(n)`  
  The algorithm performs three reverse operations, each taking `O(n)` time in total.

- **Space Complexity:** `O(1)`  
  The rotation is done in-place, using only a constant amount of extra space regardless of input size.

