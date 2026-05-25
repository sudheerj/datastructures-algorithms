// Normalize rows with hashing — O(m*n) time, O(m*n) space
function maxEqualRowsAfterFlips(matrix) {
    const count = new Map();
    for (const row of matrix) {
        // normalize: if row starts with 1, flip all bits
        const key = row.map(b => row[0] === 1 ? 1 - b : b).join('');
        count.set(key, (count.get(key) || 0) + 1);
    }
    return Math.max(...count.values());
}

const r1 = maxEqualRowsAfterFlips([[0,1],[1,1]]);
console.log(`Test 1: ${r1 === 1 ? '[PASS]' : '[FAIL]'} result=${r1} expected=1`);

const r2 = maxEqualRowsAfterFlips([[0,1],[1,0]]);
console.log(`Test 2: ${r2 === 2 ? '[PASS]' : '[FAIL]'} result=${r2} expected=2`);

const r3 = maxEqualRowsAfterFlips([[0,0,0],[0,0,1],[1,1,0]]);
console.log(`Test 3: ${r3 === 2 ? '[PASS]' : '[FAIL]'} result=${r3} expected=2`);

const r4 = maxEqualRowsAfterFlips([[0,1,0,0],[0,0,1,0],[1,0,1,1]]);
console.log(`Test 4: ${r4 === 2 ? '[PASS]' : '[FAIL]'} result=${r4} expected=2`);

const r5 = maxEqualRowsAfterFlips([[0,0,1,1],[1,1,0,0],[0,0,1,0]]);
console.log(`Test 5: ${r5 === 2 ? '[PASS]' : '[FAIL]'} result=${r5} expected=2`);
