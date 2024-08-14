**Description:**
Given a sorted array `nums` of length `n` with all unique elements, in which the array is rotated between 1 and n times. Return the minimum element of this array.

**Note:** You need to write an algorithm that runs in O(log n) time.

### Examples
Example 1:
Input: nums = [3, 4, 5, 6, 7, 1, 2]
Output: 1

Example 2:
Input: nums = [ 0, 1, 2, 4, 5, 6, 7, 8]
Output: 0

**Algorithmic Steps:**

This problem is solved with the help of binary search technique. Since it is a rotated sorted array, there will be two subararys of elements in an ascending order. Once you find the correct subarray, the left most element is the minimum value. The algorithmic approach can be summarized as follows:

1. Initialize the minimum value(`result`) to first element of an array.

2. Add preliminary checks by returning the first element if the length of array is one, or minimum of first two values if the length of an array is two.

3. Initialize left and right pointers(`left` and `right`) to first index and last index of an array.

4. Iterate over an input array using while loop with the condition of left pointer is less than or equal to right pointer.

5. If the left element is less than or equal to right element, update the result value and break the while loop to return the minimum value.

6. Calculate the middle index of an array to separate the sorted subarrays.

7. If the middle value is greater than right most element, the minimum value exists with in the right side subarray. So the left pointer will be updated to next element of middle element.

8. If the middle value is less than or equal to left most element, the minimum value exists with in the left side subarray. So the right pointer will be updated to the middle element.

9. Repeat steps 4-7 until you find the left most value which is minimum in the entire input array.

10. Return the result element after the end of an iteration.

**Time and Space complexity:**

This algorithm has a time complexity of `O(log n)`, where `n` is the number of elements. This is because we divide the array into two subarray each time and find the minimum element in the correct subarray using binary search algorithm. 

Here, we don't use any additional datastructure other than the result variable. Hence, the space complexity will be O(1).