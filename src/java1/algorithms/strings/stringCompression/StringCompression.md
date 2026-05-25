**Problem statement:**
Given an array of characters `chars`, compress it in-place using the following algorithm: For each group of consecutive repeating characters, write the character followed by its count (if the count is greater than 1). The count must be written as individual digits. Return the new length of the array after compression.

## Examples:

```
Input: chars = ['a','a','b','b','c','c','c']
Output: 6, chars = ['a','2','b','2','c','3']

Input: chars = ['a']
Output: 1, chars = ['a']

Input: chars = ['a','b','b','b','b','b','b','b','b','b','b','b','b']
Output: 4, chars = ['a','b','1','2']
```

## Approach 1: Two Pointers

**Algorithmic Steps**
1. Use two pointers: `read` (scans input) and `write` (writes compressed output into `chars`).
2. For each new character at `chars[read]`, count how many times it repeats consecutively by advancing `read`.
3. Write the character at `chars[write++]`.
4. If `count > 1`, convert it to a string and write each digit character into `chars[write++]`.
5. Repeat until `read` reaches the end of the array.
6. Return `write` as the new length.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(1)  |
