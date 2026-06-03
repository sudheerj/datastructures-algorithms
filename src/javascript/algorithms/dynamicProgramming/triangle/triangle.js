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

// Approach 3: Space-optimized
function triangle3(t) {
    const n = t.length;
    const dp = [...t[n - 1]];  // copy last row

    for (let r = n - 2; r >= 0; r--) {
        for (let c = 0; c < t[r].length; c++) {
            dp[c] = t[r][c] + Math.min(dp[c], dp[c + 1]);
        }
    }

    return dp[0];
}

// Approach 4: In-place (copies input to avoid mutation)
function triangle4(t) {
    const tri = t.map(row => [...row]);
    const n = tri.length;

    for (let r = n - 2; r >= 0; r--) {
        for (let c = 0; c < tri[r].length; c++) {
            tri[r][c] = tri[r][c] + Math.min(tri[r + 1][c], tri[r + 1][c + 1]);
        }
    }

    return tri[0][0];
}

// Test cases: [triangle, expected]
const tests = [
    [[[2],[3,4],[6,5,7],[4,1,8,3]], 11],
    [[[-10]], -10],
    [[[1],[2,3]], 3],
    [[[-1],[2,3],[1,-1,-3]], -1],
    [[[1],[2,3],[4,5,6],[7,8,9,10]], 14],
    [[[-1],[-2,-3]], -4],
    [[[5],[-3,2],[1,4,-1],[-2,3,1,0]], 1],
    [[[1],[1,1],[1,1,1]], 3],
    [[[10],[9,8],[7,6,5]], 23],
    [[[-5],[-2,-4],[-1,-3,-6],[-8,-9,-10,-11]], -26]
];

console.log("Triangle - Test Results:");
console.log("=".repeat(120));

let passed = 0;
tests.forEach(([triangle, expected], i) => {
    // Test all four approaches
    const result1 = triangle1(triangle);
    const result2 = triangle2(triangle);
    const result3 = triangle3(triangle);
    const result4 = triangle4(triangle);

    const testPass = (result1 === expected && result2 === expected && 
                     result3 === expected && result4 === expected);

    // Debug: print all results if test fails
    if (!testPass) {
        console.log(`Test ${String(i + 1).padStart(2)} FAIL | Input: ${JSON.stringify(triangle)}`);
        console.log(`  Memoization: ${result1}, DP: ${result2}, Space-opt: ${result3}, In-place: ${result4} | Expected: ${expected}`);
    } else {
        const inputStr = JSON.stringify(triangle).padEnd(50);
        console.log(`Test ${String(i + 1).padStart(2)} | Input: ${inputStr} | Output: ${result1} | Expected: ${expected} | PASS`);
        passed++;
    }
});

console.log("=".repeat(120));
console.log(`Tests Passed: ${passed}/${tests.length}`);
