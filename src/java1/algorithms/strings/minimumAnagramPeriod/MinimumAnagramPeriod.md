# Minimum Anagram Period

## Problem statement

Given a string `inputStr` containing lowercase English letters, choose a positive block length `p` that divides the string length. Split the string into consecutive blocks of length `p`. A block length is valid if every block has the same character frequencies (that is, each block is an anagram of every other block). Return the minimum valid block length.

## Examples

### Example 1

Input: `inputStr = "abcbcacba"`

Output: `3`

Explanation: The blocks are `"abc"`, `"bca"`, and `"cba"`; they are anagrams, and no smaller block length is valid.

### Example 2

Input: `inputStr = "ababbaab"`

Output: `2`

Explanation: The blocks are `"ab"`, `"ab"`, `"ba"`, and `"ab"`. Each block contains one `a` and one `b`.

### Example 3

Input: `inputStr = "aaaaaa"`

Output: `1`

Explanation: Every single-character block has the same frequency.

### Example 4

Input: `inputStr = "abc"`

Output: `3`

Explanation: The only valid divisor block length that can partition the string into anagram blocks is the full string length.

## Algorithm

1. Try candidate block lengths from `1` through the string length, considering only lengths that divide the total length.
2. Count the 26 lowercase-letter frequencies in the first block.
3. Count the frequencies in each following block and compare them with the first block.
4. Return the first candidate for which all blocks have identical frequencies.

The number of candidate lengths is at most `n`, and each candidate may scan up to `n` characters.

**Time complexity:** `O(n^2)` in the worst case.

**Space complexity:** `O(1)`, using fixed-size frequency arrays for 26 lowercase letters.

## Java implementation

[MinimumAnagramPeriod.java](./MinimumAnagramPeriod.java)
