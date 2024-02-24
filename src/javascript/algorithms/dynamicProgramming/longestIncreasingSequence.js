// TC:O(n * 2) SC:O(n)

function lengthOfLIS(nums) {
    let dp = new Array(nums.length).fill(0);
    dp[0] = 1;
    let maxLength = 0;
    for(let i=1; i< nums.length; i++) {
        let len = 0;
        for(let j=0; j<i; j++){
            if(nums[j]< nums[i]) {
                len = Math.max(len, dp[j]);
            }
            dp[i] = 1 + len;
        }
        maxLength = Math.max(maxLength, dp[i]);
    }
    return maxLength;
}

let nums = [10,9,2,5,3,7,101,18];
console.log(lengthOfLIS(nums));