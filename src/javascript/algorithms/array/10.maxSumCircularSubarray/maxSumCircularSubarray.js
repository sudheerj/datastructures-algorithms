function maxSumCircularSubarray(nums) {
    if(nums.length === 0) return 0;

    let globalMaxSum = nums[0], globalMinSum = nums[0];
    let currentMaxSum = 0, currentMinSum = 0;
    let totalSum = 0;

    for (const num of nums) {
        currentMaxSum = Math.max(currentMaxSum + num, num);
        globalMaxSum = Math.max(currentMaxSum, globalMaxSum);

        currentMinSum = Math.min(currentMinSum + num, num);
        globalMinSum = Math.min(currentMinSum, globalMinSum);

        totalSum += num;
    }

    // If all numbers are negative, total - globalMinSum would be 0 or less
    return globalMaxSum > 0 ? Math.max(globalMaxSum, (totalSum-globalMinSum)) : globalMaxSum;
}

// Test Cases
// ---------------------------
const testCases = [
    { input: [9, -9, 6, 11, -6, -10, 15, 1], expected: 'Varies' },
    { input: [6, -2, 6], expected: 12 },
    { input: [-6, -2, -6], expected: -2 },
    { input: [], expected: 0 }
];

for (const { input, expected } of testCases) {
    const result = maxSumCircularSubarray(input);
    console.log(`Input: ${JSON.stringify(input)} => Max Circular Subarray Sum: ${result} (Expected: ${expected})`);
}