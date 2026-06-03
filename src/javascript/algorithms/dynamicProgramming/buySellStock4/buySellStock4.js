/**
 * Recursive approach TC: O(2^n) SC: O(n)
 */
function maxProfitRecursive(prices, k) {
    function dfs(idx, buy, cap) {
        if (idx === prices.length || cap === 0) {
            return 0;
        }
        
        if (buy === 1) {  // buy or skip
            return Math.max(-prices[idx] + dfs(idx + 1, 0, cap), dfs(idx + 1, 1, cap));
        } else {  // sell or hold
            return Math.max(prices[idx] + dfs(idx + 1, 1, cap - 1), dfs(idx + 1, 0, cap));
        }
    }
    
    return dfs(0, 1, k);
}

/**
 * Top-down memoization DP TC: O(n * 2 * k) SC: O(n * 2 * k)
 */
function maxProfitMemoization(prices, k) {
    const n = prices.length;
    const dp = Array(n).fill(null).map(() => 
        Array(2).fill(null).map(() => Array(k + 1).fill(-1))
    );
    
    function dfs(idx, buy, cap) {
        if (idx === prices.length || cap === 0) {
            return 0;
        }
        
        if (dp[idx][buy][cap] !== -1) {
            return dp[idx][buy][cap];
        }
        
        let maxProfit;
        if (buy === 1) {  // buy or skip
            maxProfit = Math.max(-prices[idx] + dfs(idx + 1, 0, cap), dfs(idx + 1, 1, cap));
        } else {  // sell or hold
            maxProfit = Math.max(prices[idx] + dfs(idx + 1, 1, cap - 1), dfs(idx + 1, 0, cap));
        }
        
        dp[idx][buy][cap] = maxProfit;
        return maxProfit;
    }
    
    return dfs(0, 1, k);
}

/**
 * Bottom-up tabulation DP TC: O(n * 2 * k) SC: O(n * 2 * k)
 */
function maxProfitTabulation(prices, k) {
    const n = prices.length;
    const dp = Array(n + 1).fill(null).map(() => 
        Array(2).fill(null).map(() => Array(k + 1).fill(0))
    );
    
    for (let i = n - 1; i >= 0; i--) {
        for (let buy = 0; buy < 2; buy++) {
            for (let cap = 1; cap <= k; cap++) {
                if (buy === 1) {
                    dp[i][buy][cap] = Math.max(-prices[i] + dp[i + 1][0][cap], dp[i + 1][1][cap]);
                } else {
                    dp[i][buy][cap] = Math.max(prices[i] + dp[i + 1][1][cap - 1], dp[i + 1][0][cap]);
                }
            }
        }
    }
    
    return dp[0][1][k];
}

/**
 * Space optimized DP TC: O(n * 2 * k) SC: O(2 * k)
 */
function maxProfitSpaceOptimized(prices, k) {
    let next = Array(2).fill(null).map(() => Array(k + 1).fill(0));
    
    for (let i = prices.length - 1; i >= 0; i--) {
        const curr = Array(2).fill(null).map(() => Array(k + 1).fill(0));
        for (let buy = 0; buy < 2; buy++) {
            for (let cap = 1; cap <= k; cap++) {
                if (buy === 1) {
                    curr[buy][cap] = Math.max(-prices[i] + next[0][cap], next[1][cap]);
                } else {
                    curr[buy][cap] = Math.max(prices[i] + next[1][cap - 1], next[0][cap]);
                }
            }
        }
        next = curr;
    }
    
    return next[1][k];
}

/**
 * Greedy + DP Space optimized for large k TC: O(n * 2 * k) or O(n) SC: O(k) or O(1)
 */
function maxProfitGreedyDP(prices, k) {
    const n = prices.length;
    // If k >= n/2, we can do unlimited transactions (greedy approach)
    if (k >= Math.floor(n / 2)) {
        let maxProfit = 0;
        for (let i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
    // Otherwise, use space-optimized DP
    return maxProfitSpaceOptimized(prices, k);
}

// Test harness
const tests = [
    [[2, 4, 1], 2, 2],
    [[3, 2, 6, 5, 0, 3], 2, 7],
    [[3, 3, 5, 0, 0, 3, 1, 4], 2, 6],
    [[1, 2, 3, 4, 5], 2, 4],
    [[7, 6, 4, 3, 1], 2, 0],
    [[1, 2, 4, 2, 5, 7, 2, 4, 9, 0], 3, 15],
    [[1, 2, 3, 4, 5], 1, 4],
    [[1, 2, 4, 2, 5, 7, 2, 4, 9, 0], 4, 15],
    [[6, 1, 3, 2, 4, 7], 2, 7],
    [[5, 4, 3, 2, 1, 6, 7], 3, 6],
];

console.log("Buy and Sell Stock IV - Test Results:");
console.log("=".repeat(90));

let passed = 0;
tests.forEach(([prices, k, expected], index) => {
    // Test all approaches
    const result2 = maxProfitMemoization(prices, k);
    const result3 = maxProfitTabulation(prices, k);
    const result4 = maxProfitSpaceOptimized(prices, k);
    const result5 = maxProfitGreedyDP(prices, k);
    
    const pass = (result2 === expected && result3 === expected && 
                 result4 === expected && result5 === expected);
    
    if (pass) passed++;
    
    let pricesStr = JSON.stringify(prices);
    if (pricesStr.length > 25) {
        pricesStr = pricesStr.substring(0, 22) + "...]";
    }
    
    // Debug: print all results if test fails
    if (!pass) {
        console.log(`Test ${String(index + 1).padStart(2)} FAIL | k=${k}, Prices: ${JSON.stringify(prices)}`);
        console.log(`  Memo: ${result2}, Tabulation: ${result3}, Space-opt: ${result4}, Greedy+DP: ${result5} | Expected: ${expected}`);
    } else {
        console.log(`Test ${String(index + 1).padStart(2)} | k=${k} | Prices: ${pricesStr.padEnd(25)} | Output: ${String(result4).padStart(2)} | Expected: ${String(expected).padStart(2)} | ${pass ? "PASS" : "FAIL"}`);
    }
});

console.log("=".repeat(90));
console.log(`Tests Passed: ${passed}/${tests.length}`);
