// Sliding window: TC: O(n), SC: O(1)
/**
 * Finds the length of the longest substring with the same letter after at most k replacements.
 * @param {string} str - The input string (uppercase English letters).
 * @param {number} k - The maximum number of allowed replacements.
 * @returns {number} The length of the longest valid substring.
 */
function longestCharReplacement(str, k) {
  const charCount = new Array(26).fill(0);
  let maxLength = 0,
    maxCharFrequency = 0,
    left = 0;

    for(let right = 0; right < str.length; right++) {
        maxCharFrequency = Math.max(maxCharFrequency, ++charCount[str.charCodeAt(right) - 65]);
        while((right-left+1-maxCharFrequency) > k) {
            charCount[str.charCodeAt(left) - 65]--;
            left++;
        }
        maxLength = Math.max(maxLength, right-left+1);
    }
    return maxLength;
}

// Test cases
const testCases = [
  { str: "AAABABBAA", k: 2, expected: 6 },
  { str: "BBBB", k: 2, expected: 4 },
  { str: "AABABBA", k: 1, expected: 4 },
  { str: "ABAB", k: 2, expected: 4 },
  { str: "ABCDE", k: 1, expected: 2 },
];

for (const { str, k, expected } of testCases) {
  const result = longestCharReplacement(str, k);
  console.log(
    `Input: "${str}", k=${k} | Output: ${result} | Expected: ${expected}`
  );
}
