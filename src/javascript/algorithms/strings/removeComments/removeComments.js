// Line-by-line scan with block flag  TC: O(n * L)  SC: O(n * L)

/**
 * @param {string[]} source
 * @returns {string[]}
 */
function removeComments(source) {
    const result = [];
    let sb = [];
    let isBlock = false;

    for (const line of source) {
        let i = 0;
        if (!isBlock) sb = [];

        while (i < line.length) {
            if (!isBlock) {
                if (i + 1 < line.length && line[i] === '/' && line[i + 1] === '/') {
                    break; // rest of line is a line comment
                } else if (i + 1 < line.length && line[i] === '/' && line[i + 1] === '*') {
                    isBlock = true;
                    i += 2;
                } else {
                    sb.push(line[i]);
                    i++;
                }
            } else {
                if (i + 1 < line.length && line[i] === '*' && line[i + 1] === '/') {
                    isBlock = false;
                    i += 2;
                } else {
                    i++; // skip characters inside block comment
                }
            }
        }

        if (!isBlock && sb.length > 0) {
            result.push(sb.join(''));
        }
    }

    return result;
}

function runTests() {
    const tests = [
        {
            source:   ["int x = 1; // this is a comment", "int y = 2;"],
            expected: ["int x = 1; ", "int y = 2;"],
        },
        {
            source:   ["/* Test program */", "int main()", "{",
                       "  // variable declaration", "int a, b, c;",
                       "/* This is a test", "   multiline  ", "   comment for",
                       "   testing */", "int d = b + c;", "}"],
            expected: ["int main()", "{", "int a, b, c;", "int d = b + c;", "}"],
        },
        {
            source:   ["a/*comment*/b", "c"],
            expected: ["ab", "c"],
        },
        {
            source:   ["// full line comment", "code line"],
            expected: ["code line"],
        },
        {
            source:   ["int a = 1;", "int b = 2;"],
            expected: ["int a = 1;", "int b = 2;"],
        },
        {
            source:   ["before/*skip*/after"],
            expected: ["beforeafter"],
        },
    ];

    tests.forEach(({ source, expected }) => {
        const result = removeComments(source);
        const status = JSON.stringify(result) === JSON.stringify(expected) ? "PASS" : "FAIL";
        console.log(`[${status}] result=${JSON.stringify(result)} expected=${JSON.stringify(expected)}`);
    });
}

runTests();
