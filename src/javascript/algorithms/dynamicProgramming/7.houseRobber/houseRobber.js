// TC:O(n) SC:O(1)
function robber1(nums) {
    let rob1 = 0, rob2 = 0;

    for(let num of nums) {
        let newRob = Math.max(num + rob1, rob2);
        rob1 = rob2;
        rob2 = newRob;
    }
    return rob2;
}

// TC:O(n) SC:O(n)
function robber2(nums) {
    let dp = new Array(nums.length).fill(0);
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for(let i=2; i< nums.length; i++) {
        dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
    }
    return dp[nums.length-1];
}

let nums1 = [1,5,7,2,4], nums2 = [8, 1, 2, 9];
console.log(robber1(nums1));
console.log(robber2(nums1));
console.log(robber1(nums2));
console.log(robber2(nums2));