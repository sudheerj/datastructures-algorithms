/**
 * Searches for a target in a rotated sorted array.
 * Returns the index of the target if found, otherwise -1.
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
function searchRotatedSortedArray(nums, target) {
    let left = 0;
    let right = nums.length - 1;

    while (left <= right) {
        const mid = Math.floor((left + right) / 2);

        // Found the target
        if (nums[mid] === target) return mid;

        // Determine which half is sorted
        if (nums[left] <= nums[mid]) {
            // Left side is sorted
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1; // Target in left half
            } else {
                left = mid + 1; // Target in right half
            }
        } else {
            // Right side is sorted
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1; // Target in right half
            } else {
                right = mid - 1; // Target in left half
            }
        }
    }

    return -1; // Target not found
}


let nums = [3, 4, 5, 6, 7, 0, 1, 2];
console.log(searchRotatedSortedArray(nums, 7));

let nums1 = [3, 4, 5, 6, 7, 0, 1, 2];
console.log(searchRotatedSortedArray(nums1, 9));