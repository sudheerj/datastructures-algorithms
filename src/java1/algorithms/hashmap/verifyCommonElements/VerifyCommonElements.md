**Problem statement:**
Given two integer arrays `nums1` and `nums2`, return `true` if there are any common elements. Otherwise return `false`.

## Examples:
Example 1:

Input: nums1 = [10, 43, 9, 7], nums2=[17, 33, 10, 2]
Output:  true

Example 2: 

Input: nums1 = [1, 2, 3, 4], nums2=[5, 6, 7]
Output:  false

**Algorithmic Steps**
This problem is solved with the help of hashtable `put` and `get` methods. The algorithmic approach can be summarized as follows: 

1. Create an empty map(`commonMap`) to store the array elements.
    
2. Iterate a first input array using for-of loop. Add the numbers as keys and respective values with `true` value. 
   
3. Iterate a second input array using for-of loop and return `true` if any value exists with in a mp. 

4. As a last step, Return `false` indicating that there are no common elements between arrays.


**Time and Space complexity:**
This algorithm has a time complexity of `O(M + N)`, where `M` is the length of first array and `n` is the length of second array. This is because first loop needs to iterate each element of `arr1` which takes `O(M)` time complexity followed by second loop to iterate each element of `arr2` which takes `O(N)` time complexity. Hence, the overall complexity is `O(M + N)`.

Here, we use map datastructure which is used to store all the elements of first array with a length of `M`. Hence, the space complexity will be `O(M)`.
