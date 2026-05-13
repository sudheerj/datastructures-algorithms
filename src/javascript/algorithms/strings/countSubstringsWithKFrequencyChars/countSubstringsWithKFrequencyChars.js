// Count Substrings With K Frequency Characters
// Given a string and an integer k, count substrings where at least one
// character appears at least k times.
// TC: O(n), SC: O(1)

function countSubstringsWithKFrequencyChars(str, k) {
  const n = str.length;
  const charFrequency = new Array(26).fill(0);
  let left = 0,
    right = 0,
    result = 0;

  while (right < n) {
    const rightIdx = str.charCodeAt(right) - 97;
    charFrequency[rightIdx]++;

    while (charFrequency[rightIdx] >= k) {
      result += n - right;
      const leftIdx = str.charCodeAt(left) - 97;
      charFrequency[leftIdx]--;
      left++;
    }

    right++;
  }

  return result;
}

// Test cases
const inputs = [
  "aabb",
  "aaaa",
  "abc",
  "aab",
  "abbc",
  "aabbc",
  "abc",
  "aaabbb",
  "a",
  "a",
];
const ks = [2, 2, 2, 2, 2, 2, 1, 3, 1, 2];
const expected = [5, 6, 0, 2, 4, 8, 6, 7, 1, 0];

for (let i = 0; i < inputs.length; i++) {
  const result = countSubstringsWithKFrequencyChars(inputs[i], ks[i]);
  const status = result === expected[i] ? "✓" : `✗ (expected ${expected[i]})`;
  console.log(`"${inputs[i]}", k=${ks[i]} => ${result} ${status}`);
}
