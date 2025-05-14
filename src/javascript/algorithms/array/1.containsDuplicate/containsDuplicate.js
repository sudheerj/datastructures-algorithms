// Using Set for early exit: TC: O(n), SC: O(n)
function containsDuplicate(nums) {
    const seen = new Set();
    for (const num of nums) {
        if (seen.has(num)) {
            return true; // Duplicate found
        }
        seen.add(num);
    }
    return false; // No duplicates
}

// Using Object for early exit: TC: O(n), SC: O(n)
function containsDuplicateUsingObject(nums) {
    const seen = {};
    for (const num of nums) {
        if (seen[num]) {
            return true; // Duplicate found
        }
        seen[num] = true;
    }
    return false; // No duplicates
}

// Using Set size comparison: TC: O(n), SC: O(n)
function containsDuplicateUsingSize(nums) {
    return new Set(nums).size !== nums.length;
}

// Using sort and iteration: TC: O(n log n), SC: O(1) (modifies input array)
function containsDuplicateUsingSort(nums) {
    nums.sort((a, b) => a - b); // Sort the array
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] === nums[i - 1]) {
            return true; // Duplicate found
        }
    }
    return false; // No duplicates
}

// Using brute-force: TC: O(n^2), SC: O(1) (inefficient for large arrays)
function containsDuplicateUsingBruteforce(nums) {
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] === nums[j]) {
                return true; // Duplicate found
            }
        }
    }
    return false; // No duplicates
}

// Test cases
console.log("-----Has duplicates----");
const numsWithDuplicates = [8, 6, 4, 2, 6];
console.log(containsDuplicate(numsWithDuplicates));
console.log(containsDuplicateUsingObject(numsWithDuplicates));
console.log(containsDuplicateUsingSize(numsWithDuplicates));
console.log(containsDuplicateUsingSort([...numsWithDuplicates])); // Spread to avoid modifying original
console.log(containsDuplicateUsingBruteforce(numsWithDuplicates));

console.log("-----No duplicates----");
const numsWithoutDuplicates = [1, 3, 5, 7, 9];
console.log(containsDuplicate(numsWithoutDuplicates));
console.log(containsDuplicateUsingObject(numsWithoutDuplicates));
console.log(containsDuplicateUsingSize(numsWithoutDuplicates));
console.log(containsDuplicateUsingSort([...numsWithoutDuplicates])); // Spread to avoid modifying original
console.log(containsDuplicateUsingBruteforce(numsWithoutDuplicates));