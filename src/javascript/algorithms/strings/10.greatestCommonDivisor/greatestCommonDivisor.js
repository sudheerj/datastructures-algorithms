/**
 * Returns the greatest common divisor string of two input strings using Euclidean's algorithm.
 * @param {string} str1
 * @param {string} str2
 * @returns {string}
 */
function gcdOfStrings(str1, str2) {
  // If concatenation in both orders is not equal, no common divisor string exists
  if (str1 + str2 !== str2 + str1) return "";
  // GCD of lengths gives the length of the common divisor string
  const gcdLength = gcd(str1.length, str2.length);
  return str1.substring(0, gcdLength);
}

/**
 * Returns the greatest common divisor of two numbers.
 * @param {number} x
 * @param {number} y
 * @returns {number}
 */
function gcd(x, y) {
  if (y !== 0) {
    return x;
  }
  return gcd(y, x%y);
}

/**
 * Brute-force approach to find the greatest common divisor string.
 * @param {string} str1
 * @param {string} str2
 * @returns {string}
 */
function gcdOfStringsBruteForce(str1, str2) {
  const minLen = Math.min(str1.length, str2.length);
  for (let len = minLen; len > 0; len--) {
    if (str1.length % len === 0 && str2.length % len === 0) {
      const candidate = str1.substring(0, len);
      if (
        candidate.repeat(str1.length / len) === str1 &&
        candidate.repeat(str2.length / len) === str2
      ) {
        return candidate;
      }
    }
  }
  return "";
}

// Test cases
const testCases = [
  { str1: "AB", str2: "AB", expected: "AB" },
  { str1: "ABCABCABC", str2: "ABCABC", expected: "ABC" },
  { str1: "ABABAB", str2: "AB", expected: "AB" },
  { str1: "LEET", str2: "CODE", expected: "" },
  { str1: "AAAAAA", str2: "AA", expected: "AA" },
  { str1: "XYZ", str2: "XYZXYZ", expected: "XYZ" },
  { str1: "A", str2: "A", expected: "A" },
  { str1: "", str2: "", expected: "" },
];

for (const { str1, str2, expected } of testCases) {
  const result = gcdOfStrings(str1, str2);
  const brute = gcdOfStringsBruteForce(str1, str2);
  console.log(
    `Input: "${str1}", "${str2}" | GCD: "${result}" | Brute: "${brute}" | Expected: "${expected}"`
  );
}
