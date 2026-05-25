/**
 * Two pointers (swap) TC: O(n) SC: O(1)
 */
function moveZeros1(nums) {
    let left = 0;
    for (let right = 0; right < nums.length; right++) {
        if (nums[right] !== 0) {
            if (left !== right) {
                [nums[left], nums[right]] = [nums[right], nums[left]];
            }
            left++;
        }
    }
    return nums;
}

/**
 * Two passes (overwrite) TC: O(n) SC: O(1)
 */
function moveZeros2(nums) {
    let left = 0;
    for (let right = 0; right < nums.length; right++) {
        if (nums[right] !== 0) {
            nums[left++] = nums[right];
        }
    }
    for (let i = left; i < nums.length; i++) {
        nums[i] = 0;
    }
    return nums;
}

const testCases = [
    { nums: [0, 1, 0, 3, 12], expected: [1, 3, 12, 0, 0] },
    { nums: [0],               expected: [0] },
    { nums: [1, 2, 3],         expected: [1, 2, 3] },
    { nums: [0, 0, 0],         expected: [0, 0, 0] },
    { nums: [1, 2, 0, 0],      expected: [1, 2, 0, 0] },
];

function runTests(fn, label) {
    console.log(`--- ${label} ---`);
    for (const { nums, expected } of testCases) {
        const result = fn([...nums]);
        const pass = result.every((v, i) => v === expected[i]);
        console.log(`[${pass ? "PASS" : "FAIL"}] result=[${result}] expected=[${expected}]`);
    }
}

runTests(moveZeros1, "moveZeros1 (swap)");
runTests(moveZeros2, "moveZeros2 (two passes)");
