# Better String Compression

Given a compressed string (e.g., "a3b2c1"), decompress and re-compress it by summing counts for repeated characters, preserving the order of first appearance.

## Examples

| Input                | Output      |
|----------------------|------------|
| a3b2c1               | a3b2c1     |
| a12b56c1a2           | a14b56c1   |
| x1y2z3x4             | x5y2z3     |
| a1b1c1d1e1f1         | a1b1c1d1e1f1|
| a10b10a10            | a20b10     |
| a1b2c3d4e5f6g7h8i9j10| a1b2c3d4e5f6g7h8i9j10|
| a1a1a1a1             | a4         |
| m5n10m5n10           | m10n20     |

## Algorithm

1. Parse the string, extracting each character and its count (which may be multiple digits).
2. Use a map to sum counts for each character, and a list to preserve the order of first appearance.
3. After parsing, output each character and its total count in order.

## Complexity
- **Time Complexity:** O(n), where n is the length of the string.
- **Space Complexity:** O(n), for the map and order list.

## Links
- [Java Implementation](./BetterStringCompression.java)
- [Python Implementation](../../../../python/algorithms/strings/betterStringCompression/better_string_compression.py)
- [JavaScript Implementation](../../../../javascript/algorithms/strings/betterStringCompression/betterStringCompression.js)
