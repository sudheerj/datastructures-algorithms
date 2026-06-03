/**
 * Count the number of possible text messages from pressed keys.
 * TC: O(n) SC: O(n)
 */
function countTexts(pressedKeys) {
    const MOD = 1000000007;
    const n = pressedKeys.length;
    const dp = new Array(n + 1).fill(0);
    dp[0] = 1;
    
    for (let i = 1; i <= n; i++) {
        const c = pressedKeys[i - 1];
        const maxPress = (c === '7' || c === '9') ? 4 : 3;
        
        dp[i] = dp[i - 1];
        
        for (let j = 2; j <= maxPress; j++) {
            if (i - j >= 0) {
                let allSame = true;
                for (let k = i - j; k < i - 1; k++) {
                    if (pressedKeys[k] !== c) {
                        allSame = false;
                        break;
                    }
                }
                if (allSame) {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                } else {
                    break;
                }
            }
        }
    }
    
    return dp[n];
}

// Test harness
const tests = [
    ["22233", 8],
    ["222222222222222222222222222222222222", 82876089],
    ["2", 1],
    ["23", 2],
    ["77799", 12],
    ["777", 4],
    ["9999999999", 40],
    ["234", 4],
    ["33", 2],
    ["7777777777", 196],
];

console.log("Count Number of Texts - Test Results:");
console.log("=".repeat(70));

let passed = 0;
tests.forEach(([input, expected], index) => {
    const result = countTexts(input);
    const pass = result === expected;
    
    if (pass) passed++;
    
    const displayInput = input.length > 15 ? input.substring(0, 12) + "..." : input;
    console.log(`Test ${String(index + 1).padStart(2)} | Input: ${displayInput.padEnd(15)} | Output: ${String(result).padEnd(10)} | Expected: ${String(expected).padEnd(10)} | ${pass ? "PASS" : "FAIL"}`);
});

console.log("=".repeat(70));
console.log(`Tests Passed: ${passed}/${tests.length}`);
