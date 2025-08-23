function isPangram(str) {
    const alphabetSet = new Set();

    for(const ch of str.toLowerCase()) {
        if(ch >= 'a' && ch <= 'z') {
            alphabetSet.add(ch);
        }
    }

    return alphabetSet.size === 26 ? "pangram" : "not pangram";
}

// Test cases
console.log(isPangram("The quick brown fox jumps over the lazy dog")); // Output: "pangram"
console.log(isPangram("Hello World")); // Output: "not pangram"
console.log(isPangram("A quick movement of the enemy will jeopardize five gunboats")); // Output: "not pangram"
console.log(isPangram("Sphinx of black quartz, judge my vow")); // Output: "pangram"
console.log(isPangram("This sentence is not a pangram")); // Output: "not pangram"