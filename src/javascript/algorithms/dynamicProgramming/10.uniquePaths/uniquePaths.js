//Dynamic programming:- TC:O(m*n) OC:O(n)
/**
 * Returns the number of unique paths in an m x n grid (1D DP approach)
 * @param {number} m - number of rows
 * @param {number} n - number of columns
 * @returns {number}
 */
function uniquePaths2(m, n) {
  let row = new Array(n).fill(1);

  for(let i=1; i<m; i++) {
    let newRow = new Array(n).fill(0);
    newRow[0] = 1;
    for(let j=1; j<n; j++) {
      newRow[j] = row[j] + newRow[j-1];
    }
    row = newRow;
  }
  return row[n-1];
}

/**Dynamic programming:- TC:O(m*n) OC:O(m*n)
 * Returns the number of unique paths in an m x n grid (2D DP optimized approach)
 * @param {number} m - number of rows
 * @param {number} n - number of columns
 * @returns {number}
 */
function uniquePaths1(m, n) {
  let dp = new Array(m).fill(0).map(x => new Array(n).fill(0));

  for(let i=0; i<m; i++) {
    for(let j=0; j<n; j++) {
      if(i === 0 || j === 0) {
        dp[i][j] = 1;
      } else {
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
      }
    }
  }
  return dp[m-1][n-1];
}

// Example usage
const examples = [
  { m: 4, n: 5 },
  { m: 3, n: 3 },
  { m: 1, n: 5 },
  { m: 5, n: 1 },
];
for (const { m, n } of examples) {
  console.log(`uniquePaths2(${m}, ${n}) =`, uniquePaths2(m, n));
  console.log(`uniquePaths1(${m}, ${n}) =`, uniquePaths1(m, n));
}
