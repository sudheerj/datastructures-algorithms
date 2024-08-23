//TC: O(2n) ~O(n), SC:O(1)

function rob(nums){
    if(nums.length === 0) return 0;
    if(nums.length === 1) return nums[0];

    return Math.max(robHelper(nums, 0, nums.length-2), robHelper(nums, 1, nums.length-1));
}

function robHelper(nums, start, end) {
    let rob1 = 0, rob2 = 0;
    for(let i=start; i<= end; i++) {
        let newRob = Math.max(nums[i]+rob1, rob2);
        rob1 = rob2;
        rob2 = newRob;
    }
    return rob2;
}

let nums1 = [1, 5, 7, 2, 4], nums2=[1, 2, 3], nums3=[3];
console.log(rob(nums1));
console.log(rob(nums2));
console.log(rob(nums3));