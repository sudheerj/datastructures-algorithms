**Algorithmic Steps**
This problem is solved with the help of Two pointer approach(Expand around center). The algorithmic approach can be summarized as follows:

1. Write a preliminary check by returning the input string length when its size is less than 2.

2. Initialize count variable to 0, to store the palindromic substrings count.

3. Iterate over the input string using an iteration variable i(from 0 to length of string).

4. For each iteration, calculate the total count of odd palindromic substrings using a separate common function(step6). This common function accepts current iteration variable `i` as left and right pointer values.

5. For each iteration, calculate the total count of even palindromic substrings using a separate common function(step6). This common function accepts current iteration variable `i` as left and `i+1` as right pointer values.

6. The common function iterate over the given string using starting(i.e, left) and ending(i.e, right) index arguments. The left pointer is going to be decremented and right pointer is going to be incremented  whenever the respective character values are equal.

7. The sum of even and odd palindromic substring count is going to be returned as total count for palindromic substrings.


**Time and Space complexity:**
This algorithm has a time complexity of O(n * 2)( O(n * 2) + O(n * 2)) because either odd or event need to iterate over the input string atleast once which takes O(n) and substrings calculate on each position takes O(n). Also, it takes space complexity of O(1) without using any data structure.