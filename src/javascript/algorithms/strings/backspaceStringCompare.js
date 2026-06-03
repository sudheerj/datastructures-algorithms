function backspaceCompare(s, t) {
    function nextCharIndex(str, idx) {
        let skip = 0;
        while (idx >= 0) {
            if (str[idx] === '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                return idx;
            }
            idx--;
        }
        return -1;
    }
    let i = s.length - 1, j = t.length - 1;
    while (i >= 0 || j >= 0) {
        i = nextCharIndex(s, i);
        j = nextCharIndex(t, j);
        if (i < 0 || j < 0) return i === j;
        if (s[i] !== t[j]) return false;
        i--;
        j--;
    }
    return true;
}

// Test harness
const testCases = [
    ["ab#c", "ad#c"],
    ["ab##", "c#d#"],
    ["a#c", "b"],
    ["a##c", "#a#c"],
    ["xywrrmp", "xywrrmu#p"],
    ["", ""],
    ["a#", ""],
    ["abc#d", "abzz##d"],
    ["bxj##tw", "bxo#j##tw"],
    ["nzp#o#g", "b#nzp#o#g"],
];
const expected = [true, true, false, true, true, true, true, true, true, true];
testCases.forEach(([s, t], i) => {
    const result = backspaceCompare(s, t);
    const exp = expected[i];
    const status = result === exp ? "PASS" : "FAIL";
    console.log(`Test ${i+1} | Output: ${result} | Expected: ${exp} | ${status}`);
});
