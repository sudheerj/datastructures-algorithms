// TC:O(n) SC:O(1)
function robber1(nums) {
    let rob1 = nums[0], rob2 = nums[1];

    for(let i=2; i<nums.length; i++) {
        let temp = Math.max(nums[i] + rob1, rob2);
        rob1 = rob2;
        rob2 = temp;
    }
    return rob2;
}

// TC:O(n) SC:O(n)
function robber2(nums) {
    let dp = new Array(nums.length).fill(0);
    dp[0] = nums[0];
    dp[1] = nums[1];

    for(let i=2; i< nums.length; i++) {
        dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
    }
    return dp[nums.length-1];
}

let nums = [2,7,9,3,1];
console.log(robber1(nums));
console.log(robber2(nums));