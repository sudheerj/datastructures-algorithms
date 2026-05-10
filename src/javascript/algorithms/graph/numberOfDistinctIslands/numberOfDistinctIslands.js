/**
 * Number of Distinct Islands
 *
 * Given an m x n binary grid, return the number of distinct islands.
 * Two islands are the same if one can be translated (not rotated/reflected) to match the other.
 *
 * Approach: DFS with relative-position path encoding stored in a Set.
 * TC: O(m * n)  SC: O(m * n)
 */

function numDistinctIslands(grid) {
    const distinct = new Set();

    function dfs(row, col, baseRow, baseCol, path) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] === '0') return;
        grid[row][col] = '0';
        path.push(`${row - baseRow}:${col - baseCol}`);
        dfs(row + 1, col, baseRow, baseCol, path); // down
        dfs(row - 1, col, baseRow, baseCol, path); // up
        dfs(row, col + 1, baseRow, baseCol, path); // right
        dfs(row, col - 1, baseRow, baseCol, path); // left
    }

    for (let r = 0; r < grid.length; r++) {
        for (let c = 0; c < grid[0].length; c++) {
            if (grid[r][c] === '1') {
                const path = [];
                dfs(r, c, r, c, path);
                distinct.add(path.join('|'));
            }
        }
    }

    return distinct.size;
}

const testCases = [
    {
        grid: [['1','1','0','0'],['1','1','0','0'],['0','0','1','1'],['0','0','1','1']],
        expected: 1, label: "two identical 2x2 blocks"
    },
    {
        grid: [['1','1','0','1','1'],['1','0','0','0','0'],['0','0','0','1','1'],['0','0','0','1','1']],
        expected: 3, label: "L-shape + pair + 2x2 → 3 distinct"
    },
    {
        grid: [['1','1','0','0','0'],['1','0','0','1','1'],['0','0','0','1','0']],
        expected: 1, label: "two identical L-shapes (translation)"
    },
    {
        grid: [['0','0','0'],['0','0','0']],
        expected: 0, label: "no islands"
    },
    {
        grid: [['1','0','1'],['0','0','0'],['1','0','0']],
        expected: 1, label: "three single-cell islands"
    },
];

testCases.forEach(({ grid, expected, label }) => {
    // Deep copy to avoid mutation across tests
    const g = grid.map(row => [...row]);
    const result = numDistinctIslands(g);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] ${label}: → ${result} (expected ${expected})`);
});
