//Using XOR operation - TC: O(n) SC: O(1)
function missingNumber1(nums) {
    let missingNumber = nums.length;
    for(let i=0; i< nums.length; i++) {
        missingNumber ^= nums[i] ^i;
    }
    return missingNumber;
}

//Using numbers sum- TC: O(n) SC: O(1)
function missingNumber2(nums) {
    let missingNumber = nums.length;
    for(let i=0; i< nums.length; i++) {
        missingNumber += i - nums[i];
    }
    return missingNumber;
}

let nums1 = [3, 1, 0];
let nums2 = [5, 9, 7, 1, 2, 4, 0, 6, 8, 3];
console.log(missingNumber1(nums1)); 
console.log(missingNumber2(nums1)); 

console.log(missingNumber1(nums2)); 
console.log(missingNumber2(nums2)); 