/**
 * Maximal Square (LeetCode 221)
 *
 * Find the largest square of 1s in a binary matrix and return its area.
 *
 * Approach: Dynamic Programming
 * TC: O(m*n)  SC: O(m*n)
 */

function maximalSquare(matrix) {
    const rows = matrix.length, cols = matrix[0].length;
    const dp = Array.from({ length: rows }, () => new Array(cols).fill(0));
    let maxSide = 0;

    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (matrix[r][c] === '1') {
                if (r === 0 || c === 0) {
                    dp[r][c] = 1;
                } else {
                    dp[r][c] = 1 + Math.min(dp[r-1][c], dp[r][c-1], dp[r-1][c-1]);
                }
                maxSide = Math.max(maxSide, dp[r][c]);
            }
        }
    }

    return maxSide * maxSide;
}

const testCases = [
    {
        matrix: [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']],
        expected: 4, label: "2x2 square"
    },
    { matrix: [['0','1'],['1','0']], expected: 1, label: "diagonal 1s" },
    { matrix: [['0']],              expected: 0, label: "all zeros" },
    { matrix: [['1','1','1'],['1','1','1'],['1','1','1']], expected: 9, label: "all ones 3x3" },
    { matrix: [['1']],              expected: 1, label: "single 1" },
];

testCases.forEach(({ matrix, expected, label }) => {
    const result = maximalSquare(matrix);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] ${label}: ${result} (expected ${expected})`);
});
