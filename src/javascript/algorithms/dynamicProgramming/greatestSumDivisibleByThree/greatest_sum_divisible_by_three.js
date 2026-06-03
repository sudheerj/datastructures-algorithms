/**
 * Find the maximum sum of array elements that is divisible by 3.
 * 
 * TC: O(n * 3) ~= O(n) where n is the length of nums
 * SC: O(3) ~= O(1) as we only use fixed-size array
 * 
 * @param {number[]} nums - Array of integers
 * @return {number} Maximum sum divisible by 3
 */
function maxSumDivThree(nums) {
    // dp[i] stores the maximum sum with remainder i when divided by 3
    let dp = [0, 0, 0];
    
    for (let num of nums) {
        // Take snapshot of previous state to avoid overwriting during iteration
        let temp = [...dp];
        
        for (let sum of temp) {
            let newSum = sum + num;
            let remainder = newSum % 3;
            
            // Update best sum for this remainder
            dp[remainder] = Math.max(dp[remainder], newSum);
        }
    }
    
    return dp[0];
}

// Test cases
console.log("Test case 1: nums = [3,6,5,1,8]");
let result1 = maxSumDivThree([3, 6, 5, 1, 8]);
console.log(`Output: ${result1}`);
console.log("Expected: 18");
console.log("Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).");
console.log();

console.log("Test case 2: nums = [4]");
let result2 = maxSumDivThree([4]);
console.log(`Output: ${result2}`);
console.log("Expected: 0");
console.log("Explanation: Since 4 is not divisible by 3, do not pick any number.");
console.log();

console.log("Test case 3: nums = [1,2,3,4,4]");
let result3 = maxSumDivThree([1, 2, 3, 4, 4]);
console.log(`Output: ${result3}`);
console.log("Expected: 12");
console.log("Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).");
console.log();

console.log("Test case 4: nums = [2,6,2,2,7]");
let result4 = maxSumDivThree([2, 6, 2, 2, 7]);
console.log(`Output: ${result4}`);
console.log("Expected: 15");
console.log("Explanation: Pick numbers 6, 2, and 7 their sum is 15.");
console.log();

console.log("Test case 5: nums = [5,3,1,2]");
let result5 = maxSumDivThree([5, 3, 1, 2]);
console.log(`Output: ${result5}`);
console.log("Expected: 9");
console.log("Explanation: Pick numbers 5, 3, and 1 their sum is 9.");

module.exports = maxSumDivThree;
