//TC: O(n) SC: O(n)
function encodeStrings(strs) {
  let encodedStr = "";
  for (let str of strs) {
    encodedStr += str.length + "#" + str;
  }
  return encodedStr;
}

function decodeString(str) {
  let decodedStrArr = [];
  let i = 0;
  while (i < str.length) {
    let j = i;
    while (str[j] != "#") j++;
    let start = j+1;
    let wordLength = Number.parseInt(str.substring(i, j));
    let subStr = str.substring(start, start + wordLength);
    decodedStrArr.push(subStr);
    i = start + wordLength;
  }
  return decodedStrArr;
}

let strs1 = ["learn", "datastructure", "algorithms", "easily"];
let encodedStr1 = encodeStrings(strs1);
console.log(encodedStr1);
console.log(decodeString(encodedStr1));

let strs2 = ["one", "two", "three"];
let encodedStr2 = encodeStrings(strs2);
console.log(encodedStr2);
console.log(decodeString(encodedStr2));
