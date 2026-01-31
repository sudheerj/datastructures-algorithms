/**
 * Number of Islands
 *
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands. An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically.
 *
 * Time Complexity: O(m * n) where m is rows and n is columns
 * Space Complexity: O(m * n) for recursion stack in worst case
 */

/**
 * DFS approach to count islands
 * @param {character[][]} grid
 * @return {number}
 */
function numIslands(grid) {
    if (!grid || grid.length === 0) {
        return 0;
    }

    const rows = grid.length;
    const cols = grid[0].length;
    let count = 0;

    function dfs(r, c) {
        // Base case: out of bounds or water
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] === '0') {
            return;
        }

        // Mark as visited
        grid[r][c] = '0';

        // Explore all 4 directions
        dfs(r + 1, c); // down
        dfs(r - 1, c); // up
        dfs(r, c + 1); // right
        dfs(r, c - 1); // left
    }

    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (grid[r][c] === '1') {
                count++;
                dfs(r, c);
            }
        }
    }

    return count;
}

/**
 * BFS approach to count islands
 * @param {character[][]} grid
 * @return {number}
 */
function numIslandsBFS(grid) {
    if (!grid || grid.length === 0) {
        return 0;
    }

    const rows = grid.length;
    const cols = grid[0].length;
    let count = 0;

    function bfs(r, c) {
        const queue = [[r, c]];
        grid[r][c] = '0';

        while (queue.length > 0) {
            const [row, col] = queue.shift();
            const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];

            for (const [dr, dc] of directions) {
                const nr = row + dr;
                const nc = col + dc;
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] === '1') {
                    grid[nr][nc] = '0';
                    queue.push([nr, nc]);
                }
            }
        }
    }

    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (grid[r][c] === '1') {
                count++;
                bfs(r, c);
            }
        }
    }

    return count;
}

// Test cases
const grid1 = [
    ['1', '1', '1', '1', '0'],
    ['1', '1', '0', '1', '0'],
    ['1', '1', '0', '0', '0'],
    ['0', '0', '0', '0', '0']
];
console.log("Number of islands:", numIslands(grid1.map(row => [...row]))); // 1

const grid2 = [
    ['1', '1', '0', '0', '0'],
    ['1', '1', '0', '0', '0'],
    ['0', '0', '1', '0', '0'],
    ['0', '0', '0', '1', '1']
];
console.log("Number of islands:", numIslands(grid2.map(row => [...row]))); // 3
