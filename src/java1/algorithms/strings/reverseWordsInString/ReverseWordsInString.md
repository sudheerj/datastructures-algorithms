**Description:**
Given an input string `str`, Return a string of the words in reverse order concatenated by a single space without having extra spaces.

### Examples
Example 1:
Input: "It is fun to learn DSA"
Output: "DSA learn to fun is It"

Example 2:
Input: "hello DSA"
Output: "DSA hello"

**Algorithmic Steps**
This problem is solved with the help of basic string and array operations. The algorithmic approach can be summarized as follows:

1. Split the input sentence `str` into array of words based on a space separator(one or more spaces). Store the result into `words` variable.

2. Initialize two pointers (`left` and `right`) pointing to the beginning and ending index of the sentence.

3. Iterate over the input sentence until left pointer is less than or equal to right pointer.

4. Swap the words indexed with left and right pointers.

5. Shrink the window by incrementing left pointer and decrementing the right pointer.

6. Repeat steps 4-5 until the iteration condition failed.

7. Join the reversed words with a space delimiter and return the result.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)` where `n` is the length of first string. This is because we need to traverse the string at once for splitting the string based on a space, reversing the string, and joining the words back to a string. All these operations requires `O(n)`. Since all these operations performed sequentially, the overall time complexity combining these operations doesn't exceed `O(n)`.

Also, it takes space complexity of `O(n)` due to storing all the characters in an array.