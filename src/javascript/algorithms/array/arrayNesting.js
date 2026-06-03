function arrayNesting1(nums) {
    let maxLength = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === -1) continue;
        let count = 0;
        let curr = i;
        while (nums[curr] !== -1) {
            let next = nums[curr];
            nums[curr] = -1;
            curr = next;
            count++;
        }
        maxLength = Math.max(maxLength, count);
    }
    return maxLength;
}

function arrayNesting2(nums) {
    let maxLength = 0;
    let visited = new Array(nums.length).fill(false);
    for (let i = 0; i < nums.length; i++) {
        if (visited[i]) continue;
        let count = 0;
        let curr = i;
        while (!visited[curr]) {
            let next = nums[curr];
            visited[curr] = true;
            curr = next;
            count++;
        }
        maxLength = Math.max(maxLength, count);
    }
    return maxLength;
}

function deepCopy(arr) {
    return arr.slice();
}

function runTests() {
    const tests = [
        [5,4,0,3,1,6,2],
        [0,1,2],
        [1,0,3,4,2],
        [2,0,1],
        [1,2,3,4,0],
        [0],
        [1,2,0],
    ];
    const expected = [4,1,3,3,5,1,3];
    console.log("Testing arrayNesting1 (in-place):");
    for (let i = 0; i < tests.length; i++) {
        const result = arrayNesting1(deepCopy(tests[i]));
        console.log(`Test ${i+1}: Output=${result}, Expected=${expected[i]} [${result === expected[i] ? 'PASS' : 'FAIL'}]`);
    }
    console.log("\nTesting arrayNesting2 (visited array):");
    for (let i = 0; i < tests.length; i++) {
        const result = arrayNesting2(deepCopy(tests[i]));
        console.log(`Test ${i+1}: Output=${result}, Expected=${expected[i]} [${result === expected[i] ? 'PASS' : 'FAIL'}]`);
    }
}

runTests();
