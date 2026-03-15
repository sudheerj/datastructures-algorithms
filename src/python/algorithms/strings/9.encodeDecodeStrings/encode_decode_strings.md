**Description:**

Write an algorithm to encode a list of strings to a single string, and then decode it back to the original list. Implement both `encode` and `decode` functions.

#### Examples

**Example 1:**  
Input: `["learn", "datastructure", "algorithms", "easily"]`  
Output: `["learn", "datastructure", "algorithms", "easily"]`

**Example 2:**  
Input: `["one", "two", "three"]`  
Output: `["one", "two", "three"]`

**Example 3:**  
Input: `["#", "##", "abc#def"]`  
Output: `["#", "##", "abc#def"]`

## Algorithm

### Encode

1. Initialize an empty string `encoded_str`.
2. For each string in the input list, append its length, a delimiter (e.g., `#`), and the string itself to `encoded_str`.
3. Return the concatenated string.

### Decode

1. Initialize an empty list `decoded_str_arr` and an index variable `i = 0`.
2. While `i` is less than the length of the encoded string:
    - Find the next delimiter (`#`) to determine the length prefix.
    - Parse the length, extract the substring of that length, and add it to the result list.
    - Move the index past the extracted substring and repeat.
3. Return the list of decoded strings.

## Complexity

- **Time Complexity:** O(n) for both encoding and decoding, where n is the total number of characters in all strings.
- **Space Complexity:** O(n), for the encoded string and the decoded list.