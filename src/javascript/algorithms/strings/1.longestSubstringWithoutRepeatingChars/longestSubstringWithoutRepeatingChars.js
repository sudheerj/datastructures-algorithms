// Sliding window: TC: O(n), SC: O(min(n, m))
/**
 * Finds the length of the longest substring without repeating characters.
 * @param {string} str
 * @returns {number} Length of the longest substring without repeating characters.
 */
function longestSubstringLengthWithoutRepeatingChar(str) {
  let charSet = new Set();
  let left = 0,
    right = 0,
    maxLength = 0;

  while (right < str.length) {
    while (charSet.has(str[right])) {
      charSet.delete(str[left]);
      left++;
    }
    charSet.add(str[right]);
    right++;
    maxLength = Math.max(maxLength, charSet.size);
  }
  return maxLength;
}

//Additional problem
function longestSubstringWithoutRepeatingChar(str) {
  let charSet = new Set();
  let left = 0,
    right = 0,
    start = 0,
    maxLength = 0;

  while (right < str.length) {
    while (charSet.has(str[right])) {
      charSet.delete(str[left]);
      left++;
    }
    charSet.add(str[right]);
    right++;
    if (charSet.size > maxLength) {
      start = left;
      maxLength = charSet.size;
    }
  }
  return str.substring(start, start + maxLength);
}

// Test cases
const testStrings = [
  "abcabcbbaa", // 3
  "aaaaaaa", // 1
  "pwwkew", // 3
  "dvdf", // 3
  "", // 0
  "abcdef", // 6
];

for (const s of testStrings) {
  console.log(
    `Input: "${s}" | Length: ${longestSubstringLengthWithoutRepeatingChar(
      s
    )} | Substring: "${longestSubstringWithoutRepeatingChar(s)}"`
  );
}
