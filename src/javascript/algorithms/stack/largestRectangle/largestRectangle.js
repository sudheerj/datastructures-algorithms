// Largest Rectangle in Histogram
// Monotonic increasing stack, TC: O(n), SC: O(n)

function largestRectangle(heights) {
  const stack = [];
  let maxArea = 0;
  for (let i = 0; i <= heights.length; i++) {
    const currHeight = i === heights.length ? 0 : heights[i];
    while (stack.length && currHeight < heights[stack[stack.length - 1]]) {
      const height = heights[stack.pop()];
      const width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1;
      maxArea = Math.max(maxArea, width * height);
    }
    stack.push(i);
  }
  return maxArea;
}

// Test cases
const testCases = [
  [[2,1,5,6,2,3], 10],
  [[2,4], 4],
  [[1,1,1,1], 4],
  [[6,2,5,4,5,1,6], 12],
  [[2,1,2], 3],
  [[], 0],
  [[1], 1],
  [[2,1,2,3,1], 4]
];
for (const [heights, expected] of testCases) {
  const result = largestRectangle(heights);
  const status = result === expected ? "✓" : `✗ (expected ${expected})`;
  console.log(`${JSON.stringify(heights)} => ${result} ${status}`);
}
