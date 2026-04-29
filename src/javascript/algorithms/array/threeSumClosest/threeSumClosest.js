// Three Sum Closest
// Given an integer array nums and an integer target, return the sum of the three integers in nums such that the sum is closest to target.

function threeSumClosest(nums, target) {
    nums.sort((a, b) => a - b);
    let closestSum = nums[0] + nums[1] + nums[2];
    for (let i = 0; i < nums.length - 2; i++) {
        let left = i + 1, right = nums.length - 1;
        while (left < right) {
            let currSum = nums[i] + nums[left] + nums[right];
            if (Math.abs(currSum - target) < Math.abs(closestSum - target)) {
                closestSum = currSum;
            }
            if (currSum < target) {
                left++;
            } else if (currSum > target) {
                right--;
            } else {
                return currSum;
            }
        }
    }
    return closestSum;
}

// Example test cases
console.log(threeSumClosest([1, 2, 4, 8, 16, 32, 64, 128], 82)); // Output: 82
console.log(threeSumClosest([-1, 2, 1, -4], 1)); // Output: 2
console.log(threeSumClosest([0, 0, 0], 1)); // Output: 0
