//Expanding around center:- TC:O(n) SC:O(n)

function longestPalindromicSubstring1(str) {
    if(str.length <= 1) return str;

    let maxPalindromicSubstr = str.substring(0, 1);

    for (let i = 0; i < str.length; i++) {
        let maxOddPalindromicSubstr = expandAroundCenter(str, i, i);
        let maxEvenPalindromicSubstr =  expandAroundCenter(str, i, i+1);    

        if(maxOddPalindromicSubstr.length > maxPalindromicSubstr.length) {
            maxPalindromicSubstr = maxOddPalindromicSubstr;
        }
        if(maxEvenPalindromicSubstr.length > maxPalindromicSubstr.length) {
            maxPalindromicSubstr = maxEvenPalindromicSubstr;
        }
    }

    return maxPalindromicSubstr;
}

function expandAroundCenter(str, left, right) {
    while(left >=0 && right < str.length && str[left] === str[right]) {
        left--;
        right++;
    }

    return str.substring(left+1, right);
}

//Expanding around center using redundant code block:- TC:O(n) SC:O(n)
function longestPalindromicSubstring2(str) {
    let longestSubstr ="";
    let longestSubstrLen = 0;
    let left = 0, right = 0;

    for(let i=0; i< str.length; i++) {
        //Odd length
        left = i; right = i;
        while(left >=0 && right < str.length && str[left] === str[right]) {
            if(right-left+1 > longestSubstrLen) {
                longestSubstr = str.substring(left, right+1);
                longestSubstrLen = right-left+1;
            }
            left--;
            right++;
        }
        //Even length
        left = i; right = i+1;
        while(left >=0 && right < str.length && str[left] === str[right]) {
            if(right-left+1 > longestSubstrLen) {
                longestSubstr = str.substring(left, right+1);
                longestSubstrLen = right-left+1;
            }
            left--;
            right;
        }
    }
    return longestSubstr;
}

let str1 = "ababd";
let str2 = "dbbc";
console.log(longestPalindromicSubstring1(str1));
console.log(longestPalindromicSubstring1(str2));
console.log(longestPalindromicSubstring2(str1));
console.log(longestPalindromicSubstring2(str2));