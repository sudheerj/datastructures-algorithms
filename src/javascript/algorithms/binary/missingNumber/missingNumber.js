// Approach 1: Sum difference — O(n) time, O(1) space
function missingNumber1(nums) {
    let missing = nums.length;
    for (let i = 0; i < nums.length; i++) {
        missing += i - nums[i];
    }
    return missing;
}

// Approach 2: XOR — O(n) time, O(1) space
function missingNumber2(nums) {
    let missing = nums.length;
    for (let i = 0; i < nums.length; i++) {
        missing ^= i ^ nums[i];
    }
    return missing;
}

// Approach 3: HashSet — O(n) time, O(n) space
function missingNumber3(nums) {
    const numSet = new Set(nums);
    for (let i = 0; i <= nums.length; i++) {
        if (!numSet.has(i)) return i;
    }
    return -1;
}

const nums1 = [3, 1, 0];
const nums2 = [5, 9, 7, 1, 2, 4, 0, 6, 8, 3];
const nums3 = [0];
const nums4 = [1];
const nums5 = [0, 1, 2, 3, 4, 5, 6, 7, 9];

// Approach 1: sum difference
const r1 = missingNumber1(nums1);
console.log(`Test 1a (sum) - [3,1,0]: ${r1 === 2 ? '[PASS]' : '[FAIL]'} result=${r1} expected=2`);
const r2 = missingNumber1(nums2);
console.log(`Test 2a (sum) - 10-elem missing 10: ${r2 === 10 ? '[PASS]' : '[FAIL]'} result=${r2} expected=10`);
const r3 = missingNumber1(nums3);
console.log(`Test 3a (sum) - [0]: ${r3 === 1 ? '[PASS]' : '[FAIL]'} result=${r3} expected=1`);
const r4 = missingNumber1(nums4);
console.log(`Test 4a (sum) - [1]: ${r4 === 0 ? '[PASS]' : '[FAIL]'} result=${r4} expected=0`);
const r5 = missingNumber1(nums5);
console.log(`Test 5a (sum) - missing 8: ${r5 === 8 ? '[PASS]' : '[FAIL]'} result=${r5} expected=8`);

// Approach 2: XOR
const r6 = missingNumber2(nums1);
console.log(`Test 1b (xor) - [3,1,0]: ${r6 === 2 ? '[PASS]' : '[FAIL]'} result=${r6} expected=2`);
const r7 = missingNumber2(nums2);
console.log(`Test 2b (xor) - 10-elem missing 10: ${r7 === 10 ? '[PASS]' : '[FAIL]'} result=${r7} expected=10`);
const r8 = missingNumber2(nums3);
console.log(`Test 3b (xor) - [0]: ${r8 === 1 ? '[PASS]' : '[FAIL]'} result=${r8} expected=1`);
const r9 = missingNumber2(nums4);
console.log(`Test 4b (xor) - [1]: ${r9 === 0 ? '[PASS]' : '[FAIL]'} result=${r9} expected=0`);
const r10 = missingNumber2(nums5);
console.log(`Test 5b (xor) - missing 8: ${r10 === 8 ? '[PASS]' : '[FAIL]'} result=${r10} expected=8`);

// Approach 3: HashSet
const r11 = missingNumber3(nums1);
console.log(`Test 1c (set) - [3,1,0]: ${r11 === 2 ? '[PASS]' : '[FAIL]'} result=${r11} expected=2`);
const r12 = missingNumber3(nums2);
console.log(`Test 2c (set) - 10-elem missing 10: ${r12 === 10 ? '[PASS]' : '[FAIL]'} result=${r12} expected=10`);
const r13 = missingNumber3(nums3);
console.log(`Test 3c (set) - [0]: ${r13 === 1 ? '[PASS]' : '[FAIL]'} result=${r13} expected=1`);
const r14 = missingNumber3(nums4);
console.log(`Test 4c (set) - [1]: ${r14 === 0 ? '[PASS]' : '[FAIL]'} result=${r14} expected=0`);
const r15 = missingNumber3(nums5);
console.log(`Test 5c (set) - missing 8: ${r15 === 8 ? '[PASS]' : '[FAIL]'} result=${r15} expected=8`);
