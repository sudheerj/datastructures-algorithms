function candy(ratings) {
    const n = ratings.length;
    const candies = Array(n).fill(1);
    for (let i = 1; i < n; i++) {
        if (ratings[i] > ratings[i-1]) {
            candies[i] = candies[i-1] + 1;
        }
    }
    for (let i = n-2; i >= 0; i--) {
        if (ratings[i] > ratings[i+1]) {
            candies[i] = Math.max(candies[i], candies[i+1] + 1);
        }
    }
    return candies.reduce((a, b) => a + b, 0);
}

const testCases = [
    [1,0,2],
    [1,2,2],
    [1,3,2,2,1],
    [1,2,87,87,87,2,1],
    [1,3,4,5,2],
    [1,2,3,1,0],
    [1,6,10,8,7,3,2],
    [1,2,2,1,2,2,1],
    [1,2,3,4,5],
    [5,4,3,2,1]
];
const expected = [5,4,7,13,9,9,18,12,15,15];
testCases.forEach((input, i) => {
    const result = candy(input);
    const exp = expected[i];
    const status = result === exp ? "PASS" : "FAIL";
    console.log(`Test ${i+1} | Output: ${result} | Expected: ${exp} | ${status}`);
});
