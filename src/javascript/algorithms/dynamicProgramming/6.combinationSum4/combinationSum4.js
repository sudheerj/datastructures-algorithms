// TC: O(nums * target) SC: O(target)

function combinationSum4(nums, target) {
    let dp = new Array(target+1).fill(0);
    dp[0] = 1;
    for(let i=1; i<=target; i++) {
        for(let num of nums) {
            if(i>=num) {
                dp[i] += dp[i-num];
            }
        }
    }
    return dp[target];
}

let nums1 = [1, 2, 4], target1 = 5;
let nums2 = [7], target2 = 6;
console.log(combinationSum4(nums1, target1));
console.log(combinationSum4(nums2, target2));