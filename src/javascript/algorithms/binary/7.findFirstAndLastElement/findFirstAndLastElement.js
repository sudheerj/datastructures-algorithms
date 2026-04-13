// TC: O(log n) SC: O(1)
function findBound(nums, target, findFirst) {
    let left = 0, right = nums.length - 1, index = -1;

    while (left <= right) {
        let mid = left + Math.floor((right - left) / 2);

        if (nums[mid] === target) {
            index = mid;
            if (findFirst) {
                right = mid - 1; // shrink to left part
            } else {
                left = mid + 1; // shrink to right part
            }
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return index;
}

function searchRange(nums, target) {
    return [findBound(nums, target, true), findBound(nums, target, false)];
}

// Test cases
console.log("Test 1:", searchRange([5, 7, 7, 8, 8, 10], 8)); // [3, 4]
console.log("Test 2:", searchRange([5, 7, 7, 8, 8, 10], 6)); // [-1, -1]
console.log("Test 3:", searchRange([], 0)); // [-1, -1]
console.log("Test 4:", searchRange([5], 5)); // [0, 0]
console.log("Test 5:", searchRange([5], 3)); // [-1, -1]
console.log("Test 6:", searchRange([2, 2, 2, 2, 2], 2)); // [0, 4]
console.log("Test 7:", searchRange([1, 1, 3, 5, 7], 1)); // [0, 1]
console.log("Test 8:", searchRange([1, 3, 5, 7, 7], 7)); // [3, 4]
