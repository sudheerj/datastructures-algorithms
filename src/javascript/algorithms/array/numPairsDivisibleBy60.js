function numPairsDivisibleBy60(time) {
    const count = Array(60).fill(0);
    let pairs = 0;
    for (let t of time) {
        let rem = t % 60;
        let comp = (60 - rem) % 60;
        pairs += count[comp];
        count[rem]++;
    }
    return pairs;
}

const testCases = [
    [30, 20, 150, 100, 40],    // 3 pairs
    [60, 60, 60],              // 3 pairs
    [10, 50, 90, 30],          // 2 pairs
    [1, 2, 3, 4, 5, 6],        // 0 pairs
    [60, 120, 180],            // 3 pairs
    [20, 40, 60, 80, 100, 120] // 7 pairs
];
const expected = [3, 3, 2, 0, 3, 7];
testCases.forEach((tc, i) => {
    const result = numPairsDivisibleBy60(tc);
    const exp = expected[i];
    const status = result === exp ? "PASS" : "FAIL";
    console.log(`Test ${i+1} | Output: ${result} | Expected: ${exp} | ${status}`);
});
