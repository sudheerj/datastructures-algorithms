// Early exist:- TC: O(n), SC: O(1)
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

//Use Set size:- TC: O(n), SC: O(1)
function containsDuplicateUsingSize(nums) {
    return new Set(nums).size !== nums.length;
}

console.log("-----Has duplicates----");
let nums1 = [8, 6, 4, 2, 6];
console.log(containsDuplicate(nums1));
console.log(containsDuplicateUsingSize(nums1));
console.log("-----No duplicates----");
let nums2 = [1, 3, 5, 7, 9];
console.log(containsDuplicate(nums2));
console.log(containsDuplicateUsingSize(nums2));