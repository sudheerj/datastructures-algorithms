// Two pointers  TC: O(n) SC: O(1)
function compress(chars) {
    let read = 0;
    let write = 0;

    while (read < chars.length) {
        const current = chars[read];
        let count = 0;

        while (read < chars.length && chars[read] === current) {
            read++;
            count++;
        }

        chars[write++] = current;

        if (count > 1) {
            for (const ch of String(count)) {
                chars[write++] = ch;
            }
        }
    }

    return write;
}

function runTests() {
    const tests = [
        { chars: ['a','a','b','b','c','c','c'],                         expectedLen: 6, expectedChars: ['a','2','b','2','c','3'] },
        { chars: ['a'],                                                  expectedLen: 1, expectedChars: ['a'] },
        { chars: ['a','b','b','b','b','b','b','b','b','b','b','b','b'], expectedLen: 4, expectedChars: ['a','b','1','2'] },
        { chars: ['a','a','a','a','a','a','a','a','a','a'],             expectedLen: 3, expectedChars: ['a','1','0'] },
        { chars: ['a','b','c'],                                         expectedLen: 3, expectedChars: ['a','b','c'] },
    ];

    tests.forEach(({ chars, expectedLen, expectedChars }) => {
        const result = compress(chars);
        const resultChars = chars.slice(0, result);
        const pass = result === expectedLen && JSON.stringify(resultChars) === JSON.stringify(expectedChars);
        console.log(`[${pass ? "PASS" : "FAIL"}] result=${result} chars=[${resultChars}] expected=${expectedLen} expectedChars=[${expectedChars}]`);
    });
}

runTests();
