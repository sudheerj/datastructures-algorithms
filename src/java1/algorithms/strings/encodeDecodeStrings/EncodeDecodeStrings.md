**Description:**
Write an algorithm to encode a list of strings to a single string. After that, the encoded string is decoded back to the original list of strings. Please implement `encode` and `decode`

### Examples
Example 1:
Input: ["learn", "datastructure", "algorithms", "easily"]
Output: ["learn", "datastructure", "algorithms", "easily"]

Example 2:
Input: ["one", "two", "three"]
Output: ["one", "two", "three"]


**Algorithmic Steps**
This problem is solved with the help of basic string and array built-in operations. The algorithmic approach can be summarized as follows:

**Encode string**
1. Initialize an empty string(`encodedStr`) to store the encoded string.

2. Iterate over the array of strings. For each string iteration, add a prefix with the combination of string length and special(`#`) symbol before each word/string.

3. Return the encoded string as an output.

**Decode string**

1. Initialize an empty array(`decodedStringsList`) to store the decoded string.

2. Initialize an index variable(`i`) to 0, which is used to iterate over the input string.

3. Iterate over an input string until the end of its length.

4. Create a temporary variable(`j`) which is assigned to index variable.

5. Skip the prefix related to each string's length until the character reaches special(`#`) symbol. The number of characters ignored are indicated by incremental value of `j`. The next character position(`j+1`) indicates the beginning of a string.

6. Calculate the word length followed by substring using the index variables.

7. Add each substring to the decoded string list. Also, increment the index variable to be used for the next substring.

8. Repeat steps 4-7 until all the strings decoded and return the decoded strings.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)` for both encoding and decoding functions, where `n` is the number of total characters for each string in the input array. This is because we need to iterate over each string in the array to perform constant-time operations for encoding operation. In the same way, we need iterate over all the characters of a encoded string for decoding operation.

Also, it takes space complexity of `O(n)` to store all the characters.