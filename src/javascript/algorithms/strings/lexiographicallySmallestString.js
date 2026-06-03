function smallestString(s) {
    let arr = s.split("");
    let n = arr.length;
    let i = 0;
    while (i < n && arr[i] === 'a') i++;
    if (i === n) {
        arr[n - 1] = 'z';
        return arr.join("");
    }
    while (i < n && arr[i] !== 'a') {
        arr[i] = String.fromCharCode(arr[i].charCodeAt(0) - 1);
        i++;
    }
    return arr.join("");
}

// Test harness
const tests = [
    ["abcde", "aabcd", "aabcd"],
    ["aabc", "aabc", "aaab"],
    ["aaaa", "aaaa", "aaaz"],
    ["bca", "aca", "aba"],
    ["azaz", "azaz", "ayaz"],
    ["a", "a", "z"],
    ["b", "b", "a"],
    ["ab", "ab", "aa"],
    ["ba", "ba", "aa"],
];
tests.forEach(([input, _, expected], i) => {
    const result = smallestString(input);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`Test ${i + 1} | Output: ${result} | Expected: ${expected} | ${status}`);
});
