/**
 * Transpose of a Matrix
 *
 * Given a 2D integer array matrix, return the transpose of matrix.
 * The transpose swaps matrix[r][c] with matrix[c][r].
 *
 * TC: O(m * n)
 * SC: O(m * n)
 */

function transpose(matrix) {
    const rows = matrix.length;
    const cols = matrix[0].length;
    const result = Array.from({ length: cols }, () => new Array(rows).fill(0));

    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            result[c][r] = matrix[r][c];
        }
    }

    return result;
}

const testCases = [
    {
        matrix: [[1,2,3],[4,5,6]],
        expected: [[1,4],[2,5],[3,6]],
        label: "2x3 → 3x2",
    },
    {
        matrix: [[1,2,3],[4,5,6],[7,8,9]],
        expected: [[1,4,7],[2,5,8],[3,6,9]],
        label: "3x3 square",
    },
    {
        matrix: [[42]],
        expected: [[42]],
        label: "1x1",
    },
    {
        matrix: [[1,2,3]],
        expected: [[1],[2],[3]],
        label: "1x3 row vector",
    },
];

testCases.forEach(({ matrix, expected, label }) => {
    const result = transpose(matrix);
    const status = JSON.stringify(result) === JSON.stringify(expected) ? "PASS" : "FAIL";
    console.log(`  [${status}] ${label}: ${JSON.stringify(matrix)} → ${JSON.stringify(result)} (expected ${JSON.stringify(expected)})`);
});
