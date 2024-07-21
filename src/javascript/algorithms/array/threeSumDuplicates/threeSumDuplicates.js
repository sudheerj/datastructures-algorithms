// Hashing:- TC: O(n logn) + O(n^2) => O(n^2), SC: O(n)
function threeSumHashing(nums, target) {
    let triplets = [];
    let tripletSet = new Set();
    for(let i =0; i < nums.length - 2; i++) {
        for(let j=i+1; j< nums.length - 1; j++) {
            let complement = target - (nums[i] + nums[j]);
            if(tripletSet.has(complement)) {
                triplets.push([nums[i], nums[j], complement]);
            } else {
                tripletSet.add(nums[j]);
            }
        }
    }
    return triplets;
}

let nums1 = [1, 2, 3, 4, 5, 6, 7, 8];
let nums2 = [-1,0,1,2,-1,-4];
console.log(threeSumHashing(nums1, 9));
console.log(threeSumHashing(nums2, 0));