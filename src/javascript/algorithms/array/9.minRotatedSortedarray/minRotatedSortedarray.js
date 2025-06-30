function minRotatedSortedarray(nums) {
    if(nums.length === 1) return nums[0];
    if(nums.length === 2) return Math.min(nums[0], nums[1]);

    let left = 0;
    let right = nums.length - 1;

    while (left < right) {
        // If the array is already sorted
        if (nums[left] < nums[right]) return nums[left];

        const mid = Math.floor((left + right) / 2);

        if (nums[mid] > nums[right]) {
            // Minimum is in the right half
            left = mid + 1;
        } else {
            // Minimum is in the left half (including mid)
            right = mid;
        }
    }

    return nums[left]; // or nums[right], both are the same here
}



let sortedArray = [3, 4, 5, 6, 7, 1, 2];
console.log(minRotatedSortedarray(sortedArray));

let sortedArray1 = [0, 1, 2, 4, 5, 6, 7, 8];
console.log(minRotatedSortedarray(sortedArray1));