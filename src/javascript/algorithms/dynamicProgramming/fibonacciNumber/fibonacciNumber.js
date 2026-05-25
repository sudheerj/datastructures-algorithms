/**
 * Fibonacci Number (LeetCode 509)
 *
 * Return the n-th Fibonacci number: F(0)=0, F(1)=1, F(n)=F(n-1)+F(n-2).
 *
 * Approach 1: Recursion           TC: O(2^n)  SC: O(n)
 * Approach 2: Memoization         TC: O(n)    SC: O(n)
 * Approach 3: Tabulation          TC: O(n)    SC: O(n)
 * Approach 4: Space-Optimized     TC: O(n)    SC: O(1)
 */

// Approach 1: Recursion (Brute Force)
function fibonacci1(n) {
    if (n <= 1) return n;
    return fibonacci1(n - 1) + fibonacci1(n - 2);
}

// Approach 2: Memoization (Top-down DP)
function fibonacci2(n, memo = {}) {
    if (n <= 1) return n;
    if (n in memo) return memo[n];
    memo[n] = fibonacci2(n - 1, memo) + fibonacci2(n - 2, memo);
    return memo[n];
}

// Approach 3: Tabulation (Bottom-up DP)
function fibonacci3(n) {
    if (n <= 1) return n;
    const dp = new Array(n + 1).fill(0);
    dp[1] = 1;
    for (let i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}

// Approach 4: Space-Optimized DP
function fibonacci4(n) {
    if (n <= 1) return n;
    let first = 0, second = 1;
    for (let i = 2; i <= n; i++) {
        [first, second] = [second, first + second];
    }
    return second;
}

const testCases = [
    { n: 0,  expected: 0,  label: "n=0"  },
    { n: 1,  expected: 1,  label: "n=1"  },
    { n: 2,  expected: 1,  label: "n=2"  },
    { n: 3,  expected: 2,  label: "n=3"  },
    { n: 5,  expected: 5,  label: "n=5"  },
    { n: 10, expected: 55, label: "n=10" },
];
const methods = [
    ["Recursion",       fibonacci1],
    ["Memoization",     fibonacci2],
    ["Tabulation",      fibonacci3],
    ["Space-Optimized", fibonacci4],
];

methods.forEach(([name, fn]) => {
    console.log(`=== ${name} ===`);
    testCases.forEach(({ n, expected, label }) => {
        const result = fn(n);
        console.log(`  [${result === expected ? "PASS" : "FAIL"}] ${label}: ${result}  (expected ${expected})`);
    });
});
