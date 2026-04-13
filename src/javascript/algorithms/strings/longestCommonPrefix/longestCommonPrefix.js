// Longest Common Prefix
// Vertical scanning approach
// TC: O(S) where S = sum of all characters, SC: O(1)

function longestCommonPrefix(strs) {
  for (let i = 0; i < strs[0].length; i++) {
    const ch = strs[0][i];
    for (let j = 1; j < strs.length; j++) {
      if (i >= strs[j].length || strs[j][i] !== ch) {
        return strs[0].substring(0, i);
      }
    }
  }
  return strs[0];
}

// Test cases
const testCases = [
  [["flower", "flow", "flight"], "fl"],
  [["dog", "racecar", "car"], ""],
  [["interspecies", "interstellar", "interstate"], "inters"],
  [["a"], "a"],
  [["", "b"], ""],
  [["abc", "abc", "abc"], "abc"],
  [["ab", "a"], "a"],
  [["cir", "car"], "c"],
];

for (const [input, expected] of testCases) {
  const result = longestCommonPrefix(input);
  const status = result === expected ? "✓" : `✗ (expected "${expected}")`;
  console.log(`${JSON.stringify(input)} => "${result}" ${status}`);
}
