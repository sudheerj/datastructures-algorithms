**Description:**
Given an array `nums` with `n` objects colored red, white, where each object is color coded as integer: blue, 0 for red, 1 for white, and 2 for blue. We need to sort them in-place so that objects of the same color are grouped together, with the colors in the order red, white, and blue.

This problem needs to be solved without using the library's sort function.

### Examples

Example 1:

Input: nums = [2,1,0,1,2,0]
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,1,0]
Output: [0,1,2]

**Algorithmic Steps:**

This problem is solved with the help of **two pointers** technique. It is also know as **"Dutch National Flag problem"**. The algorithmic approach can be summarized as follows:


1. Initialize both left and right pointers to first index(i.e, `0`) and end index(i.e, `nums.length-1`) of the array respectively, to keep track of the current window boundaries.

2. Initialize current index pointer(i.e, `i`) to 0, to keep track of the current character while iterating the array.

3. Iterate over the input array using index pointer until the end of the array. 

4. If the current character is equals to 0, swap the character values at left pointer and index pointer. Also, increment the left pointer and index pointer.

5. If the current character is equals to 2, swap the character values at right pointer and index pointer. Also, decrement the right pointer. 

6. If the character is neither `0` or `2`, then just increment the index pointer.

7. Repeat steps 4–6 until the index pointer reaches the end of the array.

8. Return the updated in-place array where characters are sorted.

**Time and Space complexity:**
This algorithm takes a time complexity of `O(n)` because we are traversing the array only once. Also, it requires space complexity of `O(1)` because we are updating the array in-place without using an additional data structure.