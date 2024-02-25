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

let nums = [1, 2, 3];
let target = 4;
console.log(combinationSum4(nums, target));