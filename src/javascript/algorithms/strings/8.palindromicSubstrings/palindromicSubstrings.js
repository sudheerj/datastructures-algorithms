/**
 * TC:O(n*2) SC:O(1)
 * Counts the number of palindromic substrings in a given string using expand-around-center.
 * @param {string} str
 * @returns {number}
 */
function countPalindromicSubstrings(str) {
  if (!str || str.length < 1) return 0;
  let count = 0;
  for (let i = 0; i < str.length; i++) {
    count += expandAroundCenter(str, i, i); // Odd length palindromes
    count += expandAroundCenter(str, i, i + 1); // Even length palindromes
  }
  return count;
}

/**
 * Expands around the given center and counts palindromic substrings.
 * @param {string} str
 * @param {number} left
 * @param {number} right
 * @returns {number}
 */
function expandAroundCenter(str, left, right) {
  let count = 0;
  while (left >= 0 && right < str.length && str[left] === str[right]) {
    count++;
    left--;
    right++;
  }
  return count;
}

// Test cases
const testCases = [
  { str: "baaab", expected: 9 },
  { str: "abcd", expected: 4 },
  { str: "aaa", expected: 6 },
  { str: "", expected: 0 },
  { str: "a", expected: 1 },
  { str: "abccba", expected: 9 },
];

for (const { str, expected } of testCases) {
  const result = countPalindromicSubstrings(str);
  console.log(`Input: "${str}" | Output: ${result} | Expected: ${expected}`);
}
