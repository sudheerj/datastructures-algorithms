function getLargestOutlier(nums) {
    const freq = new Map();
    let sum = 0;
    for (const num of nums) {
        sum += num;
        freq.set(num, (freq.get(num) || 0) + 1);
    }
    let largest = -Infinity;
    for (const num of nums) {
        freq.set(num, freq.get(num) - 1);
        const rem = sum - num;
        if (rem % 2 === 0) {
            const target = rem / 2;
            if ((freq.get(target) || 0) > 0) {
                largest = Math.max(largest, num);
            }
        }
        freq.set(num, freq.get(num) + 1);
    }
    return largest !== -Infinity ? largest : -2147483648;
}

function main() {
    const testCases = [
        [[1, 2, 3, 4, 6], 6],
        [[1, 1, 1, 3, 5], 5],
        [[2, 2, 2, 2, 8], 8],
        [[1, 2, 3, 5, 9], 9],
        [[1, 2, 3, 4, 5], -2147483648],
        [[10, 20, 30, 40, 100], 100],
        [[5, 5, 10, 15, 25], 25],
        [[1, 1, 1, 1, 1], -2147483648]
    ];
    testCases.forEach(([arr, expected], i) => {
        const result = getLargestOutlier(arr);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`Test ${i+1} | Output: ${result} | Expected: ${expected} | ${status}`);
    });
}

if (require.main === module) {
    main();
}
