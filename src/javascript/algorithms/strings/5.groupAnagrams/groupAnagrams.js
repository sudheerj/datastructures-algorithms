/**
 * Groups anagrams using character count as the key.
 * Time: O(m * n), Space: O(m * n)
 * @param {string[]} strs
 * @returns {string[][]}
 */
function groupAnagramByCount(strs) {
  const groupAnagramObj = {};

  for (const str of strs) {
    // Assumes lowercase a-z. For Unicode, use a Map instead of array.
    const charFrequency = new Array(26).fill(0);
    for (const ch of str) {
      charFrequency[ch.charCodeAt(0) - 97]++;
    }
    const key = charFrequency.join("#");
    if (groupAnagramObj[key]) {
      groupAnagramObj[key].push(str);
    } else {
      groupAnagramObj[key] = [str];
    }
  }
  return Object.values(groupAnagramObj);
}

/**
 * Groups anagrams by sorting each string.
 * Time: O(m * n log n), Space: O(m * n)
 * @param {string[]} strs
 * @returns {string[][]}
 */
function groupAnagramBySort(strs) {
  let groupAnagramObj = {};

  for (const str of strs) {
    const key = str.split("").sort().join("");
    if (groupAnagramObj[key]) {
      groupAnagramObj[key].push(str);
    } else {
      groupAnagramObj[key] = [str];
    }
  }
  return Object.values(groupAnagramObj);
}

// Test cases
const testCases = [
  ["eat", "tea", "tan", "ate", "nat", "bat"],
  ["hello"],
  ["", ""],
  ["abc", "bca", "cab", "bac", "acb", "cba"],
  ["a"],
  ["ab", "ba", "abc", "cab", "bac", "bca", "cba"],
];

for (const strs of testCases) {
  console.log("Input:", strs);
  console.log("By Count:", groupAnagramByCount(strs));
  console.log("By Sort:", groupAnagramBySort(strs));
  console.log("---");
}
