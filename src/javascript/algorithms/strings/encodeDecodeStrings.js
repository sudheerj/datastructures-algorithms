//TC: O(n) SC: O(n)
function encodeStrings(strs) {
  let encodedStr = "";
  for (let str of strs) {
    encodedStr += str.length + "#" + str;
  }
  return encodedStr;
}

function decodeString(str) {
  let decodedStr = [];
  let i = 0;
  while (i < str.length) {
    let j = i;
    while (str[j] != "#") j++;
    let wordLength = Number.parseInt(str.substring(i, j));
    let subStr = str.substring(j + 1, j + 1 + wordLength);
    decodedStr.push(subStr);
    i = j + 1 + subStr.length;
  }
  return decodedStr;
}

let strs = ["lint", "code", "love", "you"];
let encodedStr = encodeStrings(strs);
console.log(encodedStr);
console.log(decodeString(encodedStr));
