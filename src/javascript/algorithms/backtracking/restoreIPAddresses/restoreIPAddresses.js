function restoreIPAddresses(s) {
    const res = [];
    function backtrack(i, dots, currIp) {
        if (dots === 4 && i === s.length) {
            res.push(currIp.slice(0, -1));
            return;
        }
        if (dots > 4) return;
        for (let j = i; j < Math.min(i + 3, s.length); j++) {
            if (i !== j && s[i] === '0') continue;
            if (parseInt(s.slice(i, j + 1)) < 256) {
                backtrack(j + 1, dots + 1, currIp + s.slice(i, j + 1) + '.');
            }
        }
    }
    backtrack(0, 0, '');
    return res;
}

// Test cases
const testCases = [
    "25525511135", // ["255.255.11.135", "255.255.111.35"]
    "0000",        // ["0.0.0.0"]
    "101023",      // ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
    "1111",        // ["1.1.1.1"]
    "010010"       // ["0.10.0.10","0.100.1.0"]
];
testCases.forEach((s, i) => {
    console.log(`Test case ${i + 1}: Input: '${s}'`);
    console.log('Output:', restoreIPAddresses(s));
});
