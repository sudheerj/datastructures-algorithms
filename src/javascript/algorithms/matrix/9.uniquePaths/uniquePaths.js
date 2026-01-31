/**
 * Unique Paths
 *
 * A robot is located at the top-left corner of an m x n grid. The robot can only
 * move either down or right at any point. How many unique paths exist to reach
 * the bottom-right corner?
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(n) optimized
 */

/**
 * DP approach with space optimization
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
function uniquePaths(m, n) {
    // Each cell in current row only depends on cell above and cell to the left
    const dp = new Array(n).fill(1);

    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            dp[j] = dp[j] + dp[j - 1]; // paths from above + paths from left
        }
    }

    return dp[n - 1];
}

/**
 * DP approach with 2D array
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
function uniquePaths2D(m, n) {
    const dp = Array.from({ length: m }, () => new Array(n).fill(1));

    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }

    return dp[m - 1][n - 1];
}

/**
 * Mathematical approach using combinations
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
function uniquePathsMath(m, n) {
    // C(m+n-2, m-1) = (m+n-2)! / ((m-1)! * (n-1)!)
    let result = 1;
    for (let i = 1; i < m; i++) {
        result = result * (n - 1 + i) / i;
    }
    return Math.round(result);
}

// Test cases
console.log("Unique paths(3, 7):", uniquePaths(3, 7)); // 28
console.log("Unique paths(3, 2):", uniquePaths(3, 2)); // 3
console.log("Unique paths(7, 3):", uniquePaths(7, 3)); // 28
console.log("Unique paths(3, 3):", uniquePaths(3, 3)); // 6
console.log("Unique paths (math)(3, 7):", uniquePathsMath(3, 7)); // 28
