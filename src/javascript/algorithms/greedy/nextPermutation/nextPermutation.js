function nextPermutation(nums) {
    const n = nums.length;
    let i = n - 2;

    // Step 1: Find pivot (first decreasing element from right)
    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--;
    }

    // Step 2: If pivot exists, find next larger element in suffix and swap
    if (i >= 0) {
        let j = n - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }
        [nums[i], nums[j]] = [nums[j], nums[i]];
    }

    // Step 3: Reverse the suffix
    let left = i + 1, right = n - 1;
    while (left < right) {
        [nums[left], nums[right]] = [nums[right], nums[left]];
        left++;
        right--;
    }

    return nums;
}

function runTests() {
    const tests = [
        { input: [1,2,3], expected: [1,3,2] },
        { input: [3,2,1], expected: [1,2,3] },
        { input: [1,1,5], expected: [1,5,1] },
        { input: [1,3,2], expected: [2,1,3] },
        { input: [2,3,1], expected: [3,1,2] },
    ];

    tests.forEach(({ input, expected }, i) => {
        const result = nextPermutation([...input]);
        const status = JSON.stringify(result) === JSON.stringify(expected) ? 'PASS' : 'FAIL';
        console.log(`${status} test ${i + 1}: result=${JSON.stringify(result)} expected=${JSON.stringify(expected)}`);
    });
}

runTests();
