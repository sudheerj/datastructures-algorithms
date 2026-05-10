/**
 * K-diff Pairs in an Array
 *
 * Given an integer array nums and integer k, return the number of unique
 * k-diff pairs where |nums[i] - nums[j]| == k.
 *
 * Approach 1 - HashSet:   TC O(n),       SC O(n)
 * Approach 2 - Sorting:   TC O(n log n), SC O(1)
 */

function kDiffPairs(nums, k) {
    if (k < 0) return 0;

    const seen = new Set();
    const pairs = new Set();

    for (const num of nums) {
        if (seen.has(num - k)) pairs.add(num - k);
        if (seen.has(num + k)) pairs.add(num);
        seen.add(num);
    }

    return pairs.size;
}

function kDiffPairsSorting(nums, k) {
    nums = [...nums].sort((a, b) => a - b);
    let left = 0, right = 1, count = 0;

    while (right < nums.length) {
        const diff = nums[right] - nums[left];

        if (diff > k) {
            right++;
        } else if (diff < k) {
            left++;
        } else {
            count++;
            left++;
            right++;
        }

        if (left === right) right++;
    }

    return count;
}

function kDifferencePairs(nums, k) {
    const seen = new Set();
    const result = [];

    for (const num of nums) {
        if (seen.has(num - k)) result.push([num - k, num]);
        seen.add(num);
    }

    return result;
}

const testCases = [
    { nums: [3,1,4,1,5],              k: 2, expected: 2, label: "(1,3),(3,5)" },
    { nums: [1,2,3,4,5],              k: 1, expected: 4, label: "(1,2),(2,3),(3,4),(4,5)" },
    { nums: [1,3,1,5,4],              k: 0, expected: 1, label: "k=0 duplicate" },
    { nums: [1,1,1,1,1],              k: 0, expected: 1, label: "all duplicates" },
    { nums: [1,2,4,4,3,3,0,9,2,3],   k: 3, expected: 2, label: "(0,3),(1,4)" },
];

console.log("-- kDiffPairs (HashSet) --");
testCases.forEach(({ nums, k, expected, label }) => {
    const result = kDiffPairs(nums, k);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] ${label}: k=${k} → ${result} (expected ${expected})`);
});

console.log("\n-- kDiffPairsSorting (Two Pointers) --");
testCases.forEach(({ nums, k, expected, label }) => {
    const result = kDiffPairsSorting(nums, k);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] ${label}: k=${k} → ${result} (expected ${expected})`);
});

console.log("\n-- kDifferencePairs (actual pairs) --");
console.log(kDifferencePairs([3,1,4,1,5], 2));  // [[1,3],[3,5]]
