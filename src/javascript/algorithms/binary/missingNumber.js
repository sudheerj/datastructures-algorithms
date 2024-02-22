//TC: O(n) SC: O(1)

function missingNumber1(nums) {
    let missingNumber = nums.length;
    for(let i=0; i< nums.length; i++) {
        missingNumber ^= nums[i] ^i;
    }
    return missingNumber;
}

function missingNumber2(nums) {
    let missingNumber = nums.length;
    for(let i=0; i< nums.length; i++) {
        missingNumber += i - nums[i];
    }
    return missingNumber;
}

let nums = [3, 1, 0];
console.log(missingNumber1(nums)); 
console.log(missingNumber2(nums)); 