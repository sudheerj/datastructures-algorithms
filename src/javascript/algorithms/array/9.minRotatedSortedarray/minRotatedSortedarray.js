function minRotatedSortedArray(nums) {
    let result = nums[0];
    if(nums.length === 1) return nums[0];
    if(nums.length === 2) return Math.min(nums[0], nums[1]);

    let left = 0, right = nums.length - 1;     

    while(left < right) {
        if(nums[left] < nums[right]) {
            result = nums[left];
            break;
        }

        let mid = left + (right - left)/2;

        if(nums[mid] > nums[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return result;
}

let sortedArray = [3, 4, 5, 6, 7, 1, 2];
console.log(minRotatedSortedArray(sortedArray));

let sortedArray1 = [0, 1, 2, 4, 5, 6, 7, 8];
console.log(minRotatedSortedArray(sortedArray1));