/**
 * Reverses the words in a string, removing extra spaces.
 * @param {string} str
 * @returns {string}
 */
//TC: O(n) SC: O(n)
function reverseWordsInString(str) {
  // Split by one or more whitespace, filter out empty, reverse, and join
  return str.trim().split(/\s+/).reverse().join(" ");
}

// Alternative implementation using manual two-pointer swap (for educational purposes)
//TC: O(n) SC: O(n)
function reverseWordsInStringManual(str) {
  let words = str.trim().split(/\s+/);
  let left = 0,
    right = words.length - 1;
  while (left < right) {
    [words[left], words[right]] = [words[right], words[left]];
    left++;
    right--;
  }
  return words.join(" ");
}

//TC: O(n) SC: O(n)
function reverseWordsInStringIteration(str) {
  let words = str.trim().split(/\s+/);
  let result = "";

  for (let i = words.length - 1; i >= 0; i--) {
    result += words[i] + " ";
  }

  return result.slice(0, result.length - 1);
}

// Test cases
const testCases = [
  { str: "It is fun to learn DSA", expected: "DSA learn to fun is It" },
  { str: "  hello DSA  ", expected: "DSA hello" },
  { str: "single", expected: "single" },
  { str: "   ", expected: "" },
  { str: "", expected: "" },
  { str: "a b  c   d", expected: "d c b a" },
];

for (const { str, expected } of testCases) {
  const result = reverseWordsInString(str);
  const manual = reverseWordsInStringManual(str);
  const iteration = reverseWordsInStringIteration(str);

    console.log(
    `Input: "${str}" | Output: "${result}" | Manual: "${manual}" | Iteration: "${iteration}" | Expected: "${expected}"`
  );
}
