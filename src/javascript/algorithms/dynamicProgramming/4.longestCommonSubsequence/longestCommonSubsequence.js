/**
 * TC:O(m * n) SC:O(m* n)
 * Returns the length of the longest common subsequence between two strings using two dimensional bottom-up DP.
 * @param {string} str1
 * @param {string} str2
 * @returns {number}
 */
function lengthOfLCS(str1, str2) {

  const m = str1.length, n = str2.length;

  const dp = Array(m + 1)
    .fill()
    .map(() => Array(n + 1).fill(0));
  for (let i = m - 1; i >= 0; i--) {
    for (let j = n - 1; j >= 0; j--) {
      if (str1[i] === str2[j]) {
        dp[i][j] = 1 + dp[i + 1][j + 1];
      } else {
        dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
      }
    }
  }
  return dp[0][0];
}

/**
 * Returns the length of the longest common subsequence using recursion with memoization.
 * @param {string} str1
 * @param {string} str2
 * @returns {number}
 */
function lengthOfLCSRecursive(str1, str2) {

  const memo = {};
  function helper(i, j) {
    // Base case: if either string is fully traversed
    if (i >= str1.length || j >= str2.length) return 0;

    const key = `${i},${j}`;
    if (memo[key] !== undefined) return memo[key];
    if (str1[i] === str2[j]) {
      memo[key] = 1 + helper(i + 1, j + 1);
    } else {
      memo[key] = Math.max(helper(i + 1, j), helper(i, j + 1));
    }
    return memo[key];
  }
  return helper(0, 0);
}

/**
 * Returns the actual longest common subsequence string using bottom-up DP.
 * @param {string} str1
 * @param {string} str2
 * @returns {string}
 */
function getLCS(str1, str2) {

  const m = str1.length,
    n = str2.length;
  const dp = Array(m + 1)
    .fill()
    .map(() => Array(n + 1).fill(0));
  for (let i = m - 1; i >= 0; i--) {
    for (let j = n - 1; j >= 0; j--) {
      if (str1[i] === str2[j]) {
        dp[i][j] = 1 + dp[i + 1][j + 1];
      } else {
        dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
      }
    }
  }
  // Reconstruct LCS
  let i = 0,
    j = 0,
    lcs = "";
  while (i < m && j < n) {
    if (str1[i] === str2[j]) {
      lcs += str1[i];
      i++;
      j++;
    } else if (dp[i][j + 1] > dp[i + 1][j]) {
      j++;
    } else {
      i++;
    }
  }
  return lcs;
}

// Test cases
const testCases = [
  { str1: "abcdef", str2: "acbefd", expectedLen: 4, expectedLCS: "abef" },
  { str1: "abcd", str2: "efgh", expectedLen: 0, expectedLCS: "" },
  { str1: "", str2: "abc", expectedLen: 0, expectedLCS: "" },
  { str1: "abc", str2: "", expectedLen: 0, expectedLCS: "" },
  { str1: "abc", str2: "abc", expectedLen: 3, expectedLCS: "abc" },
  { str1: "abcde", str2: "ace", expectedLen: 3, expectedLCS: "ace" },
];

for (const { str1, str2, expectedLen, expectedLCS } of testCases) {
  console.log(
    `str1 = "${str1}", str2 = "${str2}" | DP: ${lengthOfLCS(
      str1,
      str2
    )} | Recursive: ${lengthOfLCSRecursive(str1, str2)} | LCS: "${getLCS(
      str1,
      str2
    )}" | Expected Length: ${expectedLen} | Expected LCS: "${expectedLCS}"`
  );
}

// Edge case: invalid input
try {
  lengthOfLCS(123, "abc");
} catch (e) {
  console.log("Error (as expected for invalid input):", e.message);
}
