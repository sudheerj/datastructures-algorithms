//TC: O(2n) ~O(n), SC:O(1)

function rob(nums){
    if(nums.length === 0) return 0;
    if(nums.length === 1) return nums[0];
    if(nums.length == 2) return Math.max(nums[0], nums[1]);

    return Math.max(robHelper(nums, 0, nums.length-2), robHelper(nums, 1, nums.length-1));
}

function robHelper(nums, start, end) {
    let rob1 = nums[start], rob2 = nums[start+1];
    for(let i=2; i< nums[end]; i++) {
        let temp = Math.max(nums[i]+rob1, rob2);
        rob1 = rob2;
        rob2 = temp;
    }
    return rob2;
}

let nums = [1, 2, 3, 1];
console.log(rob(nums));