// Two pointers  TC: O(n) SC: O(n)
function addSpaces(s, spaces) {
    const result = [];
    let j = 0;
    for (let i = 0; i < s.length; i++) {
        if (j < spaces.length && i === spaces[j]) {
            result.push(' ');
            j++;
        }
        result.push(s[i]);
    }
    return result.join('');
}

// Brute force  TC: O(n*k) SC: O(n)
function addSpacesBrute(s, spaces) {
    let result = s;
    let shift = 0;
    for (const space of spaces) {
        const index = space + shift;
        result = result.slice(0, index) + ' ' + result.slice(index);
        shift++;
    }
    return result;
}

function runTests() {
    const tests = [
        { s: "LeetcodeHelpsMeLearn", spaces: [8, 13, 15], expected: "Leetcode Helps Me Learn" },
        { s: "icodeinpython",        spaces: [1, 6, 8],   expected: "i code in python" },
        { s: "spacing",              spaces: [],           expected: "spacing" },
        { s: "ab",                   spaces: [1],          expected: "a b" },
        { s: "hello",                spaces: [1, 2, 3, 4], expected: "h e l l o" },
    ];

    tests.forEach(({ s, spaces, expected }) => {
        const r1 = addSpaces(s, spaces);
        const r2 = addSpacesBrute(s, spaces);
        const s1 = r1 === expected ? "PASS" : "FAIL";
        const s2 = r2 === expected ? "PASS" : "FAIL";
        console.log(`[${s1}] twoPointers result=${r1} expected=${expected}`);
        console.log(`[${s2}] bruteForce  result=${r2} expected=${expected}`);
    });
}

runTests();
