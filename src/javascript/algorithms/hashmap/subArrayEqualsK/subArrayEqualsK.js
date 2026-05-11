/**
 * Subarray Sum Equals K
 *
 * Given an array of integers nums and an integer k, return the total number
 * of subarrays whose sum equals k.
 *
 * Approach: Prefix Sum + HashMap
 * TC: O(n)  SC: O(n)
 */

function subarraySumEqualsK(nums, k) {
    const prefixSumMap = new Map();
    prefixSumMap.set(0, 1); // seed for subarrays starting at index 0

    let total = 0;
    let currentSum = 0;

    for (const num of nums) {
        currentSum += num;
        total += prefixSumMap.get(currentSum - k) || 0;
        prefixSumMap.set(currentSum, (prefixSumMap.get(currentSum) || 0) + 1);
    }

    return total;
}

const testCases = [
    { nums: [1, 1, 1],   k: 2, expected: 2, label: "[1,1],[1,1]" },
    { nums: [1, 2, 3],   k: 3, expected: 2, label: "[1,2],[3]" },
    { nums: [3],         k: 3, expected: 1, label: "[3]" },
    { nums: [1, 2, 3],   k: 6, expected: 1, label: "[1,2,3]" },
    { nums: [1, 1, 1],   k: 1, expected: 3, label: "[1],[1],[1]" },
    { nums: [-1, -1, 1], k: 0, expected: 1, label: "[-1,1] indices 1-2" },
];

testCases.forEach(({ nums, k, expected, label }) => {
    const result = subarraySumEqualsK(nums, k);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] ${label}: [${nums}], k=${k} → ${result} (expected ${expected})`);
});
