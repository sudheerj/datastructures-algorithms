**Description:**
Given two strings `str1` and `str2`, return the largest string `x` such that it divides both `str1` and `str2`.

**Note:** For any two strings `a` and `b`, we say "b divides a" if and only if `a = b + b +... + a`.

### Examples
Example 1:
Input: ["AB", "AB"]
Output: ["AB"]

Example 2:
Input: ["ABCABCABC", "ABCABC"]
Output: ["ABCABC"]

Example 3:
Input: ["ABABAB", "AB"]
Output: ["AB"]


**Algorithmic Steps**
This problem is solved with the help of basic string operations and **Euclidean's** algorithm. The algorithmic approach can be summarized as follows:

1. Add a preliminary check if the two strings can be constructed from a common substring. It can be verified by comparing `str1+str2` with `str2+str1`. If they are not equal, there is no chanced of GCD.

2. Implement a gcd of two string lengths using Euclidean's algorithm.

3. Invoke the method created in step2 and assign to a variable `gcdLength`.

4. Return a substring on either of strings( `str1` or `str2`) using 0 as first argument and `gcdLength` as second argument.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n+m)` where `n` is the length of first string and `m` is the length of second string. This is because both the string concatenation and comparison takes will time complexity of `O(n+m)` individually. Also, Euclid's algorithm takes time complexity of `O(log(min(n, m)))`. So, the overall time complexity combining these operations resulting in `O(n + m + log(min(n, m))) ~= O(n+m)`.

Also, it takes space complexity of `O(n+m)` due to additional space required for concatenated strings.