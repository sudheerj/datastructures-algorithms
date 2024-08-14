**Description:**
Given a positive integer `num`, return a list `ans` of length `n + 1` where each element `ans[i]` represents the count of 1 bits in the binary representation of i(`0<=i<=n`).

## Example:
Example 1:
Input: num = 3
Output: [0, 1, 1, 2]

Example 2:
Input: num = 6
Output: [0, 1, 1, 2, 1, 2, 2]

**Algorithmic Steps:**
This problem is solved with the help of **dynamic programming** technique where previous results going to be reused to calculate the current results. The algorithmic approach can be summarized as follows: 

1. Get the number `num` as input parameter.

2. Initialize the `ans` array with a length of `num+1` where each element assigned to zero by default. This array indicates the number of `1`s in each element from `0` to `num`. 

3. Initialize the offset(`offset`) variable to 1. This is because the first offset with power of 2 is 1(i.e, 2 power 0). In this problem, you can find pattern that offset is multiplied by 2 when the index value is power of 2.
   
4. Iterate over each element upto `num` to find the counting bits.
   
5. The offset should be updated to the index variable(`i`) once the offset multiplied by 2 is equal to index variable.
   
6. If the condition in step5 fails, the number of 1's for current number is calculated by adding the number of 1's in previous power of 2 index variable with 1.
   
7. Repeat 5-6 steps to calculate the number of set bits for each element.

8. Return the `ans` array which holds number of set bits upto input number.

**Time and Space complexity:**
This algorithm takes a time complexity of `O(n)`. This is because we are iterating elements upto `n`.

Here, we need to use array to hold the number of set bits for each element. Hence, the space complexity will be `O(n)`.