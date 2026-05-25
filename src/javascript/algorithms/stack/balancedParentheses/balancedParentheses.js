/**
 * Balanced Parentheses (Valid Parentheses - LeetCode 20)
 *
 * Given a string containing brackets, determine if it is valid.
 * Approach 1 handles {}()[], Approach 2 also handles <>.
 *
 * Approach 1: Stack              TC: O(n)  SC: O(n)
 * Approach 2: HashMap + Stack    TC: O(n)  SC: O(n)
 */

// Approach 1: Stack
function validParenthesis1(s) {
    if (s.length % 2 !== 0) return false;
    const stack = [];
    for (const ch of s) {
        if ('{(['.includes(ch)) {
            stack.push(ch);
        } else {
            if (!stack.length) return false;
            const top = stack[stack.length - 1];
            if (ch === '}' && top !== '{') return false;
            if (ch === ')' && top !== '(') return false;
            if (ch === ']' && top !== '[') return false;
            stack.pop();
        }
    }
    return stack.length === 0;
}

// Approach 2: HashMap + Stack (also handles <>)
function validParenthesis2(s) {
    if (s.length % 2 !== 0) return false;
    const map = {')': '(', '}': '{', ']': '[', '>': '<'};
    const stack = [];
    for (const ch of s) {
        if (map[ch] !== undefined) {
            if (!stack.length || stack.pop() !== map[ch]) return false;
        } else {
            stack.push(ch);
        }
    }
    return stack.length === 0;
}

const commonCases = [
    { s: "{([])}", expected: true,  label: "{([])}" },
    { s: "{(][)}", expected: false, label: "{(][)}" },
    { s: "()",     expected: true,  label: "()" },
    { s: "()[]{}", expected: true,  label: "()[]{}" },
    { s: "(]",     expected: false, label: "(]" },
    { s: "([)]",   expected: false, label: "([)]" },
    { s: "{[]}",   expected: true,  label: "{[]}" },
    { s: "(())",   expected: true,  label: "(())" },
    { s: "(((", expected: false, label: "(((" },
];
const hmExtras = [
    { s: "<>",   expected: true,  label: "<>" },
    { s: "<(>)", expected: false, label: "<(>)" },
];

console.log("=== Approach 1: Stack ===");
commonCases.forEach(({ s, expected, label }) => {
    const result = validParenthesis1(s);
    console.log(`  [${result === expected ? "PASS" : "FAIL"}] "${label}": ${result}  (expected ${expected})`);
});

console.log("=== Approach 2: HashMap ===");
[...commonCases, ...hmExtras].forEach(({ s, expected, label }) => {
    const result = validParenthesis2(s);
    console.log(`  [${result === expected ? "PASS" : "FAIL"}] "${label}": ${result}  (expected ${expected})`);
});
