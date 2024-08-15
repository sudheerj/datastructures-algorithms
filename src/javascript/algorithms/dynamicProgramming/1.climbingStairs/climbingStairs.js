// Optimized fibonacci series- TC: O(n) SC: O(1)
function climbStairs1(n) {
    if(n <= 2) return n;

    let first = 1, second = 2;
    let temp = 0;
    for(let i=2; i<n; i++) {
        temp = first + second;
        first = second;
        second = temp;
    }
    return second;
}

// Bottomup DP -TC: O(n) SC: O(n)
function climbStairs2(n) {
    if(n <= 2) return n;

    let dp = new Array(n+1);
    dp[0] = 1, dp[1] = 1;
    for(let i=2; i<n+1; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
}

console.log(climbStairs1(6));
console.log(climbStairs2(6));