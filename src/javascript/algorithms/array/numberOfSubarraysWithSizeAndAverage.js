function numberOfSubarrays(nums, k, threshold) {
    let count = 0;
    let windowSum = 0;
    for (let i = 0; i < k; i++) windowSum += nums[i];
    if (windowSum >= k * threshold) count++;
    for (let i = k; i < nums.length; i++) {
        windowSum += nums[i] - nums[i - k];
        if (windowSum >= k * threshold) count++;
    }
    return count;
}

function runTests() {
    const testNums = [
        [2,2,2,2,5,5,5,8],
        [1,1,1,1,1,1,1,1],
        [11,13,17,23,29,31,7,5,2,3],
        [7,7,7,7,7,7,7],
        [1,2,3,4,5,6,7,8,9],
        [5,5,5,5,5],
        [1,2,3,1,2,3,1,2,3],
        [10,9,8,7,6,5,4,3,2,1]
    ];
    const ks = [3, 4, 3, 3, 2, 1, 3, 5];
    const thresholds = [4, 2, 20, 7, 8, 5, 4, 7];
    const expected = [3, 0, 6, 5, 4, 5, 0, 2];
    for (let i = 0; i < testNums.length; i++) {
        const result = numberOfSubarrays(testNums[i], ks[i], thresholds[i]);
        const status = result === expected[i] ? "PASS" : "FAIL";
        console.log(`Test ${i+1} | Output: ${result} | Expected: ${expected[i]} | ${status}`);
    }
}

runTests();
