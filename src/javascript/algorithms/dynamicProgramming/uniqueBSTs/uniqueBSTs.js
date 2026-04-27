function numTrees(n) {
    const dp = new Array(n + 1).fill(0);
    dp[0] = dp[1] = 1;
    for (let nodes = 2; nodes <= n; nodes++) {
        for (let root = 1; root <= nodes; root++) {
            const left = root - 1;
            const right = nodes - root;
            dp[nodes] += dp[left] * dp[right];
        }
    }
    return dp[n];
}

// Test cases
const testCases = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
testCases.forEach((n, i) => {
    console.log(`Test case ${i + 1}: n = ${n}`);
    console.log('Output:', numTrees(n));
});
