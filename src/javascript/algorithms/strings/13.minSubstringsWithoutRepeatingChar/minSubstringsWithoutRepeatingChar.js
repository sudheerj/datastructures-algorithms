function minSubstringsWithoutRepeatingChar(str) {
    const seen = new Set();
    let countSubstrings = 0;

    for(const char of str) {
        if(seen.has(char)) {
            // Duplicate found, start new substring
            countSubstrings++;
            console.log(Array.from(seen));
            seen.clear();
        }
        seen.add(char);
    }

    return seen.size > 0 ? countSubstrings + 1 : countSubstrings;
}

// Test cases
console.log(minSubstringsWithoutRepeatingChar("abcabcbb")); // ➞ 4 ("abc", "abc", "b", "b")
console.log(minSubstringsWithoutRepeatingChar("bbbbb")); // ➞ 5 ("b", "b", "b", "b", "b")
console.log(minSubstringsWithoutRepeatingChar("pwwkew")); // ➞ 3 ("pw", "wke", "w")
console.log(minSubstringsWithoutRepeatingChar("")); // ➞ 0
console.log(minSubstringsWithoutRepeatingChar("a")); // ➞ 1
console.log(minSubstringsWithoutRepeatingChar("abacabadabacaba")); // ➞ 8 ("ab", "ac","ab", "ad", "ab", "ac", "ab", "a")

