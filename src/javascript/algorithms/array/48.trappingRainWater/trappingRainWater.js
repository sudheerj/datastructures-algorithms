// TC: O(n) SC: O(1)
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

// Test cases
const testCases = [
    { heights: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1], expected: 6 },
    { heights: [4, 2, 0, 3, 2, 5], expected: 9 },
    { heights: [1, 1], expected: 0 },
    { heights: [], expected: 0 },
    { heights: [3, 0, 0, 2, 0, 4], expected: 10 },
];

testCases.forEach((test, i) => {
    const result = trappingRainWater(test.heights);
    console.log(`Test ${i + 1}: ${result} (expected: ${test.expected})`);
});
