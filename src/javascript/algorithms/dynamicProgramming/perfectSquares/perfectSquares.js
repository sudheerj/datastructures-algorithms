/**
 * Perfect Squares
 * 
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * 
 * A perfect square is an integer that is the square of an integer; 
 * in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * 
 * Time Complexity: O(n * sqrt(n))
 * Space Complexity: O(n)
 */

/**
 * Returns the least number of perfect square numbers that sum to n.
 * Bottom-up DP approach (similar to coin change).
 * 
 * @param {number} n - Target integer to represent as sum of perfect squares
 * @returns {number} - Minimum number of perfect squares that sum to n
 */
function numSquares(n) {
    if (typeof n !== "number" || n < 0 || !Number.isInteger(n)) {
        throw new Error("Input must be a non-negative integer");
    }
    
    // Initialize DP array with worst case (all 1s)
    const dp = new Array(n + 1).fill(n);
    dp[0] = 0;
    
    // For each target from 1 to n
    for (let target = 1; target <= n; target++) {
        // Try all perfect squares up to target
        for (let s = 1; s * s <= target; s++) {
            // Update minimum: current vs (1 + remaining)
            dp[target] = Math.min(dp[target], 1 + dp[target - s * s]);
        }
    }
    
    return dp[n];
}

// Test harness
const tests = [
    [12, 3],     // 12 = 4 + 4 + 4 (3 squares)
    [13, 2],     // 13 = 4 + 9 (2 squares)
    [1, 1],      // 1 = 1 (1 square)
    [2, 2],      // 2 = 1 + 1 (2 squares)
    [3, 3],      // 3 = 1 + 1 + 1 (3 squares)
    [4, 1],      // 4 = 4 (1 square)
    [7, 4],      // 7 = 4 + 1 + 1 + 1 (4 squares)
    [10, 2],     // 10 = 9 + 1 (2 squares)
    [25, 1],     // 25 = 25 (1 square)
    [26, 2],     // 26 = 25 + 1 (2 squares)
];

console.log("Perfect Squares - Test Results:");
console.log("=".repeat(50));

let passed = 0;
tests.forEach(([n, expected], index) => {
    const result = numSquares(n);
    const passTest = result === expected;
    
    if (passTest) passed++;
    
    const testNum = String(index + 1).padStart(2, ' ');
    const inputStr = String(n).padStart(2, ' ');
    const status = passTest ? "PASS" : "FAIL";
    
    console.log(`Test ${testNum} | Input: ${inputStr} | Output: ${result} | Expected: ${expected} | ${status}`);
});

console.log("=".repeat(50));
console.log(`Tests Passed: ${passed}/${tests.length}`);

module.exports = numSquares;
