**Description:**
Given two strings `s` and `t` of lengths `m` and `n` respectively, return the minimum window substring of `s` such that every character in `t` (including duplicates) is included in the window. If there is no such substring, return the empty string `""`.

## Examples

**Example 1:**  
Input: `s = "ADOBECODEBANC", t = "ABC"`  
Output: `"BANC"`

**Example 2:**  
Input: `s = "a", t = "a"`  
Output: `"a"`

**Example 3:**  
Input: `s = "a", t = "aa"`  
Output: `""`

## Approaches

### 1. Sliding Window
In this approach, two pointers (`left`, `right`) maintain a sliding window over `s`. The window is expanded by moving `right` until all characters in `t` are covered, then shrunk from the `left` to find the minimum valid window. The algorithmic approach can be summarized as follows:

1. Build a frequency map (`substr_count`) for characters in `t` using `Counter`.
2. Track `required` — the number of unique characters in `t` that need to be satisfied.
3. Expand the window by moving `right`:
   - Update `window_str_count` with the new character.
   - If the character's window count matches its required count in `t`, increment `having`.
4. When `having == required`, the current window is valid:
   - Update the best window if the current one is smaller.
   - Shrink from the `left` — decrement counts and adjust `having` as needed.
5. Return the smallest valid window, or `""` if none was found.

## Complexity

The algorithm takes a time complexity of `O(m + n)`, where `m` represents the length of string `s` and `n` represents the length of string `t`. This is because each character in `s` is visited at most twice (once by `right`, once by `left`), and building the frequency map for `t` takes `O(n)`.
Also, it requires space complexity of `O(m + n)` due to the two hash maps storing character frequencies.

| Approach       | Time Complexity | Space Complexity |
| -------------- | --------------- | ---------------- |
| Sliding Window | O(m + n)        | O(m + n)         |

- `m` = length of string `s`
- `n` = length of string `t`
