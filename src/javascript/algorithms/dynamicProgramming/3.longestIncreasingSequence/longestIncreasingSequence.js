// TC:O(n * 2) SC:O(n)

function lengthOfLIS(nums) {
    let dp = new Array(nums.length).fill(1);
    let maxLength = 1;
    for(let i=nums.length-1; i>=0; i--) {
        for(let j=i+1; j<nums.length; j++){
            if(nums[i]< nums[j]) {
                dp[i] = Math.max(dp[i], 1+dp[j]);
            }
        }
        maxLength = Math.max(maxLength, dp[i]);
    }
    return maxLength;
}

const nums1 = [9,7,1,4,2,6,10,12];
const nums2 = [1,3,4,6,7,8];
const nums3 = [5,4,3,2,1];

console.log(lengthOfLIS(nums1));
console.log(lengthOfLIS(nums2));
console.log(lengthOfLIS(nums3));