/**
 * Triangle (LeetCode 120)
 *
 * Given a triangle array, find the minimum path sum from top to bottom.
 * From index i, you can move to i or i+1 in the next row.
 *
 * Approach 1: Top-down Memoization  TC: O(n^2)  SC: O(n^2)
 * Approach 2: Bottom-up DP          TC: O(n^2)  SC: O(n^2)
 * Approach 3: In-place              TC: O(n^2)  SC: O(1)
 */

// Approach 1: Top-down Memoization
function triangle1(t) {
    const n = t.length;
    const memo = new Map();

    function dfs(r, c) {
        if (r >= n) return 0;
        const key = `${r},${c}`;
        if (memo.has(key)) return memo.get(key);
        const val = t[r][c] + Math.min(dfs(r + 1, c), dfs(r + 1, c + 1));
        memo.set(key, val);
        return val;
    }

    return dfs(0, 0);
}

// Approach 2: Bottom-up DP
function triangle2(t) {
    const n = t.length;
    const dp = Array.from({ length: n }, () => new Array(n).fill(0));
    for (let c = 0; c < t[n - 1].length; c++) {
        dp[n - 1][c] = t[n - 1][c];
    }

    for (let r = n - 2; r >= 0; r--) {
        for (let c = 0; c < t[r].length; c++) {
            dp[r][c] = t[r][c] + Math.min(dp[r + 1][c], dp[r + 1][c + 1]);
        }
    }

    return dp[0][0];
}

// Approach 3: In-place (copies input to avoid mutation)
function triangle3(t) {
    const tri = t.map(row => [...row]);
    const n = tri.length;

    for (let r = n - 2; r >= 0; r--) {
        for (let c = 0; c < tri[r].length; c++) {
            tri[r][c] = tri[r][c] + Math.min(tri[r + 1][c], tri[r + 1][c + 1]);
        }
    }

    return tri[0][0];
}

const testCases = [
    { tri: [[2],[3,4],[6,5,7],[4,1,8,3]], expected: 11, label: "standard 4-row" },
    { tri: [[-10]],                        expected: -10, label: "single negative" },
    { tri: [[1],[2,3]],                    expected: 3,  label: "2-row" },
    { tri: [[-1],[2,3],[1,-1,-3]],         expected: -1, label: "negative values" },
    { tri: [[1],[2,3],[4,5,6],[7,8,9,10]], expected: 14, label: "4-row ascending" },
];

const methods = [
    ["Top-down Memoization", triangle1],
    ["Bottom-up DP",         triangle2],
    ["In-place",             triangle3],
];

methods.forEach(([name, fn]) => {
    console.log(`=== ${name} ===`);
    testCases.forEach(({ tri, expected, label }) => {
        const result = fn(tri);
        console.log(`  [${result === expected ? "PASS" : "FAIL"}] ${label}: ${result}  (expected ${expected})`);
    });
});
