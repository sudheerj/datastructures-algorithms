function maxSumCircularSubarray(nums) {
    if(nums.length === 0) return 0;

    let sum = nums[0];
    for(let i=1; i< nums.length; i++) {
        sum += nums[i]; 
    }

    let currentMaxSum = globalMaxSum = nums[0];
    let currentMinSum = globalMinSum = nums[0];
    for(let i =1; i< nums.length; i++) {
        currentMaxSum = Math.max(nums[i], currentMaxSum + nums[i]);
        globalMaxSum = Math.max(currentMaxSum, globalMaxSum);

        currentMinSum = Math.min(nums[i], currentMinSum + nums[i]);
        globalMinSum = Math.min(currentMinSum, globalMinSum);
    }

    if(currentMinSum ===  sum) {
        return globalMaxSum;
    }
    return Math.max(globalMaxSum, sum-globalMinSum);
}

let numbers = [9, -9, 6, 11, -6, -10, 15, 1];
let maxSumNumbers = maxSumCircularSubarray(numbers);
console.log("Max circular subarray Sum:", maxSumNumbers);

let emptyNumbers = [];
let maxSumEmptyNumbers = maxSumCircularSubarray(emptyNumbers);
console.log("Max circular subarray Sum:", maxSumEmptyNumbers);