/**
 * Returns the length of the longest increasing subsequence in the array.
 * Uses O(n^2) dynamic programming.
 * @param {number[]} nums - Array of integers
 * @returns {number}
 */
function lengthOfLIS_DP(nums) {
  if (nums.length === 0) return 0;

  const dp = new Array(nums.length).fill(1);
  let maxLength = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] < nums[j]) {
        dp[i] = Math.max(dp[i], 1 + dp[j]);
      }
    }
    maxLength = Math.max(maxLength, dp[i]);
  }
  return maxLength;
}

/**
 * Returns the length of the longest increasing subsequence in the array.
 * Uses O(n log n) patience sorting (binary search).
 * @param {number[]} nums
 * @returns {number}
 */
function lengthOfLIS_BinarySearch(nums) {
  const tails = [];
  for (const num of nums) {
    let left = 0,
      right = tails.length;
    while (left < right) {
      const mid = Math.floor((left + right) / 2);
      if (tails[mid] < num) left = mid + 1;
      else right = mid;
    }
    tails[left] = num;
  }
  return tails.length;
}

// Test cases
const testCases = [
  { nums: [9, 7, 1, 4, 2, 6, 10, 12], expected: 5 },
  { nums: [1, 3, 4, 6, 7, 8], expected: 6 },
  { nums: [5, 4, 3, 2, 1], expected: 1 },
  { nums: [], expected: 0 },
  { nums: [2, 2, 2, 2], expected: 1 },
  { nums: [10], expected: 1 },
  { nums: [1, 2, 3, 4, 5], expected: 5 },
  { nums: [3, 1, 2], expected: 2 },
];

for (const { nums, expected } of testCases) {
  console.log(
    `nums = [${nums}] | DP: ${lengthOfLIS_DP(
      nums
    )} | BinarySearch: ${lengthOfLIS_BinarySearch(
      nums
    )} | Expected: ${expected}`
  );
}

// Edge case: invalid input
try {
  lengthOfLIS_DP("not an array");
} catch (e) {
  console.log("Error (as expected for invalid input):", e.message);
}
