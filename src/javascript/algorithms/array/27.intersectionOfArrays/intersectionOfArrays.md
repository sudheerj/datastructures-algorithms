**Description:**
Given two integer arrays `nums1` and `nums2`, return an array of their intersection in such away that each element in the result must be unique.

**Note:** The elements in result can appear in any order.

### Examples
Example 1:

Input: nums1 = [5,3,3,5], nums2 = [5,3]
Output: [ 5, 3 ]

Example 2:

Input: nums1 = [1, 3, 5], nums2 = [2, 4]
Output: [ ]

**Algorithmic Steps**
This problem is solved with the help of set data structure and array traversal over the elements. The algorithmic approach can be summarized as follows:

1. Create a function named `intersection`, which accepts input arrays(`nums1` and `nums2`) to find the intersection of elements.
   
2. Define a set data structure named `set` which stores the elements of `nums1`. Create a result list(`result`) to return the intersection of elements.
   
3. Iterate over first array(`nums1`) and add each element to a set.
   
4. Iterate over second array(`nums2`) and add an element to result list if that element exists in a set. Also, remove the same element from set to avoid adding duplicate elements to result list.
   
5. Return the result array which has intersection of elements.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n1+n2)`, where `n1` is the number of elements in first array and `n2` is the number of elements in second array. This is because we need to iterate over all the elements of first array to insert them into a set with a time complexity of `O(n1)`. At the same time, we need to iterate over each element of second array to find the intersected elements. Hence, total time complexity is `O(n1+n2)`.
 
It takes constant time complexity of `O(n1+n2)`. This is due to hash set usage with a space complexity of `O(n1)`and `O(min(n1+n2))` if all the elements of one array exists in another array.