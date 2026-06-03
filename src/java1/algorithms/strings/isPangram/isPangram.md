# Pangram Checker

Given a string, determine whether it is a pangram. A pangram is a sentence that contains every letter of the English alphabet at least once.

## Examples

| Input                                                        | Output        |
|-------------------------------------------------------------|--------------|
| "The quick brown fox jumps over the lazy dog"               | pangram      |
| "Hello World"                                               | not pangram  |
| "A quick movement of the enemy will jeopardize five gunboats" | not pangram  |
| "Sphinx of black quartz, judge my vow"                      | pangram      |
| "This sentence is not a pangram"                            | not pangram  |

## Algorithm

1. Initialize an empty set or boolean array to track unique alphabet characters.
2. Convert the string to lowercase and iterate through each character.
3. If the character is a letter (a-z), mark it as seen.
4. After processing all characters, check if all 26 letters are present.
5. Return "pangram" if all 26 letters are present, otherwise "not pangram".

## Complexity
- **Time Complexity:** O(n), where n is the length of the string.
- **Space Complexity:** O(1), as the set/array can hold at most 26 characters.

## Links
- [Java Implementation](./IsPangram.java)
- [Python Implementation](../../../../python/algorithms/strings/21.isPangram/is_pangram.py)
- [JavaScript Implementation](../../../../javascript/algorithms/strings/21.isPangram/isPangram.js)
