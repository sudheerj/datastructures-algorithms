// Sliding window: TC: O(n), SC: O(1)

function minSizeSubarraySum(nums, target) {
    
    let left = right = total = 0;
    let minLength = Infinity;

    while(right < nums.length) {
        total += nums[right];
        while(total >= target) {
            minLength = Math.min(right - left + 1, minLength);
            total -= nums[left++];
        }
        right++;
    }

    return minLength === Infinity ? 0 : minLength;
}

// Test Cases
  const testCases = [
    { target: 7, nums: [2, 4, 1, 2, 4, 3] },
    { target: 5, nums: [1, 5, 5, 5] },
    { target: 15, nums: [2, 2, 2, 2, 2] }
  ];
  
  for (const { target, nums } of testCases) {
    console.log(`Input: target = ${target}, nums = [${nums}]`);
    console.log(`Output: ${minSizeSubarraySum(nums, target)}\n`);
  }

