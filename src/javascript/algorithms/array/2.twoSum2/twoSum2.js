//TC: O(n), SC: O(1)
function findTwoSumIndices(nums, target){
    let left = 0, right = nums.length-1;

    while(left < right) {
        const total = nums[left] + nums[right];

        if(total === target) {
            return [left+1, right+1]; // Return 1-based indices 
        } else if(total > target) {
            right--; //Move the right pointer leftward
        } else {
            left++; //Move the left pointer rightward
        }
    }

    return [-1, -1];
}

let nums1 = [2,7,11,15,9];
let target1 = 16;
let nums2 = [-2, 0, 3, 5];
let target2 = 1;
// Output results
console.log(`Indices for target ${target1} in nums1:`, findTwoSumIndices(nums1, target1));
console.log(`Indices for target ${target2} in nums2:`, findTwoSumIndices(nums2, target2));