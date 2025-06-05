/**
 * Returns the number of distinct ways to climb to the top of a staircase with n steps,
 * where each time you can climb 1 or 2 steps.
 * Optimized DP (Fibonacci) approach.
 * @param {number} n - Number of steps
 * @returns {number}
 */
function climbStairsOptimized(n) {
  if (typeof n !== "number" || n < 0 || !Number.isInteger(n))
    throw new Error("Input must be a non-negative integer");
  if (n <= 2) return n;
  let first = 1,
    second = 1;
  for (let i = 2; i <= n; i++) {
    [first, second] = [second, first + second];
  }
  return second;
}

/**
 * Returns the number of distinct ways to climb to the top of a staircase with n steps,
 * using bottom-up DP with an array.
 * @param {number} n
 * @returns {number}
 */
function climbStairsDP(n) {
  if (typeof n !== "number" || n < 0 || !Number.isInteger(n))
    throw new Error("Input must be a non-negative integer");
  if (n <= 2) return n;
  const dp = new Array(n + 1).fill(0);
  dp[0] = 1;
  dp[1] = 1;
  for (let i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
  }
  return dp[n];
}

/**
 * Returns the number of distinct ways to climb to the top of a staircase with n steps,
 * using recursion with memoization.
 * @param {number} n
 * @returns {number}
 */
function climbStairsRecursive(n) {
  if (typeof n !== "number" || n < 0 || !Number.isInteger(n))
    throw new Error("Input must be a non-negative integer");
  const memo = {};
  function helper(k) {
    if (k <= 2) return k;
    if (memo[k]) return memo[k];
    return (memo[k] = helper(k - 1) + helper(k - 2));
  }
  return helper(n);
}

// Test cases
const testCases = [
  { n: 0, expected: 0 },
  { n: 1, expected: 1 },
  { n: 2, expected: 2 },
  { n: 3, expected: 3 },
  { n: 5, expected: 8 },
  { n: 6, expected: 13 },
  { n: 10, expected: 89 },
  { n: 20, expected: 10946 },
];

for (const { n, expected } of testCases) {
  console.log(
    `n = ${n} | Optimized: ${climbStairsOptimized(n)} | DP: ${climbStairsDP(
      n
    )} | Recursive: ${climbStairsRecursive(n)} | Expected: ${expected}`
  );
}

// Edge case: invalid input
try {
  climbStairsOptimized(-1);
} catch (e) {
  console.log("Error (as expected for n = -1):", e.message);
}
