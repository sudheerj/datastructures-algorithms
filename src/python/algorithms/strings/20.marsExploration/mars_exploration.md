**Description:**
A rover on Mars sends a repeated `"SOS"` message back to Earth, but some letters may be altered during transmission. Given the received message, count the number of letters that were changed.

## Examples

**Example 1:**  
Input: `"SOSSPSSQSSOR"`  
Output: `3`

**Example 2:**  
Input: `"SOSSOT"`  
Output: `1`

**Example 3:**  
Input: `"SOSSOSSOS"`  
Output: `0`

**Example 4:**  
Input: `"SSSSSS"`  
Output: `2`

## Algorithm

1. Initialize a counter `altered_count` to `0`.
2. Define the expected pattern as `"SOS"`.
3. Iterate through each character of the received string.
4. Compare each character against the expected character at position `i % 3`.
5. If they differ, increment the counter.
6. Return the total count of altered characters.

## Complexity

- **Time Complexity:** O(n), where n is the length of the string.
- **Space Complexity:** O(1), as only a counter variable is used.