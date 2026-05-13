// Longest Substring With K Distinct Characters
// Given a string and an integer k, find the length of the longest substring
// that contains at most k distinct characters.
// TC: O(n), SC: O(k)

function longestSubstringWithKDistinctChars(str, k) {
  if (!str || k === 0) return 0;
  const charFreq = new Map();
  let maxLength = 0;
  let left = 0;

  for (let right = 0; right < str.length; right++) {
    const ch = str[right];
    charFreq.set(ch, (charFreq.get(ch) || 0) + 1);

    while (charFreq.size > k) {
      const leftChar = str[left];
      charFreq.set(leftChar, charFreq.get(leftChar) - 1);
      if (charFreq.get(leftChar) === 0) {
        charFreq.delete(leftChar);
      }
      left++;
    }

    maxLength = Math.max(maxLength, right - left + 1);
  }

  return maxLength;
}

// Test cases
const inputs   = ["araaci", "araaci", "cbbebi", "aabbcc", "abc", "abc", "", "aaa", "a", "abaccc"];
const ks       = [2,        1,        3,        2,        3,     1,    2,  0,   1,   2];
const expected = [4,        2,        5,        4,        3,     1,    0,  0,   1,   4];

for (let i = 0; i < inputs.length; i++) {
  const result = longestSubstringWithKDistinctChars(inputs[i], ks[i]);
  const status = result === expected[i] ? "✓" : `✗ (expected ${expected[i]})`;
  console.log(`"${inputs[i]}", k=${ks[i]} => ${result} ${status}`);
}
