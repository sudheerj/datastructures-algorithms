function weightedUniformStrings(str, queries) {
    const weights = new Set();
    let currWeight = 0;
    let prevChar = '';

    for(const ch of str) {
        const charWeight = ch.charCodeAt(0) -96;
        if(ch === prevChar) {
            currWeight += charWeight;
        } else {
            currWeight = charWeight;
            prevChar = ch;
        }
        weights.add(currWeight);
    }

    return queries.map((query) => weights.has(query) ? "Yes" : "No");
}

// Test cases
console.log(weightedUniformStrings("abccddde", [1, 3, 12, 5, 9, 10])); // Output: ["Yes", "Yes", "Yes", "Yes", "No", "No"]
console.log(weightedUniformStrings("aaabbbbcccddd", [9, 7, 8, 12, 5])); // Output: ["Yes", "No", "Yes", "Yes", "No"]
console.log(weightedUniformStrings("abcd", [1, 2, 3, 4, 5])); // Output: ["Yes", "Yes", "Yes", "Yes", "No"]
console.log(weightedUniformStrings("zzzyyy", [26, 52, 78, 80])); // Output: ["Yes", "Yes", "Yes", "No"]