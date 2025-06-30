// 1. Rotate Array in right direction Using Reversal Algorithm (Efficient O(n) time, O(1) space)
function rotate(nums, n) {
    const length = nums.length;
    if (length === 0 || n % length === 0) return nums; // No rotation needed

    n = n % length; // Handle n > length

    // Reverse entire array
    reverse(nums, 0, length - 1);
    // Reverse first part
    reverse(nums, 0, n - 1);
    // Reverse second part
    reverse(nums, n, length - 1);

    return nums;
}

// Helper function to reverse elements between two indices
function reverse(arr, start, end) {
    while (start < end) {
        [arr[start], arr[end]] = [arr[end], arr[start]];
        start++;
        end--;
    }
}

// 2. Rotate Array Using Brute Force with pop() and unshift() (Inefficient: O(n^2) time)
function rotateBruteForce(nums, n) {
    const length = nums.length;
    if (length === 0) return;

    n = n % length;
    for (let i = 0; i < n; i++) {
        nums.unshift(nums.pop());
    }
}

// 3. Rotate Array in left direction Using Reversal Algorithm (Efficient O(n) time, O(1) space)
function rotateLeft(nums, n) {
    const length = nums.length;
    if (length === 0 || n % length === 0) return nums; // No rotation needed

    n = n % length; // Handle n > length

    // Reverse first part
    reverse(nums, 0, n - 1);
    // Reverse second part
    reverse(nums, n, length - 1);
    // Reverse entire array
    reverse(nums, 0, length - 1);

    return nums;
}

// 4. Rotate Array left Using Brute Force with shift() and push() (Inefficient: O(n^2) time)
function rotateBruteForceLeft(nums, n) {
    const length = nums.length;
    if (length === 0) return;

    n = n % length;
    for (let i = 0; i < n; i++) {
        nums.push(nums.shift());
    }
}

// ----------------------------
// Test Cases
// ----------------------------
let rotate1 = [1, 2, 3, 4, 5, 6, 7];
console.log("Before rotate (reversal):", [...rotate1]);
rotate(rotate1, 4);
console.log("After rotate (reversal):", rotate1);
rotateLeft(rotate1, 4);

let rotate2 = [-10, 4, 5, -1];
console.log("Before rotate (brute force):", [...rotate2]);
rotateBruteForce(rotate2, 2);
console.log("After rotate (brute force):", rotate2);
rotateBruteForceLeft(rotate2, 2);

// Edge case
let rotate3 = [1];
console.log("Before rotate (single element):", [...rotate3]);
rotate(rotate3, 10);
console.log("After rotate (single element):", rotate3);
rotateLeft(rotate3, 10);
