// Edit Distance (Levenshtein Distance)
// TC: O(mn), SC: O(mn)

function editDistance(w1, w2) {
  const m = w1.length, n = w2.length;
  const dp = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));
  for (let i = 0; i < n; i++) dp[m][i] = n - i;
  for (let j = 0; j < m; j++) dp[j][n] = m - j;
  for (let i = m - 1; i >= 0; i--) {
    for (let j = n - 1; j >= 0; j--) {
      if (w1[i] === w2[j]) {
        dp[i][j] = dp[i + 1][j + 1];
      } else {
        dp[i][j] = 1 + Math.min(dp[i][j + 1], dp[i + 1][j], dp[i + 1][j + 1]);
      }
    }
  }
  return dp[0][0];
}

// Test cases
const testCases = [
  ["horse", "ros", 3],
  ["intention", "execution", 5],
  ["", "abc", 3],
  ["abc", "", 3],
  ["abc", "abc", 0],
  ["kitten", "sitting", 3],
  ["flaw", "lawn", 2],
  ["a", "b", 1],
  ["", "", 0],
];
for (const [w1, w2, expected] of testCases) {
  const result = editDistance(w1, w2);
  const status = result === expected ? "✓" : `✗ (expected ${expected})`;
  console.log(`"${w1}", "${w2}" => ${result} ${status}`);
}
