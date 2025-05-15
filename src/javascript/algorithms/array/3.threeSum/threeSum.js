// Two pointer approach:- Time Complexity: O(n logn) + O(n^2) => O(n^2), Space Complexity: O(1)
function threeSum(nums, target) {

    // Sort the array to facilitate the two-pointer approach
    nums.sort((a, b) => a - b);
    const triplets = [];

    for (let i = 0; i < nums.length - 2; i++) {
        // Skip duplicate numbers to avoid duplicate triplets
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }

        let left = i + 1, right = nums.length - 1;

        // Use two pointers to find the remaining two numbers
        while (left < right) {
            const sum = nums[i] + nums[left] + nums[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                // Found a valid triplet
                triplets.push([nums[i], nums[left], nums[right]]);

                // Move left pointer to the next unique number
                left++;
                while (left < right && nums[left] === nums[left - 1]) {
                    left++;
                }

                // Move right pointer to the next unique number
                right--;
                while (left < right && nums[right] === nums[right + 1]) {
                    right--;
                }
            }
        }
    }

    return triplets;
}

// Test cases
function runTests() {
    const testCases = [
        { nums: [3, 3, -1, -2, 0, -2, 0, -1, 0, -1], target: 0 },
        { nums: [1, 3, 5, 1], target: 0 },
        { nums: [-4, -1, -1, 0, 1, 2], target: 0 },
        { nums: [0, 0, 0], target: 0 }, // Edge case: all zeroes
    ];

    testCases.forEach(({ nums, target }, index) => {
        console.log(`Test Case ${index + 1}:`, threeSum(nums, target));
    });
}

runTests();