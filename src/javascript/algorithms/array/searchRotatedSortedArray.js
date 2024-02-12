// TC: O(log n), SC: O(1)
function searchRotatedSortedArray(nums, target) {
    let left = 0;
    let right = nums.length - 1;

    while(left <= right) {
        let mid = Math.floor(left + (right-left)/2);
        if(nums[mid] === target) {
            return mid;
        }

        if(nums[left] <= nums[mid]) { // Left to mid is sorted
            if(nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else { // Mid to right is sorted
            if(nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    return -1;
}

let nums = [3, 4, 5, 6, 7, 0, 1, 2];
console.log(searchRotatedSortedArray(nums, 7));

let nums1 = [3, 4, 5, 6, 7, 0, 1, 2];
console.log(searchRotatedSortedArray(nums1, 9));