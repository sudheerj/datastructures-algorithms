/**
 * Checks if two strings are anagrams using a frequency array (lowercase a-z only).
 * TC: O(n), SC: O(1)
 * @param {string} str1
 * @param {string} str2
 * @returns {boolean}
 */
function validAnagram1(str1, str2) {
    if(str1.length !== str2.length) return false;

    let charFrequencyArr = new Array(26).fill(0);

    for(let i=0; i< str1.length; i++) {
        let charCode1 = str1.charCodeAt(i);
        let charCode2 = str2.charCodeAt(i);
        charFrequencyArr[charCode1-97]++;
        charFrequencyArr[charCode2-97]--;
    }

    return charFrequencyArr.every((n) => n === 0);
}

/**
 * Checks if two strings are anagrams using a Map (works for any characters).
 * TC: O(n), SC: O(n)
 * @param {string} str1
 * @param {string} str2
 * @returns {boolean}
 */
function validAnagram2(str1, str2) {
    if(str1.length != str2.length) return false;

    let charMap = new Map();

    for(let ch of str1) {
        charMap.set(ch, (charMap.get(ch) || 0) + 1);
    }

    for(let ch of str2) {
        if(charMap.has(ch)) {
            charMap.set(ch, charMap.get(ch)-1);
            if(charMap.get(ch) === 0) charMap.delete(ch);
        } else {
            return false;
        }
    }
     
    return charMap.size === 0;
}

/**
 * Checks if two strings are anagrams by sorting and comparing.
 * TC: O(n log n), SC: O(n)
 * @param {string} str1
 * @param {string} str2
 * @returns {boolean}
 */
function validAnagram3(str1, str2) {
    if(str1.length !== str2.length) return false;

    return [...str1].sort().join('') === [...str2].sort().join('');
}



// Test cases
const testCases = [
    { str1: "anagram", str2: "nagaram", expected: true },
    { str1: "rat", str2: "cat", expected: false },
    { str1: "Listen", str2: "Silent", expected: true },
    { str1: "aabbcc", str2: "abcabc", expected: true },
    { str1: "aabbcc", str2: "aabbc", expected: false },
    { str1: "123", str2: "321", expected: true },
    { str1: "a!b@c", str2: "c!b@a", expected: true },
];

for (const { str1, str2, expected } of testCases) {
    console.log(
        `Input: "${str1}", "${str2}" | Array: ${validAnagram1(str1, str2)} | Map: ${validAnagram2(str1, str2)} | Sort: ${validAnagram3(str1, str2)} | Expected: ${expected}`
    );
}