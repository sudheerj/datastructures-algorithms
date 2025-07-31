function stoneWall(heights) {
    const stack = [];
    let blocks = 0;

    for(const height of heights) {
        while(stack.length > 0 && stack[stack.length-1] > height) {
            stack.pop();
        }

        if(stack.length === 0 || stack[stack.length-1] < height) {
            stack.push(height);
            blocks++;
        }
    }

    return blocks;
}

const testCases = [
  {
    H: [8, 8, 5, 7, 9, 8, 7, 4, 8],
    expected: 7,
    description: "Typical skyline with ups and downs"
  },
  {
    H: [1, 1, 1, 1],
    expected: 1,
    description: "Flat skyline - only 1 block needed"
  },
  {
    H: [1, 2, 3, 4],
    expected: 4,
    description: "Increasing skyline - each needs new block"
  },
  {
    H: [4, 3, 2, 1],
    expected: 4,
    description: "Decreasing skyline - each level needs new block"
  },
  {
    H: [1, 3, 2, 3, 1],
    expected: 5,
    description: "Alternating heights - many blocks required"
  }
];


testCases.forEach(({ H, expected, description }, index) => {
    const result = stoneWall(H);
    const pass = result === expected ? "✅" : "❌";
    console.log(`${pass} Test ${index + 1}: ${description} | Expected: ${expected}, Got: ${result}`);
});
