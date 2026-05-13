**Description:**
Given a string `str` and an integer `k`, count the number of substrings where at least one character appears at least `k` times.

### Examples

Example 1:
Input: str = "aabb", k = 2
Output: 5
Explanation: Substrings where some character has frequency ≥ 2: "aa", "aab", "aabb", "abb", "bb".

Example 2:
Input: str = "aaaa", k = 2
Output: 6
Explanation: Substrings: "aa"(0-1), "aa"(1-2), "aa"(2-3), "aaa"(0-2), "aaa"(1-3), "aaaa"(0-3) = 6.

Example 3:
Input: str = "abc", k = 2
Output: 0
Explanation: No character appears 2 or more times in any substring of "abc".

Example 4:
Input: str = "aab", k = 2
Output: 2
Explanation: Substrings: "aa" and "aab" (both have 'a' appearing twice).

Example 5:
Input: str = "abbc", k = 2
Output: 4
Explanation: Substrings: "bb", "abb", "bbc", "abbc".

Example 6:
Input: str = "aabbc", k = 2
Output: 8
Explanation: Substrings with a character frequency ≥ 2: "aa","aab","aabb","aabbc","abb","abbc","bb","bbc".

Example 7:
Input: str = "abc", k = 1
Output: 6
Explanation: Every non-empty substring has at least one character with frequency ≥ 1.

Example 8:
Input: str = "aaabbb", k = 3
Output: 7
Explanation: Substrings: "aaa","aaab","aaabb","aaabbb","aabbb","abbb","bbb".

Example 9:
Input: str = "a", k = 1
Output: 1
Explanation: The only substring "a" has 'a' with frequency 1 ≥ k=1.

Example 10:
Input: str = "a", k = 2
Output: 0
Explanation: No substring of "a" has any character appearing 2 or more times.

**Algorithmic Steps**
This problem is solved with the help of the **sliding window** (two-pointer) approach. The algorithmic approach can be summarized as follows:

1. Initialize a frequency array `charFrequency` of size 26 (one slot per lowercase letter) to track character counts in the current window.

2. Initialize `left`, `right`, and `result` all to 0.

3. Iterate with `right` pointer through the string until it reaches the end.

4. Increment the frequency of the character at `right` in `charFrequency`.

5. While the frequency of the current `rightChar` is ≥ `k`, all substrings that start at any index from `left` to `right` and end at `right` (or any index from `right` to `n-1`) contain `rightChar` at least `k` times. Add `n - right` to `result`.

6. Shrink the window from the left: decrement the frequency of `str[left]` and advance `left`. Repeat step 5 until the condition no longer holds.

7. Increment `right` and repeat steps 4–6.

8. Return `result`.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the length of the string, because each character is processed by the `left` and `right` pointers at most once.

Also, it requires a space complexity of `O(1)` (specifically `O(26)`) for the fixed-size frequency array.
