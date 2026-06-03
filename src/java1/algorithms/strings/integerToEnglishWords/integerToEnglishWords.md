# Integer to English Words

Convert a non-negative integer to its English words representation.

## Examples

| Input         | Output                                                                 |
|-------------- |------------------------------------------------------------------------|
| 0             | Zero                                                                   |
| 5             | Five                                                                   |
| 13            | Thirteen                                                               |
| 20            | Twenty                                                                 |
| 45            | Forty Five                                                             |
| 100           | One Hundred                                                            |
| 123           | One Hundred Twenty Three                                               |
| 1000          | One Thousand                                                           |
| 12345         | Twelve Thousand Three Hundred Forty Five                               |
| 1000000       | One Million                                                            |
| 1000000000    | One Billion                                                            |
| 1234567891    | One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One |

## Algorithm

1. Divide the number into 3-digit chunks (thousands grouping).
2. For each chunk, convert it to words using recursion and arrays for below 20 and tens.
3. Append the appropriate thousand/million/billion label.
4. Concatenate all parts and trim spaces.

## Complexity
- **Time Complexity:** O(1) (since the number of digits is bounded)
- **Space Complexity:** O(1)

## Links
- [Java Implementation](./IntegerToEnglishWords.java)
- [Python Implementation](../../../../python/algorithms/strings/integerToEnglishWords/integer_to_english_words.py)
- [JavaScript Implementation](../../../../javascript/algorithms/strings/integerToEnglishWords/integerToEnglishWords.js)
