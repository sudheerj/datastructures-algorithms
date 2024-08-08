//TC: O(n) SC: O(n)
function reverseWordsInString1(str) {
  let words = str.trim().split(/\s+/);
  let i = 0, j = words.length - 1;

  while (i <= j) {
    [words[i], words[j]] = [words[j], words[i]];
    i++;
    j--;
  }
  return words.join(' ');
}

//TC: O(n) SC: O(n)
function reverseWordsInString2(str) {
  let words = str.trim().split(/\s+/);
  let result = "";

  for (let i = words.length - 1; i >= 0; i--) {
    result += words[i] + " ";
  }

  return result.slice(0, result.length - 1);
}

let str1 = "It is fun to learn DSA";
let str2 = "  hello DSA  ";
console.log(reverseWordsInString1(str1));
console.log(reverseWordsInString1(str2));

console.log(reverseWordsInString2(str1));
console.log(reverseWordsInString2(str2));
