function sqrt1(num) {
    if (num < 2) return num;
    let left = 1, right = Math.floor(num / 2);
    let result = 0;
    while (left <= right) {
        let mid = Math.floor(left + (right - left) / 2);
        if (mid <= Math.floor(num / mid)) {
            result = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return result;
}

function sqrt2(num) {
    if (num < 2) return num;
    let result = 0;
    for (let i = 1; i <= Math.floor(num / 2); i++) {
        if (i * i > num) return result;
        result = i;
    }
    return result;
}

if (require.main === module) {
    const testCases = [0, 1, 4, 8, 9, 15, 16, 25, 26, 100, 101];
    console.log("Testing sqrt1:");
    for (const n of testCases) {
        console.log(`sqrt1(${n}) = ${sqrt1(n)}`);
    }
    console.log("\nTesting sqrt2:");
    for (const n of testCases) {
        console.log(`sqrt2(${n}) = ${sqrt2(n)}`);
    }
}
