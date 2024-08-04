// Using array:- TC:O(n) SC:O(1)
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

// Using Map:- TC:O(n) SC: O(n)
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

// Sort and compare:- TC: O(n logn) SC: O(n)
function validAnagram3(str1, str2) {
    if(str1.length !== str2.length) return false;

    return reorderStr(str1) === reorderStr(str2);
}

const reorderStr = (str) => 
            str.split("")
            .sort((a, b) => a.localeCompare(b))
            .join("");


let a1="anagram", a2="nagaram";
console.log(validAnagram1(a1, a2));
console.log(validAnagram2(a1, a2));
console.log(validAnagram3(a1, a2));
let b1="cat", b2="rat";
console.log(validAnagram1(b1, b2));
console.log(validAnagram2(b1, b2));
console.log(validAnagram3(b1, b2));