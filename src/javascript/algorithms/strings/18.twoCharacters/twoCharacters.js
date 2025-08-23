function twoCharacters(str) {
    const uniqueChars = [...new Set(str)];
    let maxLength = 0;

    for(let i = 0; i < uniqueChars.length; i++) {
        for(let j = i + 1; j < uniqueChars.length; j++) {
            const char1 = uniqueChars[i];
            const char2 = uniqueChars[j];
            const filtered = str.split('').filter(c => c === char1 || c === char2).join('');

            if(isValidAlternating(filtered)) {
                maxLength = Math.max(maxLength, filtered.length);
            }
        }
    }

    return maxLength;
}

function isValidAlternating(str) {
    for(let i = 1; i < str.length; i++) {
        if(str[i] === str[i - 1]) {
            return false;
        }
    }
    return str.length > 1;
}


// Test cases
console.log(twoCharacters("beabeefeab")); // Output: 5
console.log(twoCharacters("asdcbsdcagfsdbgdfanfghbsfdab")); // Output: 8
console.log(twoCharacters("aaaa")); // Output: 0
console.log(twoCharacters("ababab")); // Output: 6
console.log(twoCharacters("abcabc")); // Output: 4
