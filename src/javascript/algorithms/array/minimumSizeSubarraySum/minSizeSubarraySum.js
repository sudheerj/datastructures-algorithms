// Sliding window: TC: O(n), SC: O(1)

function minSizeSubarraySum(nums, target) {
    
    let left = right = total = 0;
    let result = Infinity;

    while(right < nums.length) {
        total += nums[right];
        while(total >= target) {
            result = Math.min(right - left + 1, result);
            total -= nums[left++];
        }
        right++;
    }

    return result === Infinity ? 0 : result;
}

let target1 = 7, nums1 = [2,4,1,2,4,3];
let target2 = 5, nums2 = [1, 5, 5, 5];
let target3 = 15, nums3 = [2, 2, 2, 2, 2];

console.log(minSizeSubarraySum(nums1, target1));
console.log(minSizeSubarraySum(nums2, target2));
console.log(minSizeSubarraySum(nums3, target3));

