function maxSumCircularSubarray(nums) {
    if(nums.length === 0) return 0;

    let globalMaxSum = nums[0], globalMinSum = nums[0];
    let currentMaxSum = 0, currentMinSum = 0;
    let totalSum = 0;

    for (const num of nums) {
        currentMaxSum = Math.max(currentMaxSum + num, num);
        currentMinSum = Math.min(currentMinSum + num, num);

        totalSum += num;

        globalMaxSum = Math.max(currentMaxSum, globalMaxSum);
        globalMinSum = Math.min(currentMinSum, globalMinSum);
    }

    return globalMaxSum > 0 ? Math.max(globalMaxSum, (totalSum-globalMinSum)) : globalMaxSum;
}

let numbers = [9, -9, 6, 11, -6, -10, 15, 1];
console.log("Max circular subarray Sum:", maxSumCircularSubarray(numbers));

let numbers1 = [6,-2,6];
console.log("Max circular subarray Sum:", maxSumCircularSubarray(numbers1));

let numbers2 = [-6,-2,-6];
console.log("Max circular subarray Sum:", maxSumCircularSubarray(numbers2));

let emptyNumbers = [];
console.log("Max circular subarray Sum:", maxSumCircularSubarray(emptyNumbers));