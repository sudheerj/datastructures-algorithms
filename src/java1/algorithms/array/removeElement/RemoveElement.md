**Description:**
Given an array of integers `nums` and an integer `val`, remove all occurrences of `val` from `nums` in-place and return the number of elements which are not equals to `val`.

### Examples
Example 1:

Input: nums = [4, 1, 1, 4, 1], val=4
Output: 3

Example 2:

Input: nums = [0, 3, 5, 5, 3, 1, 5, 2], val=5
Output: 5

**Algorithmic Steps**
This problem is solved with the help of iteration over an array. The algorithmic approach can be summarized as follows:

1. Initialize the index variable(`k`) for position the elements of an array(`nums`) which are not equal to given value(i.e, `val`).

2. Iterate over the array and compare each value with `val`. 

3. If the current value is not equal to `val`, store the current value in kth position and increment the index variable(i.e, `k++`).

4. After completion of iteration, the variable `k` indicates the number of elements which are not equal to given number.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements in an array. This is because we need to iterate over all the elements at most once.
 
It takes constant time complexity of `O(1)` due to no additional datastructure been used other than index variables.