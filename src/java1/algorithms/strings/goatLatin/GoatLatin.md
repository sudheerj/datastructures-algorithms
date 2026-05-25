**Problem statement:**
A sentence is given in string `s`. Each word in the sentence must be converted to "Goat Latin" using these rules:
1. If a word begins with a vowel (`a, e, i, o, u` — case insensitive), append `"ma"` to the end.
2. If a word begins with a consonant, remove the first letter, append it to the end, then append `"ma"`.
3. Add one letter `"a"` to the end of each word per its 1-based position in the sentence (first word gets one `"a"`, second gets two, etc.).

Return the final sentence.

## Examples:

```
Input: s = "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

Input: s = "The quick brown fox jumped"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa"

Input: s = "Each word starts anew"
Output: "Eachmaa ordwmaaa tartssmaaaa anewmaaaaa"

Input: s = "I am"
Output: "Imaa ammaaa"

Input: s = "mad"
Output: "admmaa"
```

## Approach 1: String Parsing with Per-Token Transformation

**Algorithmic Steps**
1. Split the sentence by spaces to get individual words.
2. For each word at index `i` (0-based):
   - If the first character is a **consonant**, rotate it: `word = word[1:] + word[0]`.
   - Append `"ma"` to the word.
   - Append `(i + 1)` copies of `"a"` to the word.
3. Join all transformed words with spaces and return.

**Time and Space complexity:**

| Complexity | Value           |
|------------|-----------------|
| Time       | O(N + n²)       |
| Space      | O(N)            |

> N = total number of characters; n = number of words. The n² term comes from appending an increasing number of `"a"`s to each word.
