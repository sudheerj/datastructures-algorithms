/**
 * Path With Maximum Gold
 * DFS + Backtracking  TC: O(m*n * 3^(m*n))  SC: O(m*n) for recursion stack
 * @param {number[][]} grid
 * @return {number}
 */
function pathWithMaxGold(grid) {
    const rows = grid.length, cols = grid[0].length;
    let maxGold = 0;

    function dfs(r, c, currentGold) {
        // boundary or zero cell
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] === 0) return;

        const gold = grid[r][c];
        currentGold += gold;
        maxGold = Math.max(maxGold, currentGold);

        // mark as visited
        grid[r][c] = 0;

        // explore all 4 directions
        dfs(r - 1, c, currentGold);
        dfs(r, c + 1, currentGold);
        dfs(r + 1, c, currentGold);
        dfs(r, c - 1, currentGold);

        // backtrack
        grid[r][c] = gold;
    }

    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (grid[r][c] !== 0) {
                dfs(r, c, 0);
            }
        }
    }

    return maxGold;
}

// Test 1: Classic grid — best path through center (9->8->7)
console.log(pathWithMaxGold([
    [0, 6, 0],
    [5, 8, 7],
    [0, 9, 0]
])); // Expected: 24

// Test 2: Larger grid with isolated regions
console.log(pathWithMaxGold([
    [1, 0, 7],
    [2, 0, 6],
    [3, 4, 5],
    [0, 3, 0],
    [9, 0, 20]
])); // Expected: 28

// Test 3: Single non-zero cell
console.log(pathWithMaxGold([
    [5]
])); // Expected: 5

// Test 4: All zeros — no gold to collect
console.log(pathWithMaxGold([
    [0, 0],
    [0, 0]
])); // Expected: 0

// Test 5: All non-zero — can traverse entire grid
console.log(pathWithMaxGold([
    [1, 2],
    [3, 4]
])); // Expected: 10

// Test 6: Single row — linear path
console.log(pathWithMaxGold([
    [1, 2, 3]
])); // Expected: 6
