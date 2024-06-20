//Two pointers:- TC:O(n) SC: O(1)

function sortColors(nums) {

    let left = i = 0, right = nums.length-1;

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
    let temp = nums[one];
    nums[one] = nums[two];
    nums[two] = temp;
}

let nums1 = [2,0,2,1,1,0];
console.log(sortColors(nums1));

let nums2 = [2,0,1];
console.log(sortColors(nums2));