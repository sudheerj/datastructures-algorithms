//Sliding window: TC:O(n) SC: O(1)
function longestCharReplacement(str, target) {
    let charFrequency = new Array(26).fill(0);;
    let maxLength = 0, maxFrequency = 0;
    let left = 0;

    for(let right = 0; right < str.length; right++) {
        maxFrequency = Math.max(maxFrequency, ++charFrequency[str.charCodeAt(right) - "A".charCodeAt(0)]);
        while((right-left+1-maxFrequency) > target) {
            charFrequency[str.charCodeAt(left) - "A".charCodeAt(0)]--;
            left++;
        }
        maxLength = Math.max(maxLength, right-left+1);
    }
    return maxLength;
}

let str1 = "AAABABBAA";
console.log(longestCharReplacement(str1, 2));
let str2 = "BBBB";
console.log(longestCharReplacement(str2, 2));