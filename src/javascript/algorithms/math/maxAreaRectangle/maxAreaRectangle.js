// HashSet + diagonal pair enumeration — TC: O(n²)  SC: O(n)
function maxAreaRectangle(points) {
    const pointSet = new Set(points.map(([x, y]) => `${x}#${y}`));
    const n = points.length;
    let maxArea = 0;

    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            const [x1, y1] = points[i];
            const [x2, y2] = points[j];

            // skip same row or column (no rectangle possible)
            if (x1 === x2 || y1 === y2) continue;

            // check if the other two corners exist
            if (pointSet.has(`${x1}#${y2}`) && pointSet.has(`${x2}#${y1}`)) {
                const area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                maxArea = Math.max(maxArea, area);
            }
        }
    }

    return maxArea;
}

const points1 = [[1,1],[1,3],[3,1],[3,3],[2,2]];
const r1 = maxAreaRectangle(points1);
console.log(`Test 1 - corners at (1,1)(3,3): ${r1 === 4 ? '[PASS]' : '[FAIL]'} result=${r1} expected=4`);

const points2 = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]];
const r2 = maxAreaRectangle(points2);
console.log(`Test 2 - max rect is 3x2: ${r2 === 6 ? '[PASS]' : '[FAIL]'} result=${r2} expected=6`);

const points3 = [[0,0],[0,1],[1,0],[1,1]];
const r3 = maxAreaRectangle(points3);
console.log(`Test 3 - unit square: ${r3 === 1 ? '[PASS]' : '[FAIL]'} result=${r3} expected=1`);

const points4 = [[0,0],[0,2],[3,0],[3,2]];
const r4 = maxAreaRectangle(points4);
console.log(`Test 4 - 3x2 rectangle: ${r4 === 6 ? '[PASS]' : '[FAIL]'} result=${r4} expected=6`);

const points5 = [[1,1],[2,2],[3,1],[1,3]];
const r5 = maxAreaRectangle(points5);
console.log(`Test 5 - no valid rectangle: ${r5 === 0 ? '[PASS]' : '[FAIL]'} result=${r5} expected=0`);
