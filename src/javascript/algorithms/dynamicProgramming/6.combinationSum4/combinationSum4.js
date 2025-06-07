// TC: O(n * target), SC: O(target)
function combinationSum4(nums, target) {
  if (nums.length === 0) return 0;
  if (target === 0) return 1;

  let dp = new Array(target + 1).fill(0);
  dp[0] = 1;
  for (let i = 1; i <= target; i++) {
    for (let num of nums) {
      if (i >= num) {
        dp[i] += dp[i - num];
      }
    }
  }
  return dp[target];
}

// Test cases
let testCases = [
  { nums: [1, 2, 4], target: 5 },
  { nums: [7], target: 6 },
  { nums: [], target: 5 }, // Edge: empty nums
  { nums: [1, 2], target: 0 }, // Edge: target zero
  { nums: [3, 4, 5], target: 8 },
];
for (const { nums, target } of testCases) {
  console.log(
    `Nums: ${JSON.stringify(
      nums
    )}, Target: ${target} | CombinationSum4: ${combinationSum4(nums, target)}`
  );
}
