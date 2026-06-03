function maxEnvelopes(envelopes) {
    envelopes.sort((a, b) => a[0] === b[0] ? b[1] - a[1] : a[0] - b[0]);
    const lis = [];
    for (const [_, h] of envelopes) {
        let left = 0, right = lis.length;
        while (left < right) {
            const mid = Math.floor((left + right) / 2);
            if (lis[mid] < h) left = mid + 1;
            else right = mid;
        }
        lis[left] = h;
    }
    return lis.length;
}

function runTests() {
    const testEnvelopes = [
        [[5,4],[6,4],[6,7],[2,3]],
        [[1,1],[1,1],[1,1]],
        [[4,5],[4,6],[6,7],[2,3],[1,1]],
        [[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]],
        [[1,3],[3,5],[6,7],[6,8],[8,4],[9,5]]
    ];
    const expected = [3, 1, 4, 5, 3];
    for (let i = 0; i < testEnvelopes.length; i++) {
        const result = maxEnvelopes(testEnvelopes[i].map(e => [...e]));
        const status = result === expected[i] ? "PASS" : "FAIL";
        console.log(`Test ${i+1} | Output: ${result} | Expected: ${expected[i]} | ${status}`);
    }
}

runTests();
