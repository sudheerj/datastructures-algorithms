/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
function binarySearch(nums, target) {
    let left = 0, right = nums.length - 1;

    while (left <= right) {
        const mid = left + Math.floor((right - left) / 2);

        if (nums[mid] === target) return mid;
        else if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }

    return -1;
}

console.log(binarySearch([-1, 0, 3, 5, 9, 12], 9));   // 4
console.log(binarySearch([-1, 0, 3, 5, 9, 12], 2));   // -1
console.log(binarySearch([5], 5));                     // 0
console.log(binarySearch([5], 6));                     // -1
console.log(binarySearch([1, 2, 3, 4, 5], 1));        // 0
console.log(binarySearch([1, 2, 3, 4, 5], 5));        // 4
