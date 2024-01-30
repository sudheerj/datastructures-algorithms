function maxSumSubarray(nums) {
    if(nums.length === 0) return 0;
    let currentMaxSum = globalMaxSum = nums[0];
    for(let i =1; i< nums.length; i++) {
        currentMaxSum = Math.max(nums[i], currentMaxSum + nums[i]);
        globalMaxSum = Math.max(currentMaxSum, globalMaxSum);
    }
    return globalMaxSum;
}

let numbers = [1, 2, 3, 4, 5, 6, 7];
let maxSumNumbers = maxSubarray(numbers);
console.log("Max Subarray Sum:", maxSumNumbers);

let emptyNumbers = [];
let maxSumEmptyNumbers = maxSubarray(emptyNumbers);
console.log("Max Subarray Sum:", maxSumEmptyNumbers);