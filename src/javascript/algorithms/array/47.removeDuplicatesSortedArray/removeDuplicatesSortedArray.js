// TC: O(n) SC: O(1)
function removeDuplicates(nums) {
    let left = 0;

    for (let j = 1; j < nums.length; j++) {
        if (nums[j] !== nums[left]) {
            left++;
            nums[left] = nums[j];
        }
    }

    return left + 1;
}

// Test cases
// Test 1: General case with duplicates
let nums1 = [1, 1, 2];
let count1 = removeDuplicates(nums1);
console.log("Test 1:", nums1.slice(0, count1)); // [1, 2]

// Test 2: Multiple duplicates
let nums2 = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
let count2 = removeDuplicates(nums2);
console.log("Test 2:", nums2.slice(0, count2)); // [0, 1, 2, 3, 4]

// Test 3: No duplicates
let nums3 = [1, 2, 3, 4, 5];
let count3 = removeDuplicates(nums3);
console.log("Test 3:", nums3.slice(0, count3)); // [1, 2, 3, 4, 5]

// Test 4: Single element
let nums4 = [1];
let count4 = removeDuplicates(nums4);
console.log("Test 4:", nums4.slice(0, count4)); // [1]

// Test 5: All same elements
let nums5 = [7, 7, 7, 7];
let count5 = removeDuplicates(nums5);
console.log("Test 5:", nums5.slice(0, count5)); // [7]

// Test 6: Negative numbers
let nums6 = [-3, -1, -1, 0, 0, 2];
let count6 = removeDuplicates(nums6);
console.log("Test 6:", nums6.slice(0, count6)); // [-3, -1, 0, 2]

// Test 7: Two elements - duplicates
let nums7 = [5, 5];
let count7 = removeDuplicates(nums7);
console.log("Test 7:", nums7.slice(0, count7)); // [5]
