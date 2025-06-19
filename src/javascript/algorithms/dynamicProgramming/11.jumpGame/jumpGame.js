//Greedy:- TC:O(n) SC:O(1)
function canJumpGreedy(nums) {
    let goalPost = nums.length-1;

    for(let i = nums.length-1; i>=0; i--) {
        let jumpDistance = i + nums[i];
        if(jumpDistance >= goalPost) {
            goalPost = i;
        }
    }
    return goalPost === 0;
}

// Dynamic Programming Approach: TC: O(n^2), SC: O(n)
function canJumpDP(nums) {
    let length = nums.length;

    if(length === 1) return true;
    if(nums[0] === 0) return false;

    let dp = new Array(length).fill(false);
    dp[0] = true;

    for(let i=1; i< length; i++) {
        for(let j=0; j<i; j++) {
            if(dp[j] && j + nums[j] >=i) {
                dp[i] = true;
                break; // No need to check further if we already found a valid jump
            }
        }
    }
    return dp[length-1];
}

let nums1 = [3,2,1,1,4];
let nums2 = [3,2,1,0,5];
console.log(canJumpGreedy(nums1));
console.log(canJumpGreedy(nums2));
console.log(canJumpDP(nums1));
console.log(canJumpDP(nums2));