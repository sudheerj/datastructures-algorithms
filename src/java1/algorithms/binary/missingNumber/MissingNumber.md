**Description:**
Given an array `nums`, find a single missing number in an array that contains `n` unique numbers from the range `[0, n]`.

## Example:
Example 1:
Input: nums = [3, 1, 0]
Output: 2

Example 2:
Input: nums = [5, 9, 7, 1, 2, 4, 0, 6, 8, 3]
Output: 10

**Algorithmic Steps:**
This problem is solved with the help of **Bitwise XOR** operation. The XOR operation between matching indices of input array and values from the range [0, n] resulting into missing number. This is because the XOR operation between same numbers results into 0. The algorithmic approach can be summarized as follows: 

1. Get the number array `nums` as input parameter. This array is missing one number.

2. Initialize the missing number with the last element(i.e, length of input `nums` array) since an array is 0-indexed.
   
3. Iterate over each element until the end of input array.
   
4. Calculate the XOR operation between the current index and the element at that index. This calculated result needs to be XORed with current result. Since XOR operation with same number results into zero and a number XORed with zero is the number itself, it will leave us with missing number only.
   
5. Repeat the above step until the end of an array.
   
6. Return the missing number as output.


**Time and Space complexity:**
This algorithm takes a time complexity of `O(n)`, where `n` is the length of an array. This is because we are iterating through each element of an array exactly once..

Here, we don't use any additional datastructure other than variable to store missing number. Hence, the space complexity will be `O(1)`.