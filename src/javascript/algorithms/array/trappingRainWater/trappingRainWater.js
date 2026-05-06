// Trapping Rain Water
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

function trappingRainWater(heights) {
    if (heights.length === 0) return 0;
    let left = 0, right = heights.length - 1;
    let leftMax = heights[0];
    let rightMax = heights[right];
    let res = 0;
    while (left < right) {
        if (leftMax <= rightMax) {
            left++;
            leftMax = Math.max(leftMax, heights[left]);
            res += leftMax - heights[left];
        } else {
            right--;
            rightMax = Math.max(rightMax, heights[right]);
            res += rightMax - heights[right];
        }
    }
    return res;
}

function trappingRainWater2(heights) {
    const n = heights.length;
    if (n === 0) return 0;
    const leftMax = new Array(n).fill(0);
    const rightMax = new Array(n).fill(0);
    for (let i = 1; i < n; i++) {
        leftMax[i] = Math.max(leftMax[i - 1], heights[i - 1]);
    }
    for (let j = n - 2; j >= 0; j--) {
        rightMax[j] = Math.max(rightMax[j + 1], heights[j + 1]);
    }
    let water = 0;
    for (let i = 0; i < n; i++) {
        water += Math.max(0, Math.min(leftMax[i], rightMax[i]) - heights[i]);
    }
    return water;
}

// Test 1: General case
console.log(trappingRainWater([0,1,0,2,1,0,1,3,2,1,2,1])); // 6
console.log(trappingRainWater2([0,1,0,2,1,0,1,3,2,1,2,1])); // 6

// Test 2: V-shaped
console.log(trappingRainWater([4,2,0,3,2,5])); // 9
console.log(trappingRainWater2([4,2,0,3,2,5])); // 9

// Test 3: Flat - no water
console.log(trappingRainWater([1,1])); // 0
console.log(trappingRainWater2([1,1])); // 0

// Test 4: Empty array
console.log(trappingRainWater([])); // 0
console.log(trappingRainWater2([])); // 0

// Test 5: Deep valley
console.log(trappingRainWater([3,0,0,2,0,4])); // 10
console.log(trappingRainWater2([3,0,0,2,0,4])); // 10
