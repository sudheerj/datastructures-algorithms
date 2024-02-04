// 1. BrutForce (Time complexity: O(min(m,n) . (m+n)), Space complexity: O(min(m,n)))
function gcdOfStrings(string1, string2) {
    let l1 = string1.length;
    let l2 = string2.length;

    for(let i= Math.min(l1,l2); i >= 1; i--) {
        if(isValidGcdString(string1, string2, i)) {
            return string1.substr(0, i);
        }
    }
}

function isValidGcdString(string1, string2, k) {
    let l1 = string1.length;
    let l2 = string2.length;

    if(l1%k > 0 || l2%k >0) {
        return false;
    }
    let base = string1.substr(0, k);
    return string1.replaceAll(base, "").length === 0 && string2.replaceAll(base, "").length === 0;
}

console.log(gcdOfStrings("AB", "AB"));
console.log(gcdOfStrings("ABCABCABC", "ABCABC"));
console.log(gcdOfStrings("ABABAB", "ABAB"));

//2. GCD using Euclidean's algorithm
function gcdOfStrings1(string1, string2){
    //Verify whether GCD strings exists or not
    if(!(string1+string2 === string2+string1)) {
        return false;
    }

    let gcdLength = gcd(string1.length, string2.length);
    return string1.substr(0, gcdLength);
}

function gcd(x, y) {
    if(y === 0) {
        return x;
    }
    return gcd(y, x%y);
}

console.log(gcdOfStrings1("AB", "AB"));
console.log(gcdOfStrings1("ABCABCABC", "ABCABC"));
console.log(gcdOfStrings1("ABABAB", "ABAB"));