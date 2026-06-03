// Reaching Points (LC 780)
// Backward simulation  TC: O(log(max(tx, ty)))  SC: O(1)

/**
 * @param {number} sx
 * @param {number} sy
 * @param {number} tx
 * @param {number} ty
 * @return {boolean}
 */
function reachingPoints(sx, sy, tx, ty) {
    while (tx >= sx && ty >= sy) {
        if (tx === sx && ty === sy) return true;

        if (tx > ty) {
            if (ty === sy) return (tx - sx) % ty === 0;
            tx %= ty;
        } else {
            if (tx === sx) return (ty - sy) % tx === 0;
            ty %= tx;
        }
    }
    return false;
}

function runTests() {
    const tests = [
        { sx: 1, sy: 1, tx: 3,  ty: 5,  expected: true  },
        { sx: 1, sy: 1, tx: 2,  ty: 2,  expected: false },
        { sx: 3, sy: 5, tx: 3,  ty: 5,  expected: true  },
        { sx: 1, sy: 2, tx: 5,  ty: 4,  expected: true  },
        { sx: 2, sy: 3, tx: 8,  ty: 3,  expected: true  },
        { sx: 1, sy: 3, tx: 10, ty: 12, expected: false },
    ];

    for (const { sx, sy, tx, ty, expected } of tests) {
        const result = reachingPoints(sx, sy, tx, ty);
        const pass = result === expected;
        console.log(`[${pass ? "PASS" : "FAIL"}] sx=${sx} sy=${sy} tx=${tx} ty=${ty} result=${result} expected=${expected}`);
    }
}

runTests();
