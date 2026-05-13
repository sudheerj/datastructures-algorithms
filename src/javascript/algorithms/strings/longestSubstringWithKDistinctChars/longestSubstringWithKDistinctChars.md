**Description:**
Given a string `str` and an integer `k`, find the length of the longest substring that contains at most `k` distinct characters.

### Examples

Example 1:
Input: str = "araaci", k = 2
Output: 4
Explanation: The longest substring with at most 2 distinct characters is "araa".

Example 2:
Input: str = "araaci", k = 1
Output: 2
Explanation: The longest substring with at most 1 distinct character is "aa".

Example 3:
Input: str = "cbbebi", k = 3
Output: 5
Explanation: The longest substring with at most 3 distinct characters is "bbebi".

Example 4:
Input: str = "aabbcc", k = 2
Output: 4
Explanation: The longest substrings with at most 2 distinct characters are "aabb" or "bbcc".

Example 5:
Input: str = "abc", k = 3
Output: 3
Explanation: The entire string has exactly 3 distinct characters.

Example 6:
Input: str = "", k = 2
Output: 0
Explanation: Empty string returns 0.

Example 7:
Input: str = "aaa", k = 0
Output: 0
Explanation: k = 0 means no characters allowed, so result is 0.

**Algorithmic Steps**
This problem is solved with the help of the **sliding window** approach using a Map. The algorithmic approach can be summarized as follows:

1. Add preliminary corner case conditions: if the string is empty/null or `k` is 0, return 0.

2. Initialize a Map (`charFreq`) to store each character in the current window and its frequency.

3. Initialize `maxLength` to 0 to track the longest valid window seen so far, and `left` pointer to 0.

4. Iterate through the string using a `right` pointer.

5. Add the current character (`str[right]`) to the map and increment its frequency.

6. While the map contains more than `k` distinct characters, shrink the window from the left: decrement the frequency of `str[left]`, delete it from the map if its frequency reaches 0, then increment `left`.

7. Update `maxLength` with the current window size (`right - left + 1`) if it is larger.

8. Repeat steps 5–7 until the `right` pointer reaches the end of the string.

9. Return `maxLength`.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the length of the string, because each character is added and removed from the window at most once.

Also, it requires a space complexity of `O(k)` for the Map, which stores at most `k + 1` distinct characters at any time.
