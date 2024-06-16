// Sliding window: TC: O(n), SC: O(n)
function longestSubstringLengthWithoutRepeatingChar(string) {

    let charSet = new Set();
    let left = right = maxLength = 0;

    while(right < string.length) {
        while(charSet.has(string[right])) {
            charSet.delete(string[left]);
            left++;
        }
        charSet.add(string[right]);
        right++;
        maxLength = Math.max(maxLength, charSet.size); 
    }
    return maxLength;
}

let string1 = "abcabcbbaa";
console.log(longestSubstringLengthWithoutRepeatingChar(string1));

let string2 = "aaaaaaa";
console.log(longestSubstringLengthWithoutRepeatingChar(string2));