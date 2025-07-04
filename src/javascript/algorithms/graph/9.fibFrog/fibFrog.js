function fibFrog(leaves) {
    const riverLength = leaves.length;

    const fibonacciJumps = [1, 2];

    while(true) {
        let nextFib = fibonacciJumps[fibonacciJumps.length - 1] + fibonacciJumps[fibonacciJumps.length - 2];
        if(nextFib > riverLength + 1) break;
        fibonacciJumps.push(nextFib);
    }

    // Generate all Fibonacci numbers up to riverLength + 1
    const visited = Array(riverLength + 1).fill(false);

    const positionsToJump = [{position:-1, jumpCount: 0}];

    while(positionsToJump.length > 0) {
        const {position, jumpCount} = positionsToJump.shift();

        for(const jumpDistance of fibonacciJumps) {
            let nextPosition = position + jumpDistance;

            if(nextPosition === riverLength ) {
                return jumpCount + 1; // Reached goal
            }

            if(nextPosition >=0 && nextPosition < riverLength && leaves[nextPosition] === 1 && !visited[nextPosition]) {
                visited[nextPosition] = true;
                positionsToJump.push({
                    position: nextPosition,
                    jumpCount: jumpCount + 1,
                })
            }
        }
    }

    return -1; // No valid path
}


const testCases = [
    { input: [1, 0, 0, 0, 0], expected: -1 },
    { input: [0, 0, 0, 0, 0], expected: -1 },
    { input: [0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0], expected: 3 },
    { input: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0], expected: -1 },
    { input: [1, 1, 0, 1, 0, 0, 1], expected: 4 },
    { input: [0, 0, 0, 0, 0], expected: -1 },
];

// 🖨 Run and print results
testCases.forEach((test, index) => {
    const result = fibFrog(test.input);
    const pass = result === test.expected ? '✅' : '❌';
    console.log(`Test Case ${index + 1}: Expected ${test.expected}, Got ${result} ${pass}`);
});