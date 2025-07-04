function minAbsSum(numbers) {
    // Step 1: Work with absolute values
    const absoluteNumbers = numbers.map(Math.abs);
    const totalSum = absoluteNumbers.reduce((sum, num) => sum + num, 0);
    const target = Math.floor(totalSum/2);

    // Step 2: Basic DP to track possible subset sums
    const dp =Array(target +1).fill(false);
    dp[0] = true;

    for(const num of absoluteNumbers) {
        for(let i = target; i >= num; i--) {
            if(dp[i-num]) dp[i] = true;
        }
    }

    // Step 3: Find best sum close to half of total
    for(let i = target; i >=0; i--) {
        if(dp[i]){
            return totalSum - 2 * i;
        }
    }

    return totalSum;
}

// Test Examples
const examples = [
    { input: [1, 2, 3], expected: 0 },
    { input: [1, 5, 2], expected: 2 },
    { input: [3, 3, 3, 4, 5], expected: 0 },
    { input: [7], expected: 7 },
];

// Run all test cases
examples.forEach(({ input, expected }, idx) => {
    const result = minAbsSum(input);
    console.log(`Example ${idx + 1}: A = [${input}]`);
    console.log(`→ Output: ${result}, Expected: ${expected}`);
    console.log(result === expected ? "✅ Passed\n" : "❌ Failed\n");
});