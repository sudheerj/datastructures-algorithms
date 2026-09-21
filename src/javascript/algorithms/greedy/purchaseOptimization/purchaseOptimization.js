function maximizeToys(prices, budget) {
    prices.sort((a, b) => a - b);

    let count = 0;
    for (const price of prices) {
        if (price > budget) {
            break;
        }
        budget -= price;
        count++;
    }

    return count;
}

const testCases = [
    { prices: [1, 12, 5, 111, 200, 1000, 10], budget: 50, expected: 4 },
    { prices: [3, 5, 7], budget: 10, expected: 2 },
    { prices: [10, 20], budget: 10, expected: 1 },
    { prices: [5, 6], budget: 4, expected: 0 },
];

testCases.forEach(({ prices, budget, expected }, index) => {
    const result = maximizeToys(prices, budget);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`Test ${index + 1} | Output: ${result} | Expected: ${expected} | ${status}`);
});