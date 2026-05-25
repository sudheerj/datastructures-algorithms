// Stack with (char, count) pairs  TC: O(n) SC: O(n)
function removeDuplicates(s, k) {
    const stack = []; // each entry: { ch, count }

    for (const ch of s) {
        if (stack.length > 0 && stack[stack.length - 1].ch === ch) {
            stack[stack.length - 1].count++;
            if (stack[stack.length - 1].count === k) {
                stack.pop();
            }
        } else {
            stack.push({ ch, count: 1 });
        }
    }

    return stack.map(({ ch, count }) => ch.repeat(count)).join("");
}

function runTests() {
    const tests = [
        { s: "abcd",                   k: 2, expected: "abcd" },
        { s: "deeedbbcccbdaa",         k: 3, expected: "aa" },
        { s: "pbbcggttciiippooaais",   k: 2, expected: "ps" },
        { s: "aabbaa",                 k: 2, expected: "" },
        { s: "abcddcba",               k: 2, expected: "" },
    ];

    tests.forEach(({ s, k, expected }) => {
        const result = removeDuplicates(s, k);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] result=${result} expected=${expected}`);
    });
}

runTests();
