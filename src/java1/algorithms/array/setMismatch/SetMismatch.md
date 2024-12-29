**Description:**
Given an integer array `nums` representing a set of numbers, where the set originally contained all integers from 1 to `n`. However, due to an error, one number in the set has been duplicated, and one number is missing. Find the duplicated number and the missing number in the array.

### Examples
Example 1:

Input: nums = [1,3,3,4]
Output: [ 3, 2 ]

Example 2:

Input: nums = [1,1]
Output: [ 1, 2 ]

**Algorithmic Steps**
This problem is solved with the help of array traversal and marking the numbers which exists by negating them. The algorithmic approach can be summarized as follows:

1. Create a function named `findDuplicateAndMissing`, which accepts input array(`nums`) to find the duplicated and missing numbers in the form of an array.
   
2. Calculate integers length with in `length` variable, and initialize `duplicated` and `missing` numbers to -1. 
   
3. Iterate over given array(`nums`) to find the duplicated value through marking of each number.
   
4. Iterate over given array(`nums`) again to find the missing number by checking each number is greater than zero or not.
   
5. Return an array with duplicated and missing values in the form of an array.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements in an array. This is because we need to iterate over all the elements at most twice for finding the duplicated and missing numbers.
 
It takes constant time complexity of `O(1)` without using any datastructures other than constant variables.