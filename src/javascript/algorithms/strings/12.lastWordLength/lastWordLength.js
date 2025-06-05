/**
 * Returns the length of the last word in a string.
 * A word is a maximal substring of non-space characters.
 * @param {string} str
 * @returns {number}
 */
function lengthOfLastWord(str) {
  let i = str.length - 1;
  let length = 0;

  // Skip trailing spaces
  while (i >= 0 && str[i] === " ") i--;

  // Count the length of the last word
  while (i >= 0 && str[i] !== " ") {
    length++;
    i--;
  }

  return length;
}

// Test cases
const testCases = [
  { str: "Welcome to DSA", expected: 3 },
  { str: " My pet is fluffy  ", expected: 6 },
  { str: "singleword", expected: 10 },
  { str: "   ", expected: 0 },
  { str: "", expected: 0 },
  { str: "a b c d", expected: 1 },
  { str: "endswithspace ", expected: 13 },
];

for (const { str, expected } of testCases) {
  const result = lengthOfLastWord(str);
  console.log(`Input: "${str}" | Output: ${result} | Expected: ${expected}`);
}
