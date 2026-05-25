/**
 * Brute force TC: O(n²) SC: O(1)
 */
function checkSubarraySum1(nums, k) {
    for (let i = 0; i < nums.length - 1; i++) {
        let sum = nums[i];
        for (let j = i + 1; j < nums.length; j++) {
            sum += nums[j];
            if (sum % k === 0) return true;
        }
    }
    return false;
}

/**
 * Prefix sum + HashMap TC: O(n) SC: O(min(n, k))
 */
function checkSubarraySum2(nums, k) {
    const remainderMap = new Map([[0, -1]]);
    let total = 0;
    for (let i = 0; i < nums.length; i++) {
        total += nums[i];
        const remainder = total % k;
        if (!remainderMap.has(remainder)) {
            remainderMap.set(remainder, i);
        } else if (i - remainderMap.get(remainder) > 1) {
            return true;
        }
    }
    return false;
}

const testCases = [
    { nums: [23, 2, 4, 6, 7], k: 6,  expected: true },
    { nums: [23, 2, 6, 4, 7], k: 6,  expected: true },
    { nums: [23, 2, 6, 4, 7], k: 13, expected: false },
    { nums: [5, 0, 0, 0],     k: 3,  expected: true },
    { nums: [1, 0],           k: 2,  expected: false },
    { nums: [0, 0],           k: 1,  expected: true },
];

function runTests(fn, label) {
    console.log(`--- ${label} ---`);
    for (const { nums, k, expected } of testCases) {
        const result = fn([...nums], k);
        console.log(`[${result === expected ? "PASS" : "FAIL"}] result=${result} expected=${expected}`);
    }
}

runTests(checkSubarraySum1, "checkSubarraySum1 (brute force)");
runTests(checkSubarraySum2, "checkSubarraySum2 (prefix sum + hashmap)");
