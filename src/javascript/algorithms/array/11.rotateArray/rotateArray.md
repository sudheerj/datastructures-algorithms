**Description**
Given an integer array `nums`, rotate the array to the right by `n` steps, where `n` is a non-negative number. The rotation is performed **in-place**, meaning no additional array is used for the operation.

### Examples
Example 1:

Input: nums = [1,2,3,4,5,6,7], n = 4
Output: [4,5,6,7,1,2,3]

Example 2:

Input: nums = [-10, 4, 5, -1], n = 2
Output: [5, -1, -10, 4]

Example 3 (Edge Case):

Input: nums = [1], n = 10
Output: [1] (Single element array remains unchanged regardless of rotation count)

**Algorithm overview:**
This problem can be solved using two different approaches:

### Approach 1: Reversal Technique (Efficient)
This algorithm leverages the **reversal technique** (a two-pointer approach) to efficiently rotate the array in-place.

To rotate the array to the right by `n` steps:

1.  Reverse the entire array.
2.  Reverse the first `n` elements.
3.  Reverse the remaining `length - n` elements.

#### Detailed steps:

1. **Calculate Array Length**  
   Initialize a variable `length` to store the total number of elements in the array.

2. **Handle Edge Cases**
   No rotation is required when:
   - The array is empty
   - The rotation count is 0
   - The rotation count is equal to the array length (full rotation returns to original state)
   This condition is helpful for early exit.

3. **Normalize the Rotation Count**  
   Update the rotation count by taking `n % length` to handle cases where `n` exceeds the array size. This ensures we perform only the necessary rotations.

4. **Define a Reversal Helper Function**  
   Implement a helper function that reverses elements between two indices (`start` and `end`) in the array using a two-pointer technique. Swap the elements at `start` and `end`, then increment `start` and decrement `end` in each iteration until both pointers meet.

5. **Reverse the Entire Array**  
   Apply the reversal function to the full array (from index `0` to `length - 1`). This step brings the elements that need to be rotated to the front, but in reverse order.

6. **Reverse the First `n` Elements**  
   Reverse the first `n` elements (from index `0` to `n - 1`) to restore them to the correct order.

7. **Reverse the Remaining Elements**  
   Reverse the remaining elements (from index `n` to `length - 1`) to place the original beginning of the array back in the correct order.

8. **Return the Rotated Array**  
   The array has now been successfully rotated in-place and is ready for use.

### Approach 2: Brute Force Method
This approach uses JavaScript's array methods to perform the rotation one step at a time.

#### Detailed steps:

1. **Calculate Array Length**  
   Initialize a variable `length` to store the total number of elements in the array.

2. **Handle Empty Array**
   Return immediately if the array is empty.

3. **Normalize the Rotation Count**  
   Update the rotation count by taking `n % length` to handle cases where `n` exceeds the array size.

4. **Perform Rotation**  
   For each of the `n` steps:
   - Remove the last element of the array using `pop()`
   - Insert this element at the beginning of the array using `unshift()`

5. **Array is Rotated**  
   After `n` iterations, the array has been rotated to the right by `n` positions.

## Time and Space Complexity

### Approach 1 (Reversal Technique):
- **Time Complexity:** `O(n)`  
  The algorithm performs three reverse operations, each taking `O(n)` time in total.

- **Space Complexity:** `O(1)`  
  The rotation is done in-place, using only a constant amount of extra space regardless of input size.

### Approach 2 (Brute Force):
- **Time Complexity:** `O(n²)`  
  For each of the `n` rotations, the `unshift()` operation takes `O(n)` time as it requires shifting all elements.

- **Space Complexity:** `O(1)`  
  The rotation is done in-place, modifying the original array.
