**Description:**
Given a string `s` containing only `R` and `L`, count the maximum number of balanced substrings obtainable after at most one adjacent swap. A substring is balanced when it contains the same number of `R` and `L`. The algorithm counts balanced prefixes, which identify consecutive balanced segments from the start of the string.

### Examples

Example 1:

Input: `s = "RRLL"`
Output: `2`
Explanation: Swapping the middle `RL` gives `"RLRL"`, which has two balanced segments: `"RL"` and `"RL"`.

Example 2:

Input: `s = "RLRL"`
Output: `2`
Explanation: The string already has two balanced segments, so no swap is needed.

Example 3:

Input: `s = "LLRR"`
Output: `2`
Explanation: Swapping the middle `LR` gives `"LRLR"`, which has two balanced segments.

Example 4:

Input: `s = "RR"`
Output: `0`
Explanation: No prefix contains equal numbers of `R` and `L`, and an adjacent swap cannot create a balanced prefix.

**Algorithmic Steps**
This solution uses prefix balance. Treat each `R` as `+1` and each `L` as `-1`; a prefix is balanced when its balance is zero.

1. Traverse the string and accumulate the prefix balance. Count each position where the balance is zero; this is the number of balanced segments without a swap.
2. Traverse adjacent character pairs while tracking the prefix balance through the first character in each pair.
3. For an `RL` pair, if that balance is `2`, swapping it to `LR` creates a new zero-balance prefix.
4. For an `LR` pair, if that balance is `-2`, swapping it to `RL` creates a new zero-balance prefix.
5. If either condition occurs, return the original count plus one. Otherwise, return the original count. A single adjacent swap can change the balance of only one prefix.

**Time and Space complexity:**
The time complexity is `O(n)`, where `n` is the length of `s`, because the string is traversed twice.

The extra space complexity is `O(1)`.

**Java Implementation:** [MaxEqualizedSubstrings.java](./MaxEqualizedSubstrings.java)
