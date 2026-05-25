// Brute force with HashSet TC: O(n^2) SC: O(n)
function subarrayWithKDiffIntegers1(nums, k) {
    const n = nums.length;
    let count = 0;
    for (let i = 0; i < n; i++) {
        const countSet = new Set();
        for (let j = i; j < n; j++) {
            countSet.add(nums[j]);
            if (countSet.size > k) break;
            if (countSet.size === k) count++;
        }
    }
    return count;
}

// Sliding window: exactlyK = atMostK - atMostK(k-1)  TC: O(n) SC: O(k)
function subarrayWithKDiffIntegers2(nums, k) {
    return atMostK(nums, k) - atMostK(nums, k - 1);
}

function atMostK(nums, k) {
    let left = 0, count = 0;
    const freq = new Map();
    for (let right = 0; right < nums.length; right++) {
        freq.set(nums[right], (freq.get(nums[right]) || 0) + 1);
        while (freq.size > k) {
            freq.set(nums[left], freq.get(nums[left]) - 1);
            if (freq.get(nums[left]) === 0) freq.delete(nums[left]);
            left++;
        }
        count += right - left + 1;
    }
    return count;
}

function runTests() {
    const tests = [
        { nums: [1, 2, 1, 2, 3], k: 2, expected: 7 },
        { nums: [1, 2, 1, 3, 4], k: 3, expected: 3 },
        { nums: [1, 1, 1, 1, 1], k: 1, expected: 15 },
        { nums: [1, 2, 3],       k: 1, expected: 3 },
        { nums: [1, 2, 3, 4, 5], k: 2, expected: 4 },
    ];

    const fns = [subarrayWithKDiffIntegers1, subarrayWithKDiffIntegers2];
    tests.forEach(({ nums, k, expected }) => {
        fns.forEach((fn, idx) => {
            const result = fn(nums, k);
            const status = result === expected ? "PASS" : "FAIL";
            console.log(`[${status}] approach=${idx + 1} nums=[${nums}] k=${k} result=${result} expected=${expected}`);
        });
    });
}

runTests();
