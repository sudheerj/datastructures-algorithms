// Two pointer approach:- TC: O(n logn) + O(n^2) => O(n^2), SC: O(1)
function threeSum(nums, target) {
    nums.sort((a, b) => a-b);
    let triplets = [];

    for(let i = 0; i < nums.length -2; i++) {
        //It avoids duplicates
        if(i > 0 && nums[i] === nums[i-1]) continue;

        let left = i+1, right = nums.length -1;
        while(left < right) {
            let sum = nums[i] + nums[left] + nums[right];
            if(sum < target) {
                left++;
            } else if(sum > target) {
                right--;
            } else {
                triplets.push([nums[i], nums[left], nums[right]]);
                left++;
                //It avoids duplicates
                while(left < right && nums[left] === nums[left-1]) left++;
            }
        }
    }
    return triplets;
}

let nums1 = [3, 3, -1, -2, 0, -2, 0, -1, 0, -1];
let nums2 = [1, 3, 5, 1];
console.log(threeSum(nums1, 0));
console.log(threeSum(nums2, 0));