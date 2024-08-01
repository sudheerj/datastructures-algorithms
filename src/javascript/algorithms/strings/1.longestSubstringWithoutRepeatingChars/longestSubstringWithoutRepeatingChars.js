// Sliding window: TC: O(n), SC: O(n)
function longestSubstringLengthWithoutRepeatingChar(str) {

    let charSet = new Set();
    let left = right = maxLength = 0;

    while(right < str.length) {
        while(charSet.has(str[right])) {
            charSet.delete(str[left]);
            left++;
        }
        charSet.add(str[right]);
        right++;
        maxLength = Math.max(maxLength, charSet.size); 
    }
    return maxLength;
}

let string1 = "abcabcbbaa";
console.log(longestSubstringLengthWithoutRepeatingChar(string1));

let string2 = "aaaaaaa";
console.log(longestSubstringLengthWithoutRepeatingChar(string2));