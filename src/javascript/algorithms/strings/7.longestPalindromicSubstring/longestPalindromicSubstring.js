/**
 * Finds the longest palindromic substring in a given string using expand-around-center.
 * @param {string} str
 * @returns {string}
 */
function longestPalindromicSubstring(str) {
  if (!str || str.length <= 1) return str;

  let left = 0,
    right = 0;

  for (let i = 0; i < str.length; i++) {
    // Odd length palindrome
    let [left1, right1] = expandAroundCenter(str, i, i);
    // Even length palindrome
    let [left2, right2] = expandAroundCenter(str, i, i + 1);

    if (right1 - left1 > right - left) {
      left = left1;
      right = right1;
    }
    if (right2 - left2 > right - left) {
      left = left2;
      right = right2;
    }
  }
  return str.substring(left, right + 1);
}

/**
 * Expands around the given center and returns the bounds of the palindrome.
 * @param {string} str
 * @param {number} left
 * @param {number} right
 * @returns {[number, number]}
 */
function expandAroundCenter(str, left, right) {
  while (left >= 0 && right < str.length && str[left] === str[right]) {
    left--;
    right++;
  }
  return [left + 1, right - 1];
}

// Test cases
const testCases = [
  { str: "ababd", expected: "aba" },
  { str: "dbbc", expected: "bb" },
  { str: "babad", expected: "bab" }, // or "aba"
  { str: "cbbd", expected: "bb" },
  { str: "a", expected: "a" },
  { str: "ac", expected: "a" }, // or "c"
  { str: "", expected: "" },
];

for (const { str, expected } of testCases) {
  const result = longestPalindromicSubstring(str);
  console.log(
    `Input: "${str}" | Output: "${result}" | Expected: "${expected}"`
  );
}
