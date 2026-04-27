## Restore IP Addresses

Given a string containing only digits, return all possible valid IP address combinations that can be formed by inserting dots into the string.

### Examples

**Example 1**
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]

**Example 2**
Input: "0000"
Output: ["0.0.0.0"]

**Example 3**
Input: "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

**Example 4**
Input: "1111"
Output: ["1.1.1.1"]

**Example 5**
Input: "010010"
Output: ["0.10.0.10","0.100.1.0"]

### Approach
- Use backtracking to try all possible placements of dots.
- At each step, add a segment if it is valid (0-255, no leading zeros except '0').
- Time Complexity: O(1) (since max 12 digits, constant number of splits)
- Space Complexity: O(1) for output, O(1) recursion stack
