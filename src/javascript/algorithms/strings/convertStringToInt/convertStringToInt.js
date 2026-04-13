// Convert String to Integer (atoi)
// TC: O(n), SC: O(1)

function myAtoi(str) {
  if (!str || str.length === 0) return 0;

  let i = 0;
  const n = str.length;
  const INT_MAX = 2147483647;
  const INT_MIN = -2147483648;

  // Skip leading whitespace
  while (i < n && str[i] === " ") i++;

  // Check sign
  let sign = 1;
  if (i < n && (str[i] === "+" || str[i] === "-")) {
    sign = str[i] === "-" ? -1 : 1;
    i++;
  }

  // Convert digits
  let result = 0;
  while (i < n && str[i] >= "0" && str[i] <= "9") {
    result = result * 10 + (str.charCodeAt(i) - 48);
    if (result * sign > INT_MAX) return INT_MAX;
    if (result * sign < INT_MIN) return INT_MIN;
    i++;
  }

  return result * sign;
}

// Test cases
const testCases = ["42", "   -42", "4193 with words", "", "   ", "+1", "words and 987", "-91283472332", "91283472332", "  0012a42"];
const expected  = [42,   -42,      4193,              0,  0,     1,    0,               -2147483648,    2147483647,    12];

for (let i = 0; i < testCases.length; i++) {
  const result = myAtoi(testCases[i]);
  const status = result === expected[i] ? "✓" : `✗ (expected ${expected[i]})`;
  console.log(`"${testCases[i]}" => ${result} ${status}`);
}
