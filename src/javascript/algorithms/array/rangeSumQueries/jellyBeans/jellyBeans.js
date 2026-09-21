function jellyBeans(n, operations) {
    const diff = new Array(n + 2).fill(0);

    for (const [left, right, beans] of operations) {
        diff[left] += beans;
        diff[right + 1] -= beans;
    }

    const result = new Array(n);
    let current = 0;
    for (let i = 1; i <= n; i++) {
        current += diff[i];
        result[i - 1] = current;
    }

    return result;
}

const n = 5;
const operations = [
    [1, 3, 10],
    [2, 5, 5],
    [3, 4, 2],
];

const result = jellyBeans(n, operations);
const expected = [10, 15, 17, 7, 5];
console.log(`Output: [${result}] | Expected: [${expected}] | ${JSON.stringify(result) === JSON.stringify(expected) ? "PASS" : "FAIL"}`);