// Sort and compare:- TC: O(n logn) SC: O(n)
function validAnagram1(str1, str2) {
    if(str1.length !== str2.length) return false;

    return reorderStr(str1) === reorderStr(str2);
}

const reorderStr = (str) => 
            str.split("")
            .sort((a, b) => a.localeCompare(b))
            .join("");


// Using array:- TC:O(n) SC:O(1)
function validAnagram2(str1, str2) {
    if(str1.length !== str2.length) return false;

    let chars = new Array(26).fill(0);

    for(let i=0; i< str1.length; i++) {
        let ch1 = str1.charCodeAt(i);
        let ch2 = str2.charCodeAt(i);
        chars[ch1-97]++;
        chars[ch2-97]--;
    }

    return chars.every((n) => n === 0);
}

// Using Map:- TC:O(n) SC: O(n)
function validAnagram3(str1, str2) {
    if(str1.length != str2.length) return false;

    let map = new Map();

    for(let ch of str1) {
        map.set(ch, (map.get(ch) || 0) + 1);
    }

    for(let ch of str2) {
        if(map.has(ch)) {
            map.set(ch, map.get(ch)-1);
            if(map.get(ch) === 0) map.delete(ch);
        } else {
            return false;
        }
    }
     
    if(map.size === 0) return true;
}


let a1="anagram", a2="nagaram";
console.log(validAnagram1(a1, a2));
console.log(validAnagram2(a1, a2));
console.log(validAnagram3(a1, a2));
let b1="cat", b2="rat";
console.log(validAnagram1(b1, b2));
console.log(validAnagram2(b1, b2));
console.log(validAnagram3(b1, b2));