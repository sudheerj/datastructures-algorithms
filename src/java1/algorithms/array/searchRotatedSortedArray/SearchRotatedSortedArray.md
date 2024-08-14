**Description:**
Given a sorted array `nums` in an ascending order, which is rotated at some known pivot index. You need to search for a given `target` value, if found in the array return it's index otherwise return -1.

**Note:** There are no duplicate values exist. The runtime complexity should be O(log n).

### Examples

Example 1:
Input: nums = [3, 4, 5, 6, 7, 0, 1, 2], target = 7
Output: 4

Example 2:
Input: nums = [3, 4, 5, 6, 7, 0, 1, 2], target = 9
Output: -1

**Algorithmic Steps:**
This problem is solved with the help of binary search technique. Since it is a rotated sorted array, there will be two subararys of elements in an ascending order. You can decide the presence of target element by verifying either in left side subarray or right side subarray. The algorithmic approach can be summarized as follows:

1. Initialize left(`left`) and right pointers(`right`) to the beginning and ending index of an array.

2. Iterate over input array until either left pointer reaches right pointer or target element found.

3. Calculate the middle index of the array to divide into two equal subarrays.

4. If the middle element is equals to target, return the middle element index as output.

5. If the left element is less than or equal to middle element(i.e, `nums[left] <= nums[mid]`), the left portion of input array is sorted. In this case, if the target element exists between left and middle elements, update the right pointer to the element before the middle element(`right = mid-1`). This logic indicates that target exists with in first subarray. Otherwise update the left pointer to the element just after the middle element(`left = mid+1`) to indicate the target exists with in second subarray.

6. In the same way, if the right element is greater than or equal to right element(i.e, `nums[mid] <= nums[right]`), the right portion of input array is sorted. In this case, if the target element exists between right and middle elements, update the left pointer to the element after the middle element(`left = mid+1`). This logic indicates that target exists with in second subarray. Otherwise update the right pointer to the element just before the middle element(`right = mid-1`) to indicate the target exists with in first subarray.

7. Repeat steps 4-6 element found or until end of array reached.

8. Return -1, if the target doesn't exist with in input array.


**Time and Space complexity:**

This algorithm has a time complexity of `O(log n)`, where `n` is the number of elements. This is because we divide the array into two subarrays each time and find the index of target element using binary search algorithm. 

Here, we don't use any additional datastructure other than two left pointer variables. Hence, the space complexity will be O(1).