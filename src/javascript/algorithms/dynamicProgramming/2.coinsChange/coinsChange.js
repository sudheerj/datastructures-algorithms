/**
 * Returns the minimum number of coins needed to make up the given amount.
 * Uses bottom-up dynamic programming.
 * @param {number[]} coins - Array of coin denominations (positive integers)
 * @param {number} amount - Target amount (non-negative integer)
 * @returns {number} Minimum number of coins, or -1 if not possible
 */
function coinChangeDP(coins, amount) {

  const dp = new Array(amount + 1).fill(amount + 1);
  dp[0] = 0;
  for (let i = 1; i <= amount; i++) {
    for (const coin of coins) {
      if (i - coin >= 0) {
        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
      }
    }
  }
  return dp[amount] === amount + 1 ? -1 : dp[amount];
}

/**
 * Returns the minimum number of coins needed to make up the given amount.
 * Uses recursion with memoization.
 * @param {number[]} coins
 * @param {number} amount
 * @returns {number}
 */
function coinChangeRecursive(coins, amount) {

  const memo = {};
  function helper(rem) {
    if (rem === 0) return 0;
    if (rem < 0) return Infinity;
    if (memo[rem] !== undefined) return memo[rem];
    let min = Infinity;
    for (const coin of coins) {
      min = Math.min(min, 1 + helper(rem - coin));
    }
    memo[rem] = min;
    return min;
  }
  const res = helper(amount);
  return res === Infinity ? -1 : res;
}

// Test cases
const testCases = [
  { coins: [1, 3, 4, 5], amount: 7, expected: 2 },
  { coins: [2, 4], amount: 3, expected: -1 },
  { coins: [1], amount: 0, expected: 0 },
  { coins: [2], amount: 1, expected: -1 },
  { coins: [1, 2, 5], amount: 11, expected: 3 },
  { coins: [], amount: 5, expected: -1 },
  { coins: [2, 5, 10, 1], amount: 27, expected: 4 },
];

for (const { coins, amount, expected } of testCases) {
  console.log(
    `coins = [${coins}], amount = ${amount} | DP: ${coinChangeDP(
      coins,
      amount
    )} | Recursive: ${coinChangeRecursive(
      coins,
      amount
    )} | Expected: ${expected}`
  );
}

// Edge case: invalid input
try {
  coinChangeDP([1, -2], 5);
} catch (e) {
  console.log("Error (as expected for invalid coins):", e.message);
}
try {
  coinChangeDP([1, 2], -5);
} catch (e) {
  console.log("Error (as expected for negative amount):", e.message);
}
