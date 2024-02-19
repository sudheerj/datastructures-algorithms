//Expanding around center:- TC:O(n) SC:O(n)

function longestPalindromicSubstring(str) {
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

let str = "dbabad";
console.log(longestPalindromicSubstring(str));