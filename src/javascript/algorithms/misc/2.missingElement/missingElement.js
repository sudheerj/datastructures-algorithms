//TC: O(n), SC: O(1)
function missingElement(nums) {
    const length = nums.length;
    const actualNumsSum = nums.reduce((sum, num) => sum + num, 0);
    const expectedNumsSum = (length + 1)* (length+2)/2

    return expectedNumsSum - actualNumsSum;
}


// Example 1
const num1 = [2, 3, 1, 5];
console.log(missingElement(num1)); // Output: 4

// Example 2
const num2 = [1, 2, 3, 4, 6];
console.log(missingElement(num2)); // Output: 5

// Example 3
const num3 = [];
console.log(missingElement(num3)); // Output: 1
