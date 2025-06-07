// TC: O(n * m * k), SC: O(n)
function wordBreak(str, wordDict) {

  const dp = new Array(str.length + 1).fill(false);
  dp[str.length] = true;
  for (let i = str.length - 1; i >= 0; i--) {
    for (let word of wordDict) {
      // Check if the substring matches the word
      if (i + word.length <= str.length && str.startsWith(word, i)) {
        if (dp[i + word.length]) {
          dp[i] = true;
          break; // No need to check more words if true
        }
      }
    }
  }
  return dp[0];
}

// Test cases
let testCases = [
  { s: "applepenapple", dict: ["pen", "apple"] },
  { s: "catsandog", dict: ["cats", "dog", "sand", "and", "cat"] },
  { s: "", dict: ["a"] }, // Edge: empty string
  { s: "a", dict: [] }, // Edge: empty dict
  { s: "leetcode", dict: ["leet", "code"] },
  { s: "aaaaaaa", dict: ["aaaa", "aaa"] },
];
for (const { s, dict } of testCases) {
  console.log(
    `Input: '${s}', Dict: ${JSON.stringify(dict)} | WordBreak: ${wordBreak(
      s,
      dict
    )}`
  );
}
