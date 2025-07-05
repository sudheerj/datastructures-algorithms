function minSubstringsWithoutRepeatingChar(str) {
    const seen = new Set();
    let countSubstrings = 0;

    for(const char of str) {
        if(seen.has(char)) {
            // Duplicate found, start new substring
            countSubstrings++;
            seen.clear();
        }
        seen.add(char);
    }

    return seen.size > 0 ? countSubstrings + 1 : countSubstrings;
}

// Test cases
console.log(minSubstringsWithoutRepeatingChar("abcabcbb")); // ➞ 4 ("abc", "a", "b", "cbb")
console.log(minSubstringsWithoutRepeatingChar("bbbbb")); // ➞ 5 ("b", "b", "b", "b", "b")
console.log(minSubstringsWithoutRepeatingChar("pwwkew")); // ➞ 3 ("pw", "wk", "ew")
console.log(minSubstringsWithoutRepeatingChar("")); // ➞ 0
console.log(minSubstringsWithoutRepeatingChar("a")); // ➞ 1
console.log(minSubstringsWithoutRepeatingChar("abacabadabacaba")); // ➞ 8

