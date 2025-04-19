**Description:**
Given a string `str`, return the length of the longest substring between two identical characters, excluding the characters themselves. If no such substring exists, return -1. 

**Note:**A substring is defined as a contiguous sequence of characters within the string.

### Examples
Example 1:

Input: nums = [2,3]
Output: 2

Example 2:

Input: nums = [0,0,0]
Output: -1

Example 3:

Input: nums = [0,4,3,0,4]
Output: -1

**Algorithmic Steps**
This problem is solved with the help of counting element frequencies and array traversal over the elements. The algorithmic approach can be summarized as follows:

1. Create a function named `specialArray` and accepts input array(`nums`), which is used to determine the element `x` such that `x` number of elements greater or equal to x.
   
2. Define a counts arrays with `len+1` elements, where each element is initialized to zero. Here, `len` is the number of elements in an input array.
   
3. Iterate over an input array(`nums`) and update each element's count frequency. If the element is greater (or equal) than length of an array, update the count frequency at length index. 

4. Define a counter variable `elementsGreaterThanX` to caculate the total count of elements greater upto particular index.
   
5. Iterate over an input array(`nums`) in a backward direction. In each iteration, update the counter `elementsGreaterThanX` by adding counter frequency at each index(`x`). If the total count is equals to current index, return the element `x` as an output
   
6. Return -1 if there is no element exists.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements in an input array. This is because we need to iterate over all the elements twice, one for finding the counter frequency and other one comparing the total count to each index.
 
It takes constant time complexity of `O(n)`. This is due to array counter used to calculate the frequency of elements.