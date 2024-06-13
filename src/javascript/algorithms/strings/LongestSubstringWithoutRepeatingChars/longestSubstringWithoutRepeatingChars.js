// Sliding window: TC: O(n), SC: O(n)
function longestSubstringLengthWithoutRepeatingChar(string) {

    let set = new Set();
    let left = right = maxLength = 0;

    while(right < string.length) {
        while(set.has(string[right])) {
            set.delete(string[left]);
            left++;
        }
        set.add(string[right]);
        right++;
        maxLength = Math.max(maxLength, set.size); 
    }
    return maxLength;
}

let string1 = "abcabcbbaa";
console.log(longestSubstringLengthWithoutRepeatingChar(string1));

let string2 = "aaaaaaa";
console.log(longestSubstringLengthWithoutRepeatingChar(string2));