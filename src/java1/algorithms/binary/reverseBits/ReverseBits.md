**Description:**
Reverse the bits of a given 32-bit unsigned integer.

## Example:
Example 1:
Input: num = 4
Output: 536870912

Example 2:
Input: num = 8
Output: 268435456

**Algorithmic Steps:**
This problem is solved with the help of **Bitwise operations**. The main intution of this algorithm is to retrieve each bit individually from least significant bit to the most significant bit and place that bit in the reversed position of a new number. As a result, the least significant bits moved to most significant bit side and vice-versa. The algorithmic approach can be summarized as follows: 

1. Get the number `num` as input parameter.

2. Initialize the reverse bits number(`reverseBitResult`) to zero.
   
3. Iterate through each index(`i`) in the range of 32. This is because we are handling with a 32-bit unsigned integer.
   
4. Find the least significant bit of each index by applying right shift operation(i.e, `num >> i`). Thereafter, apply bitwise AND operation with 1, to know the bit value. This value is stored in `bit` variable.
   
5. Apply OR operation between reverse bit result and the calculated bit left shifted to place it in reversed position(i.e, `32-i`). The OR operation doesn't change the existing bits in the result.
   
6. Repeat 4-5 steps until each bit traversed.

7. Return the reverse bits number as inverted result.


**Time and Space complexity:**
This algorithm takes a time complexity of `O(32) -> O(1)`. This is because we are iterating through each index of 32-bit binary number.

Here, we don't use any additional datastructure other than variable to store reversed number. Hence, the space complexity will be `O(1)`.