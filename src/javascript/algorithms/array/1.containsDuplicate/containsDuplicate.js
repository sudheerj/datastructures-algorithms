// Early exit using set:- TC: O(n), SC: O(n)
function containsDuplicate(nums) {
    let noDupsSet = new Set();
    for(const num of nums) {
        if(noDupsSet.has(num)) {
            return true;
        }
        noDupsSet.add(num);
    }
    return false;
}

// Early exit using object:- TC: O(n), SC: O(n)
function containsDuplicateUsingObject(nums) {
    let noDupsObj = {};
    for(const num of nums) {
        if(noDupsObj[num]) {
            return true;
        }
        noDupsObj[num] = true;
    }
    return false;
}

//Use Set size:- TC: O(n), SC: O(n)
function containsDuplicateUsingSize(nums) {
    return new Set(nums).size !== nums.length;
}

//Using sort and iteration:- TC: O(n log n), SC: O(n)
function containsDuplicateUsingSort(nums) {
    nums.sort((a, b) => a-b);
    for(let i =1; i< nums.length; i++) {
        if(nums[i] === nums[i-1]) {
            return true;
        }
    }
    return false;
}

//Using naive/Brute force:- TC: O(n^2), SC: O(1)
function containsDuplicateUsingBruteforce(nums) {
    for(let i =0; i< nums.length-1; i++) {
        for (let j = i+1; j < nums.length; j++) {
            if(nums[i] == nums[j]) {
                return true;
            }           
        }
    }
    return false;
}

console.log("-----Has duplicates----");
let nums1 = [8, 6, 4, 2, 6];
console.log(containsDuplicate(nums1));
console.log(containsDuplicateUsingObject(nums1));
console.log(containsDuplicateUsingSize(nums1));
console.log(containsDuplicateUsingSort(nums1));
console.log(containsDuplicateUsingBruteforce(nums1));
console.log("-----No duplicates----");
let nums2 = [1, 3, 5, 7, 9];
console.log(containsDuplicate(nums2));
console.log(containsDuplicateUsingObject(nums2));
console.log(containsDuplicateUsingSize(nums2));
console.log(containsDuplicateUsingSort(nums2));
console.log(containsDuplicateUsingBruteforce(nums2));