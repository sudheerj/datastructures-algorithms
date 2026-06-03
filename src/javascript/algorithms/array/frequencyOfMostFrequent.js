function maxFrequency(nums, k) {
    nums.sort((a, b) => a - b);
    let left = 0, sum = 0, maxFreq = 1;
    for (let right = 0; right < nums.length; right++) {
        sum += nums[right];
        while (nums[right] * (right - left + 1) > sum + k) {
            sum -= nums[left];
            left++;
        }
        maxFreq = Math.max(maxFreq, right - left + 1);
    }
    return maxFreq;
}

function runTests() {
    const tests = [
        [[1,2,4], 5],
        [[1,4,8,13], 5],
        [[3,9,6], 2],
        [[1,1,1,2,2,4], 0],
        [[1,2,2,2,2,2], 3],
        [[1], 0],
        [[1,2,3,4,5], 10],
    ];
    const expected = [3,2,1,3,6,1,5];
    console.log("Testing maxFrequency (sliding window):");
    for (let i = 0; i < tests.length; i++) {
        const [arr, k] = tests[i];
        const result = maxFrequency([...arr], k);
        console.log(`Test ${i+1}: Output=${result}, Expected=${expected[i]} [${result === expected[i] ? 'PASS' : 'FAIL'}]`);
    }
}

runTests();
