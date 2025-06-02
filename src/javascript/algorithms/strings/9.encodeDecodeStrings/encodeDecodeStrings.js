/**
 * TC: O(n) SC: O(n)
 * Encodes a list of strings to a single string.
 * Uses length-prefix encoding with '#' as a delimiter.
 * @param {string[]} strs
 * @returns {string}
 */
function encodeStrings(strs) {
  let encodedStr = "";
  for (let str of strs) {
    encodedStr += str.length + "#" + str;
  }
  return encodedStr;
}

/**
 * Decodes a single string to a list of strings.
 * @param {string} str
 * @returns {string[]}
 */
function decodeString(str) {
  let decodedStrArr = [];
  let i = 0;
  while (i < str.length) {
    let j = i;
    while (str[j] !== "#" && j < str.length) j++;
    let wordLength = Number.parseInt(str.substring(i, j));
    let start = j + 1;
    let subStr = str.substring(start, start + wordLength);
    decodedStrArr.push(subStr);
    i = start + wordLength;
  }
  return decodedStrArr;
}

// Test cases
const testCases = [
  ["learn", "datastructure", "algorithms", "easily"],
  ["one", "two", "three"],
  ["", "a", ""],
  ["#", "##", "abc#def"],
  [],
  ["", ""],
];

for (const arr of testCases) {
  const encoded = encodeStrings(arr);
  const decoded = decodeString(encoded);
  console.log(
    `Input: ${JSON.stringify(
      arr
    )} | Encoded: "${encoded}" | Decoded: ${JSON.stringify(decoded)}`
  );
}
