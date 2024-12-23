**Description:**
Given an integer array `nums`, find the number of identical pairs. 

**Note:** A pair `(i, j)` is called identical if `nums[i] == nums[j]` and `i < j`.

### Examples
Example 1:

Input: nums = [6, 3, 1, 5, 3, 6, 5, 6]
Output: 5

Example 2:

Input: nums = [2, 2, 2, 2],
Output: 6

Example 2:

Input: nums = [1, 2, 3, 4],
Output: 0

**Algorithmic Steps**
This problem is solved with the help of array traversal and map for storing the frequency of each number. The algorithmic approach can be summarized as follows:

1. Create a function named `findIdenticalPairs`, which accepts input array(`nums`) to find the number of identical pairs.
   
2. Initialize a `count` variale to 0, which indicates the number of identical pairs, and a frequency map(`frequencyMap`) to count the occurrances of each number in an array.
   
3. Iterate over given array(`num`), add the the number of times a number appeared to count variable if the number has been appeared before.

4. Increment the current number appeared by 1.
   
5. Return `count` variable, which indicate the number of identical paris formed.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements in an array. This is because we need to iterate over all the elements at most once for finding the identical pairs.
 
It takes constant time complexity of `O(n)` due to a map additional datastructure for storing the frequency of each number.