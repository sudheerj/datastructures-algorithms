/**
 * Edit Distance (LeetCode 72)
 *
 * Given two strings w1 and w2, return the minimum number of operations
 * (insert, delete, replace) to convert w1 into w2.
 *
 * Approach 1: Top-down Memoization  TC: O(m*n)  SC: O(m*n)
 * Approach 2: Bottom-up DP          TC: O(m*n)  SC: O(m*n)
 */

// Approach 1: Top-down Memoization
function editDistance1(w1, w2) {
    const m = w1.length, n = w2.length;
    const memo = new Map();

    function dfs(r, c) {
        if (r === m) return n - c;
        if (c === n) return m - r;
        const key = `${r},${c}`;
        if (memo.has(key)) return memo.get(key);
        let val;
        if (w1[r] === w2[c]) {
            val = dfs(r + 1, c + 1);
        } else {
            val = 1 + Math.min(dfs(r, c + 1), dfs(r + 1, c), dfs(r + 1, c + 1));
        }
        memo.set(key, val);
        return val;
    }

    return dfs(0, 0);
}

// Approach 2: Bottom-up DP
function editDistance2(w1, w2) {
    const m = w1.length, n = w2.length;
    const dp = Array.from({ length: m + 1 }, () => new Array(n + 1).fill(0));

    for (let i = 0; i <= n; i++) dp[m][i] = n - i;
    for (let j = 0; j <= m; j++) dp[j][n] = m - j;

    for (let i = m - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            if (w1[i] === w2[j]) {
                dp[i][j] = dp[i + 1][j + 1];
            } else {
                dp[i][j] = 1 + Math.min(dp[i][j + 1], dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
    }

    return dp[0][0];
}

const testCases = [
    { w1: "horse",     w2: "ros",       expected: 3, label: "horse->ros" },
    { w1: "intention", w2: "execution", expected: 5, label: "intention->execution" },
    { w1: "",          w2: "abc",       expected: 3, label: "empty->abc" },
    { w1: "abc",       w2: "",          expected: 3, label: "abc->empty" },
    { w1: "abc",       w2: "abc",       expected: 0, label: "abc->abc" },
    { w1: "kitten",    w2: "sitting",   expected: 3, label: "kitten->sitting" },
    { w1: "flaw",      w2: "lawn",      expected: 2, label: "flaw->lawn" },
    { w1: "a",         w2: "b",         expected: 1, label: "a->b" },
    { w1: "",          w2: "",          expected: 0, label: "empty->empty" },
];

const methods = [
    ["Top-down Memoization", editDistance1],
    ["Bottom-up DP",         editDistance2],
];

methods.forEach(([name, fn]) => {
    console.log(`=== ${name} ===`);
    testCases.forEach(({ w1, w2, expected, label }) => {
        const result = fn(w1, w2);
        console.log(`  [${result === expected ? "PASS" : "FAIL"}] ${label}: ${result}  (expected ${expected})`);
    });
});
