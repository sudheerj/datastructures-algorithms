// The Skyline Problem (LeetCode 218)
function getSkyline(buildings) {
    // Sweep-line + multiset (simulated with sorted array)
    let events = [];
    for (const [l, r, h] of buildings) {
        events.push([l, -h]); // start
        events.push([r, h]);  // end
    }
    events.sort((a, b) => a[0] - b[0] || a[1] - b[1]);
    let heights = {0: 1};
    let result = [];
    let prevMax = 0;
    for (const [x, h] of events) {
        if (h < 0) {
            heights[-h] = (heights[-h] || 0) + 1;
        } else {
            heights[h]--;
            if (heights[h] === 0) delete heights[h];
        }
        let currMax = Math.max(...Object.keys(heights).map(Number));
        if (currMax !== prevMax) {
            result.push([x, currMax]);
            prevMax = currMax;
        }
    }
    return result;
}

function runTests() {
    const tests = [
        [[[1,2,1]], [[1,1],[2,0]]],
        [[[0,2,3],[2,5,3]], [[0,3],[5,0]]],
        [[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]], [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]],
        [[[1,3,4],[3,4,4],[2,6,2]], [[1,4],[4,2],[6,0]]],
    ];
    for (const [buildings, expected] of tests) {
        const result = getSkyline(buildings);
        const pass = JSON.stringify(result) === JSON.stringify(expected);
        const status = pass ? "PASS" : "FAIL";
        console.log(`[${status}] result=${JSON.stringify(result)} expected=${JSON.stringify(expected)}`);
    }
}

if (require.main === module) {
    runTests();
}
