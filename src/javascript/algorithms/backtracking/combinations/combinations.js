function combine(n, k) {
    const result = [];
    function backtrack(start, comb) {
        if (comb.length === k) {
            result.push([...comb]);
            return;
        }
        for (let i = start; i <= n; i++) {
            comb.push(i);
            backtrack(i + 1, comb);
            comb.pop();
        }
    }
    backtrack(1, []);
    return result;
}

// Test cases
const testCases = [
    [4, 2],  // [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
    [1, 1],  // [[1]]
    [3, 1],  // [[1],[2],[3]]
    [3, 3],  // [[1,2,3]]
    [5, 3]   // 10 combinations
];
testCases.forEach(([n, k], i) => {
    console.log(`Test case ${i + 1}: n=${n}, k=${k}`);
    const res = combine(n, k);
    console.log('Output:', res);
    console.log('Total combinations:', res.length);
});
