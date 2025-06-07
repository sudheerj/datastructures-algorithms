// House Robber Problem
// TC: O(n), SC: O(1)
function houseRobberOptimized(nums) {
  if (nums.length === 0) return 0;
  if (nums.length === 1) return nums[0];
  let rob1 = 0, rob2 = 0;

  for(let num of nums) {
      let newRob = Math.max(num + rob1, rob2);
      rob1 = rob2;
      rob2 = newRob;
  }
  return rob2;
}

// TC: O(n), SC: O(n)
function houseRobberDP(nums) {
  if (nums.length === 0) return 0;
  if (nums.length === 1) return nums[0];
  let dp = new Array(nums.length).fill(0);
  dp[0] = nums[0];
  dp[1] = Math.max(nums[0], nums[1]);
  for (let i = 2; i < nums.length; i++) {
    dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
  }
  return dp[nums.length - 1];
}

// Test cases
let testCases = [
  [], // Edge: empty
  [5], // Edge: single house
  [2, 1], // Edge: two houses
  [1, 5, 7, 2, 4],
  [8, 1, 2, 9],
  [2, 7, 9, 3, 1],
  [0, 0, 0], // Edge: all zero
];
for (const nums of testCases) {
  console.log(
    `Input: ${JSON.stringify(nums)} | Optimized: ${houseRobberOptimized(
      nums
    )} | DP: ${houseRobberDP(nums)}`
  );
}
