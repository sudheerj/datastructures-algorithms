//Greedy:- TC:O(n) SC:O(1)
function canJump1(nums) {
    let goalPost = nums.length-1;

    for(let i = nums.length-1; i>=0; i--) {
        let jumpDistance = i + nums[i];
        if(jumpDistance >= goalPost) {
            goalPost = i;
        }
    }
    return goalPost === 0;
}

//DP:- TC:O(n*2) SC:O(n)
function canJump2(nums) {
    if(nums.length === 1) return true;
    if(nums[0] === 0) return false;

    let dp = new Array(nums.length).fill(false);
    dp[0] = true;

    for(let i=1; i< nums.length; i++) {
        for(let j=0; j<i; j++) {
            if(dp[j] && j + nums[j] >=i) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[nums.length-1];
}

let nums1 = [2,3,1,1,4];
let nums2 = [3,2,1,0,4];
console.log(canJump1(nums1));
console.log(canJump1(nums2));
console.log(canJump2(nums1));
console.log(canJump2(nums2));