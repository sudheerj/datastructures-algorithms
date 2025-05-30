function maxSumSubarray(nums) {
    if(nums.length === 0) return 0;
    let currentMaxSum = globalMaxSum = nums[0];
    for(let i =1; i< nums.length; i++) {
        currentMaxSum = Math.max(nums[i], currentMaxSum + nums[i]);
        globalMaxSum = Math.max(currentMaxSum, globalMaxSum);
    }
    return globalMaxSum;
}

// Test cases
const numbers = [-7, -2, 3, 4, -5, 6, 7, -2];
const emptyNumbers = [];
console.log("Max Subarray Sum (numbers):", maxSumSubarray(numbers));
console.log("Max Subarray Sum (emptyNumbers):", maxSumSubarray(emptyNumbers));