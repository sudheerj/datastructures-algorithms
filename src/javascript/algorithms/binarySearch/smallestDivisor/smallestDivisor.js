/**
 * Find the Smallest Divisor Given a Threshold
 *
 * Given an array of integers nums and an integer threshold, choose a positive
 * integer divisor, divide all the array by it, and sum the ceiling values.
 * Find the smallest divisor such that the result is <= threshold.
 *
 * TC: O(n log m)  — n = nums.length, m = max(nums)
 * SC: O(1)
 */

function smallestDivisor(nums, threshold) {
    let left = 1;
    let right = Math.max(...nums);

    while (left <= right) {
        const divisor = left + Math.floor((right - left) / 2);
        const total = nums.reduce((sum, num) => sum + Math.ceil(num / divisor), 0);

        if (total <= threshold) {
            right = divisor - 1;
        } else {
            left = divisor + 1;
        }
    }

    return left;
}

function smallestDivisorBrute(nums, threshold) {
    const max = Math.max(...nums);

    for (let divisor = 1; divisor <= max; divisor++) {
        const total = nums.reduce((sum, num) => sum + Math.ceil(num / divisor), 0);
        if (total <= threshold) return divisor;
    }

    return -1;
}

const testCases = [
    { nums: [1, 2, 5, 9],        threshold: 6,  expected: 5 },
    { nums: [2, 3, 5, 7, 11],   threshold: 11, expected: 3 },
    { nums: [19],                threshold: 5,  expected: 4 },
    { nums: [1, 2, 3],           threshold: 6,  expected: 1 },
    { nums: [44, 22, 33, 11, 1], threshold: 5,  expected: 44 },
    { nums: [1],                 threshold: 1,  expected: 1 },
    { nums: [1000000],           threshold: 1,  expected: 1000000 },
];

console.log("Binary Search:");
testCases.forEach(({ nums, threshold, expected }) => {
    const result = smallestDivisor(nums, threshold);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] nums=[${nums}], threshold=${threshold} → ${result} (expected ${expected})`);
});

console.log("\nBrute Force:");
testCases.forEach(({ nums, threshold, expected }) => {
    const result = smallestDivisorBrute(nums, threshold);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] nums=[${nums}], threshold=${threshold} → ${result} (expected ${expected})`);
});
