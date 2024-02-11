// Two pointer approach:- TC: O(n logn) + O(n*2) => O(n * 2), SC: O(1)
function threeSum(nums, target) {
    nums.sort((a, b) => a-b);
    let triplets = [];

    for(let i = 0; i < nums.length -2; i++) {
        if(i > 0 && nums[i] === nums[i-1]) continue;

        let left = i+1, right = nums.length -1;
        while(left < right) {
            let sum = nums[i] + nums[left] + nums[right];
            if(sum < target) {
                left++;
            } else if(sum > target) {
                right--;
            } else {
                let triplet =[];
                triplet.push(nums[i]);
                triplet.push(nums[left]);
                triplet.push(nums[right]);
                triplets.push(triplet);
                left++;
                while(left < right && nums[left] === nums[left-1]) left++;
            }
        }
    }
    return triplets;
}

let nums = [3, 3, -1, -2, 0, -2, 0, -1, 0, -1];
console.log(threeSum(nums, 0));

// Hashing:- TC: O(n logn) + O(n*2) => O(n * 2), SC: O(n)
function threeSumHashing(nums, target) {
    let triplets = [];
    let tripletSet = new Set();
    for(let i =0; i < nums.length - 2; i++) {
        for(let j=i+1; j< nums.length - 1; j++) {
            let compliment = target - (nums[i] + nums[j]);
            if(tripletSet.has(compliment)) {
                triplets.push([nums[i], nums[j], compliment]);
            } else {
                tripletSet.add(nums[j]);
            }
        }
    }
    return triplets;
}

let nums1 = [1, 2, 3, 4, 5, 6, 7, 8];
console.log(threeSumHashing(nums1, 9));