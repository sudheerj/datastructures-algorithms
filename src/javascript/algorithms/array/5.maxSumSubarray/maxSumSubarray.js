function maxSumSubarray(nums) {
    if (nums.length === 0) return 0;

    let currentMaxSum = nums[0], globalMaxSum = nums[0];

    for (let i = 1; i < nums.length; i++) {
        currentMaxSum = Math.max(nums[i], currentMaxSum + nums[i]);
        globalMaxSum = Math.max(globalMaxSum, currentMaxSum);
    }

    return globalMaxSum;
}


// Test cases
const numbers = [-7, -2, 3, 4, -5, 6, 7, -2]; // Expected: 15
const allNegatives = [-8, -3, -6, -2, -5, -4]; // Expected: -2 (least negative)
const allPositives = [1, 2, 3, 4]; // Expected: 10
const mixed = [5, -2, 3, -1, 2]; // Expected: 7
const emptyNumbers = [];// Expected: 0

console.log("Max Subarray Sum (numbers):", maxSumSubarray(numbers));
console.log("Max Subarray Sum (allNegatives):", maxSumSubarray(allNegatives));
console.log("Max Subarray Sum (allPositives):", maxSumSubarray(allPositives));
console.log("Max Subarray Sum (mixed):", maxSumSubarray(mixed));
console.log("Max Subarray Sum (emptyNumbers):", maxSumSubarray(emptyNumbers));
