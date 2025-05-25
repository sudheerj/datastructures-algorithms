function firstMissingPositive(nums) {
    const length = nums.length;
    const nonExistNum = length + 1;

    // Step 1: Replace non-positive and out-of-bound numbers with a placeholder
    for (let i = 0; i < length; i++) {
        if (nums[i] <= 0 || nums[i] > length) {
            nums[i] = nonExistNum;
        }
    }

    // Step 2: Mark indices for numbers that exist
    for (let i = 0; i < length; i++) {
        const val = Math.abs(nums[i]);
        if (val <= length) {
            const index = val - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
    }

    // Step 3: Find the first index that is still positive
    for (let i = 0; i < length; i++) {
        if (nums[i] > 0) {
            return i + 1;
        }
    }

    // Step 4: All numbers from 1 to length are present
    return length + 1;
}


let nums1 = [3, 4, -1, 1];       // Output: 2
let nums2 = [-1, 7, 8, 9, 11];   // Output: 1
let nums3 = [1, 2, 0];           // Output: 3
let nums4 = [1, 2, 3];           // Output: 4
let nums5 = [];                  // Output: 1

console.log(firstMissingPositive(nums1));
console.log(firstMissingPositive(nums2));
console.log(firstMissingPositive(nums3));
console.log(firstMissingPositive(nums4));
console.log(firstMissingPositive(nums5));
