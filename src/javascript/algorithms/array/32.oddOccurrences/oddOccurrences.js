// Optimal solution using XOR: TC: O(n), SC: O(1)
function findOddNumber(nums) {
    let result = 0;

    for(const num of nums) {
        result ^= num;
    }

    return result;
}

// Using Object/Map: TC: O(n), SC: O(n)
function findOddNumberObj(nums) {
    const freqObj = {};

    for(const num of nums) {
        freqObj[num] = (freqObj[num] || 0) + 1;
    }

    for(const [key, value] of Object.entries(freqObj)) {
        if(value%2 !== 0) {
            return parseInt(key);
        }
    }

    return null;
}

const nums1 = [9, 3, 9, 3, 9, 7, 9];
const nums2 = [1, 1, 2];
const nums3 = [4];
const nums4 = [5, 5, 5];


console.log(findOddNumber(nums1)); // 7
console.log(findOddNumber(nums2)); // 2
console.log(findOddNumber(nums3)); // 4
console.log(findOddNumber(nums4)); // 5


console.log(findOddNumberObj(nums1)); // 7
console.log(findOddNumberObj(nums2)); // 2
console.log(findOddNumberObj(nums3)); // 4
console.log(findOddNumberObj(nums4)); // 5