// Greedy  TC: O(n) SC: O(1)
function canCompleteCircuit(gas, cost) {
    const totalGas = gas.reduce((a, b) => a + b, 0);
    const totalCost = cost.reduce((a, b) => a + b, 0);

    if (totalGas < totalCost) return -1;

    let total = 0;
    let res = 0;

    for (let i = 0; i < gas.length; i++) {
        total += gas[i] - cost[i];

        if (total < 0) {
            total = 0;
            res = i + 1;
        }
    }

    return res;
}

function runTests() {
    const tests = [
        { gas: [1, 2, 3, 4, 5], cost: [3, 4, 5, 1, 2], expected: 3 },
        { gas: [2, 3, 4],        cost: [3, 4, 3],        expected: -1 },
        { gas: [5, 1, 2, 3, 4],  cost: [4, 4, 1, 5, 1],  expected: 4 },
        { gas: [3, 3, 4],        cost: [3, 4, 4],         expected: -1 },
        { gas: [1, 2],           cost: [2, 1],             expected: 1 },
    ];

    tests.forEach(({ gas, cost, expected }) => {
        const result = canCompleteCircuit(gas, cost);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] result=${result} expected=${expected}`);
    });
}

runTests();
