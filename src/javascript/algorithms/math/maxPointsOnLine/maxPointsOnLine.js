function getSlope(p1, p2) {
    const dx = p2[0] - p1[0];
    const dy = p2[1] - p1[1];
    if (dx === 0) return Infinity;
    const slope = dy / dx;
    return Object.is(slope, -0) ? 0 : slope;
}

function maxPointsOnLine(points) {
    let maxPts = 1;
    const n = points.length;
    for (let i = 0; i < n; i++) {
        const count = new Map();
        for (let j = i + 1; j < n; j++) {
            const slope = getSlope(points[i], points[j]);
            count.set(slope, (count.get(slope) || 0) + 1);
            maxPts = Math.max(maxPts, count.get(slope) + 1);
        }
    }
    return maxPts;
}

const points1 = [[1,1],[2,2],[3,3]];
const r1 = maxPointsOnLine(points1);
console.log(`Test 1 - 3 collinear diagonal: ${r1 === 3 ? '[PASS]' : '[FAIL]'} result=${r1} expected=3`);

const points2 = [[1,1],[2,2],[3,3],[4,5]];
const r2 = maxPointsOnLine(points2);
console.log(`Test 2 - 3 collinear one outlier: ${r2 === 3 ? '[PASS]' : '[FAIL]'} result=${r2} expected=3`);

const points3 = [[0,0],[1,0],[2,0],[3,0]];
const r3 = maxPointsOnLine(points3);
console.log(`Test 3 - 4 collinear horizontal: ${r3 === 4 ? '[PASS]' : '[FAIL]'} result=${r3} expected=4`);

const points4 = [[0,0],[2,1],[4,3]];
const r4 = maxPointsOnLine(points4);
console.log(`Test 4 - no 3 collinear fractional slopes: ${r4 === 2 ? '[PASS]' : '[FAIL]'} result=${r4} expected=2`);

const points5 = [[0,0]];
const r5 = maxPointsOnLine(points5);
console.log(`Test 5 - single point: ${r5 === 1 ? '[PASS]' : '[FAIL]'} result=${r5} expected=1`);
