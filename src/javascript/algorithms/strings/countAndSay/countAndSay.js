// Count and Say
// TC: O(n * m), SC: O(m)

function countAndSay(n) {
  let result = "1";

  for (let i = 1; i < n; i++) {
    let sb = "";
    let count = 1;

    for (let j = 1; j < result.length; j++) {
      if (result[j] === result[j - 1]) {
        count++;
      } else {
        sb += count + result[j - 1];
        count = 1;
      }
    }
    sb += count + result[result.length - 1];
    result = sb;
  }

  return result;
}

// Test cases
const testCases = [
  [1, "1"],
  [2, "11"],
  [3, "21"],
  [4, "1211"],
  [5, "111221"],
  [6, "312211"],
];

for (const [n, expected] of testCases) {
  const result = countAndSay(n);
  const status = result === expected ? "✓" : `✗ (expected "${expected}")`;
  console.log(`n=${n} => "${result}" ${status}`);
}
