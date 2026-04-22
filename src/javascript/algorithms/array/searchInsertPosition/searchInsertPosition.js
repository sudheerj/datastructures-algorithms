function searchInsert(nums, target) {
    let left = 0, right = nums.length - 1;
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        if (nums[mid] === target) return mid;
        else if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return left;
}

module.exports = searchInsert;

if (require.main === module) {
    const testCases = [
        { nums: [1, 3, 5, 6], target: 5, expected: 2 },
        { nums: [1, 3, 5, 6], target: 2, expected: 1 },
        { nums: [1, 3, 5, 6], target: 7, expected: 4 },
        { nums: [1, 3, 5, 6], target: 0, expected: 0 },
        { nums: [], target: 3, expected: 0 },
        { nums: [1], target: 0, expected: 0 },
        { nums: [1], target: 2, expected: 1 },
        { nums: [1], target: 1, expected: 0 },
    ];
    testCases.forEach((tc, i) => {
        const result = searchInsert(tc.nums, tc.target);
        console.log(`Test ${i+1}: searchInsert([${tc.nums}], ${tc.target}) = ${result} | Expected: ${tc.expected} | ${result === tc.expected ? 'PASS' : 'FAIL'}`);
    });
}
