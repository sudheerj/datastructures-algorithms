// 1. Reversal approach
function rotate(nums, n) {
    const length = nums.length;
    n %= length;

    reversal(nums, 0, length-1);
    reversal(nums, 0, n-1);
    reversal(nums, n, length-1);
}

function reversal(nums, start, end) {
    while(start < end) {
        [nums[start], nums[end]] = [nums[end], nums[start]];
        start++;
        end--;
    }
}

// 2. BrutForce using unshift() and pop() methods

function rotateBrutforce(nums, n) {
    for(let i=0; i< n; i++) {
        nums.unshift(nums.pop());
    }
}

let rotate1 = [1, 2, 3, 4, 5, 6, 7];
console.log("Before rotate:         ", rotate1.join(", "));
rotate(rotate1, 4);
console.log("After rotate:   ", rotate1.join(", "));

let rotate2 = [1, 2, 3, 4, 5, 6, 7];
console.log("Before rotate:         ", rotate2.join(", "));
rotateBrutforce(rotate2, 4);
console.log("After rotate:   ", rotate2.join(", "));