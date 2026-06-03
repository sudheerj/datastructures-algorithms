/**
 * Recursive approach TC: O(2^n) SC: O(n)
 */
function maxProfitRecursive(prices) {
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
    
    return dfs(0, 1, 2);
}

/**
 * Top-down memoization DP TC: O(n * 2 * 3) SC: O(n * 2 * 3)
 */
function maxProfitMemoization(prices) {
    const n = prices.length;
    const dp = Array(n).fill(null).map(() => 
        Array(2).fill(null).map(() => Array(3).fill(-1))
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
    
    return dfs(0, 1, 2);
}

/**
 * Bottom-up tabulation DP TC: O(n * 2 * 3) SC: O(n * 2 * 3)
 */
function maxProfitTabulation(prices) {
    const n = prices.length;
    const dp = Array(n + 1).fill(null).map(() => 
        Array(2).fill(null).map(() => Array(3).fill(0))
    );
    
    for (let i = n - 1; i >= 0; i--) {
        for (let buy = 0; buy < 2; buy++) {
            for (let cap = 1; cap <= 2; cap++) {
                if (buy === 1) {
                    dp[i][buy][cap] = Math.max(-prices[i] + dp[i + 1][0][cap], dp[i + 1][1][cap]);
                } else {
                    dp[i][buy][cap] = Math.max(prices[i] + dp[i + 1][1][cap - 1], dp[i + 1][0][cap]);
                }
            }
        }
    }
    
    return dp[0][1][2];
}

/**
 * Space optimized DP TC: O(n * 2 * 3) SC: O(2 * 3)
 */
function maxProfitSpaceOptimized(prices) {
    let next = Array(2).fill(null).map(() => Array(3).fill(0));
    
    for (let i = prices.length - 1; i >= 0; i--) {
        const curr = Array(2).fill(null).map(() => Array(3).fill(0));
        for (let buy = 0; buy < 2; buy++) {
            for (let cap = 1; cap <= 2; cap++) {
                if (buy === 1) {
                    curr[buy][cap] = Math.max(-prices[i] + next[0][cap], next[1][cap]);
                } else {
                    curr[buy][cap] = Math.max(prices[i] + next[1][cap - 1], next[0][cap]);
                }
            }
        }
        next = curr;
    }
    
    return next[1][2];
}

/**
 * 4-state machine variables TC: O(n) SC: O(1)
 */
function maxProfitStateMachine(prices) {
    let buy1 = -Infinity;
    let sell1 = 0;
    let buy2 = -Infinity;
    let sell2 = 0;
    
    for (const price of prices) {
        buy1 = Math.max(buy1, -price);
        sell1 = Math.max(sell1, buy1 + price);
        buy2 = Math.max(buy2, sell1 - price);
        sell2 = Math.max(sell2, buy2 + price);
    }
    
    return sell2;
}

// Test harness
const tests = [
    [[3, 3, 5, 0, 0, 3, 1, 4], 6],
    [[1, 2, 3, 4, 5], 4],
    [[7, 6, 4, 3, 1], 0],
    [[1], 0],
    [[1, 2], 1],
    [[2, 1, 2, 0, 1], 2],
    [[3, 2, 6, 5, 0, 3], 7],
    [[1, 2, 4, 2, 5, 7, 2, 4, 9, 0], 13],
    [[6, 1, 3, 2, 4, 7], 7],
    [[5, 4, 3, 2, 1, 6], 5],
];

console.log("Buy and Sell Stock III - Test Results:");
console.log("=".repeat(90));

let passed = 0;
tests.forEach(([prices, expected], index) => {
    // Test all approaches
    const result2 = maxProfitMemoization(prices);
    const result3 = maxProfitTabulation(prices);
    const result4 = maxProfitSpaceOptimized(prices);
    const result5 = maxProfitStateMachine(prices);
    
    const pass = (result2 === expected && result3 === expected && 
                 result4 === expected && result5 === expected);
    
    if (pass) passed++;
    
    let pricesStr = JSON.stringify(prices);
    if (pricesStr.length > 30) {
        pricesStr = pricesStr.substring(0, 27) + "...]";
    }
    
    console.log(`Test ${String(index + 1).padStart(2)} | Prices: ${pricesStr.padEnd(30)} | Output: ${String(result5).padStart(2)} | Expected: ${String(expected).padStart(2)} | ${pass ? "PASS" : "FAIL"}`);
});

console.log("=".repeat(90));
console.log(`Tests Passed: ${passed}/${tests.length}`);
