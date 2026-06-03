/**
 * Recursive approach TC: O(2^n + n^3) SC: O(n^2 + n)
 */
function minDistanceRecursive(houses, k) {
    houses.sort((a, b) => a - b);
    const n = houses.length;
    const INF = Infinity;
    
    // Compute cost matrix
    const cost = Array.from({ length: n }, () => Array(n).fill(0));
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            const median = houses[Math.floor((i + j) / 2)];
            for (let p = i; p <= j; p++) {
                cost[i][j] += Math.abs(houses[p] - median);
            }
        }
    }
    
    function dfs(start, kLeft) {
        if (start === n) return 0;
        if (kLeft === 0) return INF;
        
        let minDist = INF;
        for (let end = start; end < n; end++) {
            minDist = Math.min(minDist, cost[start][end] + dfs(end + 1, kLeft - 1));
        }
        
        return minDist;
    }
    
    return dfs(0, k);
}

/**
 * Top-down memoization TC: O(n^2 * k + n^3) SC: O(n^2 + n * k)
 */
function minDistanceMemoization(houses, k) {
    houses.sort((a, b) => a - b);
    const n = houses.length;
    const INF = Infinity;
    
    // Compute cost matrix
    const cost = Array.from({ length: n }, () => Array(n).fill(0));
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            const median = houses[Math.floor((i + j) / 2)];
            for (let p = i; p <= j; p++) {
                cost[i][j] += Math.abs(houses[p] - median);
            }
        }
    }
    
    // Memoization table
    const memo = new Map();
    
    function dfs(start, kLeft) {
        if (start === n) return 0;
        if (kLeft === 0) return INF;
        
        const key = `${start},${kLeft}`;
        if (memo.has(key)) {
            return memo.get(key);
        }
        
        let minDist = INF;
        for (let end = start; end < n; end++) {
            minDist = Math.min(minDist, cost[start][end] + dfs(end + 1, kLeft - 1));
        }
        
        memo.set(key, minDist);
        return minDist;
    }
    
    return dfs(0, k);
}

/**
 * Bottom-up DP TC: O(n^2 * k + n^3) SC: O(n^2 + n * k)
 */
function minDistanceDP(houses, k) {
    houses.sort((a, b) => a - b);
    const n = houses.length;
    const INF = Infinity;
    
    // Compute cost matrix
    const cost = Array.from({ length: n }, () => Array(n).fill(0));
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            const median = houses[Math.floor((i + j) / 2)];
            for (let p = i; p <= j; p++) {
                cost[i][j] += Math.abs(houses[p] - median);
            }
        }
    }
    
    // DP table: dp[i][m] = min distance for first i houses using m mailboxes
    const dp = Array.from({ length: n + 1 }, () => Array(k + 1).fill(INF));
    dp[0][0] = 0;
    
    for (let i = 1; i <= n; i++) {
        for (let m = 1; m <= k; m++) {
            for (let p = 0; p < i; p++) {
                dp[i][m] = Math.min(dp[i][m], dp[p][m - 1] + cost[p][i - 1]);
            }
        }
    }
    
    return dp[n][k];
}

// Test harness
const tests = [
    [[1,4,8,10,20], 3, 5],
    [[2,3,5,12,18], 2, 9],
    [[7,4,6,1], 1, 8],
    [[3,6,14,10], 4, 0],
    [[1,2,3,4,5], 2, 3],
    [[1,10,20,30,40], 2, 29],
    [[5,10,15,20,25], 3, 10],
    [[1,2], 1, 1],
    [[1,5,10], 2, 4],
    [[1,100,200,300], 2, 199]
];

console.log("Allocate Mailboxes - Test Results:");
console.log("=".repeat(100));

let passed = 0;
tests.forEach(([houses, k, expected], index) => {
    // Test all approaches (skip recursive for large inputs)
    const result2 = minDistanceMemoization([...houses], k);
    const result3 = minDistanceDP([...houses], k);
    
    const pass = (result2 === expected && result3 === expected);
    
    // Debug: print all results if test fails
    if (!pass) {
        console.log(`Test ${String(index + 1).padStart(2)} FAIL | Houses: ${JSON.stringify(houses)}, k=${k}`);
        console.log(`  Memo: ${result2}, DP: ${result3} | Expected: ${expected}`);
    } else {
        console.log(`Test ${String(index + 1).padStart(2)} | Houses: ${JSON.stringify(houses).padEnd(25)} | k: ${k} | Output: ${String(result2).padStart(3)} | Expected: ${String(expected).padStart(3)} | PASS`);
        passed++;
    }
});

console.log("=".repeat(100));
console.log(`Tests Passed: ${passed}/${tests.length}`);
