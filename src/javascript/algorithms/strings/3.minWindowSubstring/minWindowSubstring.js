// Sliding window: TC: O(m + n), SC: O(m + n)
/**
 * Finds the minimum window substring of str that contains all the characters of subStr.
 * @param {string} str - The main string.
 * @param {string} subStr - The target substring.
 * @returns {string} The minimum window substring, or "" if no such window exists.
 */
function minWindowSubstring(str, subStr) {
    let windowStrCount = new Map();
    let subStrCount = new Map();

    let minLength = Number.MAX_VALUE;
    let subStrboundaries = [-1, -1];

    for(const ch of subStr) {
        subStrCount.set(ch, (subStrCount.get(ch) || 0) + 1);
    }

    let having = 0, required = subStrCount.size;
    let left = 0;

    for(let right = 0; right < str.length; right++) {
        let rightChar = str[right];

        if(subStrCount.has(rightChar)) {
            windowStrCount.set(rightChar, (windowStrCount.get(rightChar) || 0) +1);
            if(subStrCount.get(rightChar) === windowStrCount.get(rightChar)) {
                having++;
            }
        }

        while(required === having) {
            if(minLength > right-left+1) {
                minLength = right-left+1;
                subStrboundaries[0] = left;
                subStrboundaries[1] = right;
            }

            let leftChar = str[left];
            if(subStrCount.has(leftChar)) {
                windowStrCount.set(leftChar, windowStrCount.get(leftChar)-1);
                if(windowStrCount.get(leftChar) < subStrCount.get(leftChar)) {
                    having--;
                }
            }
            left++;
        }
    }

    return minLength === Number.MAX_VALUE ? "" : str.substring(subStrboundaries[0], subStrboundaries[1]+1);
}

// Test cases
const testCases = [
  { str: "ADOBECODEBANC", subStr: "ABC", expected: "BANC" },
  { str: "A", subStr: "A", expected: "A" },
  { str: "a", subStr: "aa", expected: "" },
  { str: "ab", subStr: "b", expected: "b" },
  { str: "ab", subStr: "a", expected: "a" },
  { str: "ab", subStr: "c", expected: "" },
];

for (const { str, subStr, expected } of testCases) {
  const result = minWindowSubstring(str, subStr);
  console.log(
    `Input: str="${str}", subStr="${subStr}" | Output: "${result}" | Expected: "${expected}"`
  );
}
