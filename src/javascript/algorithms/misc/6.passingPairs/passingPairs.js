function passingCars(nums) {
    let eastCars = 0, passingPairs = 0;

    for (let i = 0; i < nums.length; i++) {
        if(nums[i] === 0) {
            eastCars++;
        } else {
            passingPairs += eastCars;
            if(passingPairs > 1000000000) { return -1;}
        }
    }

    return passingPairs;
}

// Test Case 1: Mixed directions
const nums1 = [0, 1, 0, 1, 1];
console.log(passingCars(nums1)); // ➞ 5 // Pairs: (0,1), (0,3), (0,4), (2,3), (2,4)

// Test Case 2: All eastbound cars
const nums2 = [0, 0, 0];
console.log(passingCars(nums2)); // ➞ 0 // No westbound cars → no passing

// Test Case 3: All westbound cars
const nums3 = [1, 1, 1];
console.log(passingCars(nums3)); // ➞ 0// No eastbound cars → no passing

// Test Case 4: Large array causing overflow
const nums4 = Array(100000).fill(0).concat(Array(100000).fill(1));
console.log(passingCars(nums4)); // ➞ -1 // 100,000 east cars × 100,000 west cars = 10,000,000,000 → too many pairs