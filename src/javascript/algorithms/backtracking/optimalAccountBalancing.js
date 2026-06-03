function minTransfers(transactions) {
    const balance = {};
    for (const [from_, to, amt] of transactions) {
        balance[from_] = (balance[from_] || 0) - amt;
        balance[to] = (balance[to] || 0) + amt;
    }
    const debt = Object.values(balance).filter(x => x !== 0);
    function dfs(debt, start) {
        while (start < debt.length && debt[start] === 0) start++;
        if (start === debt.length) return 0;
        let minTx = Infinity;
        for (let i = start + 1; i < debt.length; i++) {
            if (debt[i] * debt[start] < 0) {
                debt[i] += debt[start];
                minTx = Math.min(minTx, 1 + dfs(debt, start + 1));
                debt[i] -= debt[start];
            }
        }
        return minTx;
    }
    return dfs(debt, 0);
}

if (require.main === module) {
    const tests = [
        [[[0,1,10],[2,0,5]], 2],
        [[[0,1,10],[1,0,10]], 0],
        [[[0,1,10],[1,2,5],[2,0,5]], 1],
        [[[0,1,10],[1,2,5],[2,3,5],[3,0,5]], 2],
        [[[0,1,5],[0,2,10],[1,2,5]], 2],
        [[[0,1,1],[1,2,1],[2,0,1]], 1],
    ];
    tests.forEach(([transactions, expected], idx) => {
        const result = minTransfers(transactions.map(x => x.slice()));
        console.log(`Test ${idx+1}: Output=${result}, Expected=${expected} [${result===expected?'PASS':'FAIL'}]`);
    });
}
