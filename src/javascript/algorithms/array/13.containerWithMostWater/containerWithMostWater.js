function mostWater(heights) {
    let maxArea = 0;
    let left = 0;
    let right = heights.length - 1;

    while (left < right) {
        const height = Math.min(heights[left], heights[right]);
        const width = right - left;
        const area = height * width;
        maxArea = Math.max(maxArea, area);

        // Move the pointer pointing to the shorter line
        if (heights[left] < heights[right]) {
            left++;
        } else {
            right--;
        }
    }

    return maxArea;
}

// Test cases
let waterHeights1 = [3, 9, 4, 1, 5, 4, 7, 1, 7];
console.log(mostWater(waterHeights1)); // Output: 49

let waterHeights2 = [1, 1];
console.log(mostWater(waterHeights2)); // Output: 1
