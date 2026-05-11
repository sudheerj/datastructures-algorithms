/**
 * Palindrome Number
 *
 * Given an integer x, return true if x is a palindrome, false otherwise.
 *
 * Approach: Reverse all digits, compare with original.
 * TC: O(log10 n)  SC: O(1)
 */

function isPalindrome(num) {
  if (num < 0) return false;

  let original = num;
  let reverse = 0;

  while (num > 0) {
    reverse = reverse * 10 + (num % 10);
    num = Math.trunc(num / 10);
  }

  return original === reverse;
}

const testCases = [
  { num: 121, expected: true, label: "3-digit palindrome" },
  { num: -121, expected: false, label: "negative number" },
  { num: 10, expected: false, label: "trailing zero" },
  { num: 0, expected: true, label: "zero" },
  { num: 12321, expected: true, label: "5-digit odd palindrome" },
  { num: 1221, expected: true, label: "4-digit even palindrome" },
  { num: 123, expected: false, label: "not a palindrome" },
];

testCases.forEach(({ num, expected, label }) => {
  const result = isPalindrome(num);
  const status = result === expected ? "PASS" : "FAIL";
  console.log(
    `  [${status}] ${label}: ${num} → ${result} (expected ${expected})`,
  );
});
