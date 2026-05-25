function combinationSum(candidates, target) {
    const result = [];

    function dfs(i, current, remaining) {
        if (remaining === 0) {
            result.push([...current]);
            return;
        }
        if (remaining < 0 || i === candidates.length) return;

        // include candidates[i]
        current.push(candidates[i]);
        dfs(i, current, remaining - candidates[i]);
        current.pop();
        // exclude candidates[i]
        dfs(i + 1, current, remaining);
    }

    dfs(0, [], target);
    return result;
}

function normalize(result) {
    return new Set(result.map(combo => [...combo].sort((a, b) => a - b).join(',')));
}

function setsEqual(a, b) {
    if (a.size !== b.size) return false;
    for (const v of a) if (!b.has(v)) return false;
    return true;
}

function runTests() {
    const tests = [
        { candidates: [2,3,6,7], target: 7, expected: [[2,2,3],[7]] },
        { candidates: [2,3],     target: 6, expected: [[2,2,2],[3,3]] },
        { candidates: [2],       target: 1, expected: [] },
        { candidates: [1],       target: 1, expected: [[1]] },
        { candidates: [1,2],     target: 4, expected: [[1,1,1,1],[1,1,2],[2,2]] },
    ];

    tests.forEach(({ candidates, target, expected }, i) => {
        const result = combinationSum(candidates, target);
        const resultSet = normalize(result);
        const expectedSet = normalize(expected);
        const status = setsEqual(resultSet, expectedSet) ? 'PASS' : 'FAIL';
        console.log(`${status} test ${i + 1}: result=${JSON.stringify([...resultSet])} expected=${JSON.stringify([...expectedSet])}`);
    });
}

runTests();
