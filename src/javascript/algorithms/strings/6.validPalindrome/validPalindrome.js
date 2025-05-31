/**
 * Checks if a string is a valid palindrome, considering only alphanumeric characters and ignoring cases.
 * @param {string} str
 * @returns {boolean}
 */
function isValidPalindrome1(str) {
  let left = 0,
    right = str.length - 1;
  while (left < right) {
      let ch1 = str[left];
      let ch2 = str[right];

      if(!isAlphanumeric1(ch1)) left++;
      else if(!isAlphanumeric1(ch2)) right--;
      else {
          if(ch1.toLowerCase() != ch2.toLowerCase()) {
              return false;
          }
          left++;
          right--;
      }
  }
  return true;
}

/**
 * Checks if a character is alphanumeric.
 * @param {string} char
 * @returns {boolean}
 */
function isAlphanumeric1(char) {
  return /^[a-zA-Z0-9]$/i.test(char);
}

//Two pointer without regex:- TC:O(n) SC: O(n)
function isValidPalindrome2(str) {
    if(str.length <=1) return true;

    let left = 0, right = str.length -1;
    while(left < right) {
        let ch1 = str[left];
        let ch2 = str[right];

        if(!isAlphanumeric2(ch1)) left++;
        else if(!isAlphanumeric2(ch2)) right--;
        else {
            if(ch1.toLowerCase() != ch2.toLowerCase()) {
                return false;
            }
            left++;
            right--;
        }
    }
    return true;
}

function isAlphanumeric2(char) {
    return (char.toLowerCase() >= 'a' && char.toLowerCase() <= 'z')
        || (char.toLowerCase() >= 'A' && char.toLowerCase() <= 'Z')
        || (char >= '0' && char <= '9');
}

// Test cases
const testCases = [
  { str: "A man, a plan, a canal: Panama", expected: true },
  { str: "Hello World", expected: false },
  { str: " ", expected: true },
  { str: "racecar", expected: true },
  { str: "No lemon, no melon", expected: true },
  { str: "12321", expected: true },
  { str: "123abccba321", expected: true },
  { str: "abc", expected: false },
];

for (const { str, expected } of testCases) {
  const result = isValidPalindrome1(str);
  const result1 = isValidPalindrome2(str);
  console.log(`Input: "${str}" | Output: ${result} | Expected: ${expected}`);
  console.log(`Input: "${str}" | Output: ${result1} | Expected: ${expected}`);

}
