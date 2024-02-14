// Sliding window: TC: O(n), SC: O(n)
function longestSubstringLengthWithoutRepeatingChar(string) {
    let set = new Set();
    let left = max = 0;

    for(let right = 0; right < string.length; right++) {
        while(set.has(string[right])) {
            set.delete(string[left]);
            left++;
        }
        set.add(string[right]);
        max = Math.max(max, set.size);
    }
    return max;
}

let string1 = "abcabcbbaa";
console.log(longestSubstringLengthWithoutRepeatingChar(string1));
let string2 = "aaaaaaa";
console.log(longestSubstringLengthWithoutRepeatingChar(string2));