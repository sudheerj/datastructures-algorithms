function minimumEffort(tasks) {
    tasks.sort((a, b) => (b[1] - b[0]) - (a[1] - a[0]));
    let energy = 0;
    for (const [cost, req] of tasks) {
        energy = Math.max(energy + cost, req);
    }
    return energy;
}

function runTests() {
    const tests = [
        { tasks: [[1,2],[2,4],[4,8]], expected: 8 },
        { tasks: [[1,3],[2,4],[10,11],[10,12],[8,9]], expected: 32 },
        { tasks: [[1,7],[2,8],[3,9],[4,10]], expected: 19 },
        { tasks: [[5,9],[2,8],[3,7],[1,5]], expected: 17 },
        { tasks: [[1,2],[2,2],[3,3]], expected: 6 },
    ];
    tests.forEach((test, i) => {
        const result = minimumEffort(test.tasks.map(t => t.slice()));
        console.log(`Test ${i+1}: Output=${result}, Expected=${test.expected} [${result===test.expected?'PASS':'FAIL'}]`);
    });
}

runTests();
