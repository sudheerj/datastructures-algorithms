// Palindrome Permutation
// Given a string, determine if a permutation of the string could form a palindrome.
// TC: O(n), SC: O(1)

function canPermutePalindrome(str) {
  const oddSet = new Set();
  for (const ch of str) {
    if (oddSet.has(ch)) {
      oddSet.delete(ch);
    } else {
      oddSet.add(ch);
    }
  }
  return oddSet.size <= 1;
}

// Test cases
const testCases = ["aab", "code", "carerac", "", "a", "aa", "ab", "aaabbbb", "aabbccdd"];
const expected  = [true,  false,  true,      true, true, true, false, true,    true];

for (let i = 0; i < testCases.length; i++) {
  const result = canPermutePalindrome(testCases[i]);
  const status = result === expected[i] ? "✓" : `✗ (expected ${expected[i]})`;
  console.log(`"${testCases[i]}" => ${result} ${status}`);
}
