//TC: O(n) SC: O(n)
function reverseWordsInString1(str) {
  let words = str.trim().split("/s+/");
  let result = "";

  for (let i = words.length - 1; i >= 0; i--) {
    result += words[i] + " ";
  }

  return result.slice(0, result.length - 1);
}

//TC: O(n) SC: O(1)
function reverseWordsInString2(str) {
  let words = str.trim().split("/\s+/");
  let i = 0, j = str.length - 1;

  while (i <= j) {
    [words[i], words[j]] = [words[j], words[i]];
    i++;
    j--;
  }

  return words.join("");
}

let str1 = "the sky is blue";
let str2 = "  hello world  ";
console.log(reverseWordsInString1(str1));
console.log(reverseWordsInString1(str2));

console.log(reverseWordsInString2(str1));
console.log(reverseWordsInString2(str2));
