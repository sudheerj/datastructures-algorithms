//Two pointers:- TC:O(n) SC: O(1)

function sortColors(nums) {

    let left = 0, i = 0, right = nums.length-1;

    while(i <= right) {
        if(nums[i] === 0) {
            swap(nums, i, left);
            left++;
            i++;
        } else if(nums[i] === 2) {
            swap(nums, i, right);
            right--;
        } else {
            i++;
        }
    }

    return nums;
}

function swap(nums, one, two) {
    [nums[one], nums[two]] = [nums[two], nums[one]];
}

let nums1 = [2,1,0,1,2,0];
console.log(sortColors(nums1));

let nums2 = [2,1,0];
console.log(sortColors(nums2));