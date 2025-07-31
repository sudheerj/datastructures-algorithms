//TC: O(n), SC: O(n)
function twoSumWithMap(nums, target) {
    if(nums.length < 2) return [];
    const indexMap = new Map();

    for(let i=0; i < nums.length; i++) {
        const complement = target - nums[i];
        if(indexMap.has(complement)) {
            return [indexMap.get(complement), i];
        }
        indexMap.set(nums[i], i);
    }
    return [];
}

//TC: O(n), SC: O(n)
function twoSumWithObject(nums, target) {
    if(nums.length < 2) return [];
    const indexObj = {};

    for(let i=0; i < nums.length; i++) {
        const complement = target - nums[i];
        if(indexObj.hasOwnProperty(complement)) {
            return [indexObj[complement], i];
        }
        indexObj[nums[i]] = i;
    }
    return [];
}




// Unique Numbers
console.log("Input: [3, 4, 9, 14], Target: 12");
console.log("Output: ", twoSumWithMap([3, 4, 9, 14], 12));

// Duplicate Numbers
console.log("Input: [5, 7, 4, 7], Target: 14");
console.log("Output: ", twoSumWithObject([5, 7, 4, 7], 14));

// No sum Numbers
console.log("Input: [7, 1, 13, 1], Target: 10");
console.log("Output: ", twoSumWithObject([7, 1, 13, 1], 10));

// Negative Numbers
console.log("Input: [-5, -4, -3, -1, -2], Target: -10");
console.log("Output: ", twoSumWithMap([-5, -4, -3, -1, -2], -10));

// One number Array
console.log("Input: [3], Target: 4");
console.log("Output: ", twoSumWithMap([3], 4));

// Empty Array
console.log("Input: [], Target: 0");
console.log("Output: ", twoSumWithObject([], 0));
