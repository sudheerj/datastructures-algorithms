//1. GCD using Euclidean's algorithm TC: O(n+m)(i.e, O(n + m + log(min(n, m)))), SC: O(n+m)
function gcdOfStrings1(string1, string2){
    //Verify whether GCD strings exists or not
    if(!(string1+string2 === string2+string1)) {
        return false;
    }

    let gcdLength = gcd(string1.length, string2.length);
    return string1.substring(0, gcdLength);
}

function gcd(x, y) {
    if(y === 0) {
        return x;
    }
    return gcd(y, x%y);
}

// 2. BrutForce (Time complexity: O(min(m,n) . (m+n)), Space complexity: O(min(m,n)))
function gcdOfStrings2(string1, string2) {
    let l1 = string1.length;
    let l2 = string2.length;

    for(let i= Math.min(l1,l2); i >= 1; i--) {
        if(hasGcdString(string1, string2, i)) {
            return string1.substring(0, i);
        }
    }

    return "";
}

function hasGcdString(string1, string2, k) {
    let l1 = string1.length;
    let l2 = string2.length;

    if(l1%k > 0 || l2%k >0) {
        return false;
    }

    let f1= l1/k, f2 = l2/k;
    let base = string1.substring(0, k);
    return base.repeat(f1) === string1 && base.repeat(f2) === string2;
}


console.log(gcdOfStrings1("AB", "AB"));
console.log(gcdOfStrings1("ABCABCABC", "ABCABC"));
console.log(gcdOfStrings1("ABABAB", "AB"));

console.log(gcdOfStrings2("AB", "AB"));
console.log(gcdOfStrings2("ABCABCABC", "ABCABC"));
console.log(gcdOfStrings2("ABABAB", "AB"));