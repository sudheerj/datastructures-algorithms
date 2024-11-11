**Description:**
Given an integer array `nums` of size `n`, find the majority element from an array. The majority element is defined as the element that appears more than ⌊n / 2⌋ times.

**Note:** The majority element always exists in an array.

### Examples
Example 1:

Input: nums = [5,4,5,5]
Output: 5

Example 2:

Input: nums = [3,4,3,5,3,3,1,3]
Output: 3

**Algorithmic Steps**
This problem is solved with the help of Boyer Moore Voting algorithm. The algorithmic approach can be summarized as follows:

1. Create a function(`majorityElement`) by accepting integer array(`nums`) to determine the majority element.

2. Initialize the counting variable(`count`) to determine number of occurances of an element. The default of majority element(`candidate`) is initialized to `0`.

3. Iterate over the array, and for each iteration compare the counting variable equals to 0 or not. 
    1. If count value is equals to zero, update the candidate value with current element. 

    2. The counter value will be incremented by 1 if both candidate and current element are same, otherwise the counter is decremented by 1.
   
    3. Since there is a gurantee of majority element, you don't need to verify whether the calculated element is majority element or not. i.e, majority element occurs more than half of array(`n/2`) times, where `n` is the length of given array.
   
 4. After completion of iteration, return candidate value to represent majority element in the given number.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements in an array. This is because we need to iterate over all the elements at most once.
 
It takes constant time complexity of `O(1)` due to no additional datastructure been used other than counting variable.