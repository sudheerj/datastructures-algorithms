function searchRotatedSortedArray(nums, target) {
    let left = 0;
    let right = nums.length - 1;

    while(left <= right) {
        let mid = left + (right-left)/2;
        if(nums[mid] === target) {
            return mid;
        }

        if(nums[left] <= nums[mid]) {
            if(nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
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