//Expand around center:- TC:O(n*2) SC:O(1)

function countPalindromicStrings(str) {

    if(str.length < 2) return str.length;

    let count = 0;
    for(let i=0; i< str.length; i++) {
        count += countPalindromes(str, i, i);
        count += countPalindromes(str, i, i+1);
    }
    return count;
}

function countPalindromes(str, left, right) {
    let count = 0;
    while(left >=0 && right < str.length && str[left] === str[right]) {
        count++;
        left--;
        right++;
    }
    return count;
}

let str = "baaab";
console.log(countPalindromicStrings(str));

let str1 = "abc";
console.log(countPalindromicStrings(str1));

let str2 = "aaa";
console.log(countPalindromicStrings(str2));