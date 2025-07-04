function numberSolitaire(board) {
    const length = board.length;
    const dp = Array(length).fill(-Infinity);
    dp[0] = board[0];

    for(let i = 1; i < length; i++){
        for( let dice = 1; dice <= 6; dice++){
            if(i-dice >=0) {
                dp[i] = Math.max(dp[i], dp[i - dice] + board[i]);
            }
        }
    }

    return dp[length-1];
}

// Test Cases
const boards = [
    { input: [1, -2, 0, 9, -1, -2], expected: 8 },
    { input: [0, 0, 0, 0, 0], expected: 0 },             // All zeroes
    { input: [-1, -1, -1, -1, -1, -1], expected: -2 },    // All negatives
];

boards.forEach(({ input, expected }, index) => {
    const result = numberSolitaire(input);
    const pass = result === expected ? '✅' : '❌';
    console.log(`Test ${index + 1}: Expected ${expected}, Got ${result} ${pass}`);
});