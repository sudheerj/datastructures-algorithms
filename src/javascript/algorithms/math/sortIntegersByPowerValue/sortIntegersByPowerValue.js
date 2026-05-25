function getKth(low, high, k) {
    const memo = new Map([[1, 0]]);

    function getPower(x) {
        if (memo.has(x)) return memo.get(x);
        const steps = x % 2 === 0 ? 1 + getPower(x / 2) : 1 + getPower(3 * x + 1);
        memo.set(x, steps);
        return steps;
    }

    const pairs = [];
    for (let i = low; i <= high; i++) {
        pairs.push([i, getPower(i)]);
    }
    pairs.sort((a, b) => a[1] !== b[1] ? a[1] - b[1] : a[0] - b[0]);
    return pairs[k - 1][0];
}

const r1 = getKth(12, 15, 2);
console.log(`Test 1 - lo=12 hi=15 k=2: ${r1 === 13 ? '[PASS]' : '[FAIL]'} result=${r1} expected=13`);

const r2 = getKth(7, 11, 4);
console.log(`Test 2 - lo=7 hi=11 k=4: ${r2 === 7 ? '[PASS]' : '[FAIL]'} result=${r2} expected=7`);

const r3 = getKth(1, 5, 3);
console.log(`Test 3 - lo=1 hi=5 k=3: ${r3 === 4 ? '[PASS]' : '[FAIL]'} result=${r3} expected=4`);

const r4 = getKth(3, 5, 2);
console.log(`Test 4 - lo=3 hi=5 k=2: ${r4 === 5 ? '[PASS]' : '[FAIL]'} result=${r4} expected=5`);

const r5 = getKth(1, 3, 1);
console.log(`Test 5 - lo=1 hi=3 k=1: ${r5 === 1 ? '[PASS]' : '[FAIL]'} result=${r5} expected=1`);
