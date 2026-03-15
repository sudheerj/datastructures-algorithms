**Description:**
A uniform string consists of a single repeating character. The weight of a character is its 1-indexed position in the alphabet (`a=1, b=2, ..., z=26`). The weight of a uniform string is the weight of its character times its length. Given a string and a list of queries (integers), determine for each query whether it is a weight of some uniform substring.

## Examples

**Example 1:**  
Input: `s = "abccddde"`, queries = `[1, 3, 12, 5, 9, 10]`  
Output: `["Yes", "Yes", "Yes", "Yes", "No", "No"]`

**Example 2:**  
Input: `s = "aaabbbbcccddd"`, queries = `[9, 7, 8, 12, 5]`  
Output: `["Yes", "No", "Yes", "Yes", "No"]`

**Example 3:**  
Input: `s = "abcd"`, queries = `[1, 2, 3, 4, 5]`  
Output: `["Yes", "Yes", "Yes", "Yes", "No"]`

## Algorithm

1. Initialize an empty set `weights`, a variable `curr_weight = 0`, and `prev_char = ""`.
2. Iterate through each character of the string.
3. If the current character is the same as the previous one, add its weight to `curr_weight` (extending the uniform substring).
4. Otherwise, reset `curr_weight` to the current character's weight and update `prev_char`.
5. Add `curr_weight` to the set.
6. For each query, check if it exists in the set and return `"Yes"` or `"No"`.

## Complexity

- **Time Complexity:** O(n + q), where n is the length of the string and q is the number of queries.
- **Space Complexity:** O(n), for the set of weights.