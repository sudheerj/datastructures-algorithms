// House Robber II (Circular Houses)
// TC: O(n), SC: O(1)
function houseRobber2(nums) {
  if (nums.length === 0) return 0;
  if (nums.length === 1) return nums[0];

  // Exclude first or last house
    return Math.max(robLinear(nums, 0, nums.length-2), robLinear(nums, 1, nums.length-1));
}

// Helper to rob linear houses
function robLinear(nums, start, end) {
    let rob1 = 0, rob2 = 0;
    for(let i=start; i<= end; i++) {
        let newRob = Math.max(nums[i]+rob1, rob2);
        rob1 = rob2;
        rob2 = newRob;
    }
    return rob2;
}

// Test cases
let testCases = [
  [],
  [5],
  [2, 1],
  [1, 5, 7, 2, 4],
  [1, 2, 3],
  [3],
  [2, 3, 2],
  [0, 0, 0],
];
for (const nums of testCases) {
  console.log(
    `Input: ${JSON.stringify(nums)} | Robber2: ${houseRobber2(nums)}`
  );
}
