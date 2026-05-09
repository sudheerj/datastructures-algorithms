/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
function slidingWindowMaximum(nums, k) {
    const n = nums.length;
    const output = [];
    const q = []; // monotonic deque storing indices
    let left = 0;

    for (let right = 0; right < n; right++) {
        // Remove elements smaller than current from the back
        while (q.length && nums[q[q.length - 1]] < nums[right]) {
            q.pop();
        }

        q.push(right);

        // Remove front if it's outside the window
        if (left > q[0]) {
            q.shift();
        }

        // Start recording once the first full window is reached
        if (right + 1 >= k) {
            output.push(nums[q[0]]);
            left++;
        }
    }

    return output;
}

console.log(slidingWindowMaximum([1, 3, -1, -3, 5, 3, 6, 7], 3));  // [3,3,5,5,6,7]
console.log(slidingWindowMaximum([1], 1));                          // [1]
console.log(slidingWindowMaximum([1, -1], 1));                      // [1,-1]
console.log(slidingWindowMaximum([9, 11], 2));                      // [11]
console.log(slidingWindowMaximum([4, -2], 2));                      // [4]
console.log(slidingWindowMaximum([1, 3, 1, 2, 0, 5], 3));          // [3,3,2,5]
