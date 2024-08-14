**Description:**
Write a function that receives binary representation of an unsigned(or positive) integer and calculate the number of '1' bits(Set bits).

**Note:** In binary representation, hamming weight is the number of 1's.

## Example:
Example 1:
Input: num = 12
Output: 

Example 2:
Input: num = 128
Output: 5

**Algorithmic Steps:**
This problem is solved with the help of **Brian Kernighans** technique. The main intution behind this algorithm is that when you subtract 1 from an integer, all the bits following the rightmost set of bits are inverted. (i.e, turning 1 to 0 and 0 to 1). The algorithmic approach can be summarized as follows: 

1. Get the number `num` as input parameter.

2. Initialize the counter(`count`) to zero. This variable indicates the number of `1`s in the number. 

3. Iterate the number until it became zero. 
   
4. Update the number by multiplying the number itself with number which is subtracted by 1. It helps to invert the right most bit everytime.

5. Update the counter by one for each iteration.
   
6. Repeat 4-5 steps until the number is zero.

7. Return the `count` as output which is equal to number of `1` set bits.


**Time and Space complexity:**
This algorithm takes a time complexity of `O(1)`. This is because we are iterating the loop only for the `1` set bits but not for `0` bits. 

Here, we don't use any additional datastructure other than counter variable. Hence, the space complexity will be `O(1)`.