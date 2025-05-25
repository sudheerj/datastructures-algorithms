**Description:**
Given an integer array `heights` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, heights[i])`. You need to find two lines that together with the x-axis form a container, such that the container contains the most water. Return the maximum amount of water a container can store.

### Examples
Example 1:

Input: heights = [3, 9, 4, 1, 5, 4, 7, 1, 7]
Output: 49

Example 2:

Input: heights = [1, 1]
Output: 1

Example 3 (Edge Case):

Input: heights = [5]
Output: 0 (Need at least two lines to form a container)

**Algorithm overview:**
This problem is solved using the **two pointers** technique, starting from opposite ends of the array. The key insight is that the area of water is determined by the shorter of the two lines and the distance between them.

#### Detailed steps:

1. **Initialize Variables**  
   - Set `maxArea` to 0 to track the maximum water container capacity
   - Set `left` pointer to the beginning (index 0) of the array
   - Set `right` pointer to the end (index length-1) of the array

2. **Two-Pointer Traversal**  
   Continue while the `left` pointer is less than the `right` pointer.

3. **Calculate Current Area**  
   - Find the height of the container as the minimum of the two heights at current pointers: `height = Math.min(heights[left], heights[right])`
   - Calculate the width as the distance between pointers: `width = right - left`
   - Compute the area: `area = height * width`

4. **Update Maximum Area**  
   Update `maxArea` if the current area is larger: `maxArea = Math.max(maxArea, area)`

5. **Move Pointers Strategically**  
   - If the left height is shorter than the right height, increment the `left` pointer
   - Otherwise, decrement the `right` pointer

   **Note:** We always move the pointer pointing to the shorter line because:
   - The container's height is limited by the shorter line
   - Moving the pointer at the shorter line gives a chance to find a taller line that might increase the area
   - Moving the pointer at the taller line would only decrease the width without the possibility of increasing the height

6. **Return Result**  
   After the pointers meet, return the `maxArea` as the maximum water container capacity.

## Time and Space Complexity

- **Time Complexity:** `O(n)`  
  The algorithm makes a single pass through the array with the two pointers, examining each element at most once.

- **Space Complexity:** `O(1)`  
  The algorithm uses only a constant amount of extra space regardless of input size, as it only requires a few variables (`maxArea`, `left`, `right`, etc.) to track the state.
