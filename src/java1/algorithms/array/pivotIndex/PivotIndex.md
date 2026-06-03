**Description:**
Given an integer array `nums`, find the pivot index of an array. 

**Note:** The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right. If the index is on the left edge of an array, the left sum becomes `0` because there are no left elements. It also applies to the right edge of an array. Return -1, if no such index found.

### Examples
Example 1:

Input: nums = [2,6,4,2,5,7]
Output: 3

Example 2:

Input: nums = [1,2,3,4]
Output: -1

**Algorithmic Steps**
This problem is solved with the help of array traversal and finding sum of the elements. The algorithmic approach can be summarized as follows:

1. Define a total sum variable(`totalSum`) to calculate the sum of all elements of a given array.

2. Initialize the left sum(`leftSum`) and right sum(`rightSum`) to zero. These variables represent left and right sum at any specific index position of an array.

3. Iterate over the array, and for each iteration calculate the right sum and left sum values. 
    1. The right sum is calculated by subtracting left sum and current value from total sum. 

    2. Return the index(`i`), if the right sum is equals to left sum.
   
    3. Update the left sum by adding current value at each index position.
   
 4. Return -1, if no such index exists.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements in an array. This is because we need to iterate over all the elements at most twice. One time for calculating the total sum and another time for calculating the left sum.
 
It takes constant time complexity of `O(1)` due to no additional datastructure been used other than few sum variables.